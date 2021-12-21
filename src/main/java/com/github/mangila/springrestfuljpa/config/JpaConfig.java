package com.github.mangila.springrestfuljpa.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.github.mangila.springrestfuljpa.persistence.entity")
@EnableJpaRepositories(basePackages = "com.github.mangila.springrestfuljpa.persistence.repository")
@EnableJpaAuditing
public class JpaConfig {
}
