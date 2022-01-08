package com.github.mangila.springrestfuljpa.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Testcontainers
@ActiveProfiles("testcontainer-mysql")
class ActorServiceTest {

    @Autowired
    private ActorService service;

    @Test
    void shouldFindAll() {
        assertThat(service.findAll()).isNotEmpty();
    }

    @Test
    void shouldFindOne() {
        assertThat(service.findById(1L)).isNotNull();
    }

    @Test
    void shouldThrow() {
        assertThatThrownBy(() -> service.findById(-1L)).isInstanceOf(NoSuchElementException.class);
    }

}