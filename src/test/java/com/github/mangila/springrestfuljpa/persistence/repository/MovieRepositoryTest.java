package com.github.mangila.springrestfuljpa.persistence.repository;

import com.github.mangila.springrestfuljpa.config.JpaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(excludeAutoConfiguration = TestDatabaseAutoConfiguration.class)
@Import(value = {JpaConfig.class})
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:h2:mem:moviedb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=MYSQL",
        "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect",
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.jpa.properties.hibernate.dialect.storage_engine=innodb"
})
class MovieRepositoryTest {

    @Autowired
    private MovieRepository repository;

    @Test
    void test() {
        assertThat(repository.findAll()).isEmpty();
    }

}