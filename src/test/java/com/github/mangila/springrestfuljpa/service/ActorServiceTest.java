package com.github.mangila.springrestfuljpa.service;

import com.github.mangila.springrestfuljpa.bootstrap.DatabaseSeeder;
import com.github.mangila.springrestfuljpa.config.JpaConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@Slf4j
@SpringBootTest
@Import({JpaConfig.class, DatabaseSeeder.class})
class ActorServiceTest {

    private static final MySQLContainer<?> CONTAINER = new MySQLContainer<>(DockerImageName.parse("mysql:8.0"))
            .withLogConsumer(new Slf4jLogConsumer(log))
            .withUsername("root")
            .withPassword("root");

    @Autowired
    private ActorService service;

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", CONTAINER::getUsername);
        registry.add("spring.datasource.password", CONTAINER::getPassword);
        registry.add("spring.datasource.driverClassName", CONTAINER::getDriverClassName);
        registry.add("spring.jpa.database-platform", () -> "org.hibernate.dialect.MySQL8Dialect");
    }

    @BeforeAll
    static void startContainer() {
        CONTAINER.start();
    }

    @AfterAll
    static void stopContainer() {
        CONTAINER.stop();
    }

    @Test
    void test() {
        assertThat(service.findAll()).isNotEmpty();
    }

}