package com.github.mangila.springrestfuljpa.persistence.repository;

import com.github.mangila.springrestfuljpa.config.JpaConfig;
import com.github.mangila.springrestfuljpa.persistence.entity.ActorEntity;
import com.github.mangila.springrestfuljpa.persistence.entity.MovieEntity;
import com.github.mangila.springrestfuljpa.persistence.entity.embeddable.Publisher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(JpaConfig.class)
class RepositoryTest {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private MovieRepository movieRepository;

    @BeforeEach
    void init() {
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setName("Mangila");
        actorEntity.setPicture(URI.create("http://www.mangila.tech"));
        actorEntity.getNickNames().add("Man");
        actorEntity.getNickNames().add("Gila");

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName("The silence of the lambda");
        Publisher publisher = new Publisher();
        publisher.setName("Mangila Studios");
        movieEntity.setPublisher(publisher);
        movieEntity.setBanner(URI.create("http://www.mangila.tech"));
        movieEntity.addActor(actorEntity);

        actorRepository.save(actorEntity);
        movieRepository.save(movieEntity);
    }

    @AfterEach
    void cleanUp() {
        actorRepository.deleteAll();
        movieRepository.deleteAll();
    }

    @Test
    void shouldPersistManyToMany() {
        var actor = actorRepository.findById(1L);
        var movie = movieRepository.findById(1L);
        assertThat(actor).isPresent();
        assertThat(movie).isPresent();
        assertThat(actor.get().getMovies()).hasSize(1);
        assertThat(movie.get().getActors()).hasSize(1);
    }

}