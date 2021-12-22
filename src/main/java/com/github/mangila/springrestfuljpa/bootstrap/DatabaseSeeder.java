package com.github.mangila.springrestfuljpa.bootstrap;

import com.github.mangila.springrestfuljpa.persistence.entity.ActorEntity;
import com.github.mangila.springrestfuljpa.persistence.entity.MovieEntity;
import com.github.mangila.springrestfuljpa.persistence.entity.embeddable.Publisher;
import com.github.mangila.springrestfuljpa.persistence.repository.ActorRepository;
import com.github.mangila.springrestfuljpa.persistence.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
@AllArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
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

        actorRepository.saveAndFlush(actorEntity);
        movieRepository.saveAndFlush(movieEntity);
    }
}
