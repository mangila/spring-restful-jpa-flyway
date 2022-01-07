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
class DirectorServiceTest {

    @Autowired
    private DirectorService service;

    @Test
    void test() {
        assertThat(service.findAll()).isEmpty();
    }

}