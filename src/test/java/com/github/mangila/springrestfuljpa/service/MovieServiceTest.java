package com.github.mangila.springrestfuljpa.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
@ActiveProfiles("testcontainer-mysql")
class MovieServiceTest {

    @Autowired
    private MovieService service;

    @Test
    void shouldFindAll() {
        assertThat(service.findAll()).isNotEmpty();
    }

    @Test
    void shouldFindOne() {
        assertThat(service.findById(1L)).isNotNull();
    }

}