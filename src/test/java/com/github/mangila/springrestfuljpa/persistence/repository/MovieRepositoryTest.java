package com.github.mangila.springrestfuljpa.persistence.repository;

import com.github.mangila.springrestfuljpa.config.JpaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(excludeAutoConfiguration = TestDatabaseAutoConfiguration.class)
@Import(value = {JpaConfig.class})
@Testcontainers
@ActiveProfiles("testcontainer-mysql")
class MovieRepositoryTest {

    @Autowired
    private MovieRepository repository;

    @Test
    void test() {
        assertThat(repository.findAll()).isEmpty();
    }

}