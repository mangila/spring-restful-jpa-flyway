package com.github.mangila.springrestfuljpa.persistence.repository;

import com.github.mangila.springrestfuljpa.config.JpaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(JpaConfig.class)
class RepositoryTest {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private MovieRepository movieRepository;
}