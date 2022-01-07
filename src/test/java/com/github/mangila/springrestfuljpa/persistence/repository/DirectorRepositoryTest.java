package com.github.mangila.springrestfuljpa.persistence.repository;

import com.github.mangila.springrestfuljpa.bootstrap.DatabaseSeeder;
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
@Import(value = {JpaConfig.class, DatabaseSeeder.class})
@Testcontainers
@ActiveProfiles("testcontainer-mysql")
class DirectorRepositoryTest {

    @Autowired
    private DirectorRepository repository;

    @Test
    void shouldFindAll() {
        assertThat(repository.findAll()).isNotEmpty();
    }

    @Test
    void shouldFindOne() {
        assertThat(repository.findById(1L)).isNotEmpty();
    }
}