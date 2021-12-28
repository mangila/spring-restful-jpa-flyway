package com.github.mangila.springrestfuljpa.persistence.repository;

import com.github.mangila.springrestfuljpa.bootstrap.DatabaseSeeder;
import com.github.mangila.springrestfuljpa.config.JpaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(value = {JpaConfig.class, DatabaseSeeder.class})
class ActorRepositoryTest {

    @Autowired
    private ActorRepository repository;

    @Test
    void test() {
        assertThat(repository.findAll()).isNotEmpty();
    }

}