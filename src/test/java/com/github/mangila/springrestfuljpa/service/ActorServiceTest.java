package com.github.mangila.springrestfuljpa.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
@Slf4j
class ActorServiceTest {

    @Container
    private final MySQLContainer<?> container = new MySQLContainer<>(DockerImageName.parse("mysql:8.0"))
            .withLogConsumer(new Slf4jLogConsumer(log));

    @Autowired
    private ActorService service;

    @Test
    void test() {
        assertThat(service.findAll()).isEmpty();
    }

}