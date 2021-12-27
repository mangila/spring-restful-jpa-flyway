package com.github.mangila.springrestfuljpa.bootstrap;

import com.github.mangila.springrestfuljpa.persistence.entity.ActorEntity;
import com.github.mangila.springrestfuljpa.persistence.entity.DirectorEntity;
import com.github.mangila.springrestfuljpa.persistence.entity.MovieEntity;
import com.github.mangila.springrestfuljpa.persistence.entity.embeddable.Publisher;
import com.github.mangila.springrestfuljpa.persistence.entity.constant.Genre;
import com.github.mangila.springrestfuljpa.persistence.repository.ActorRepository;
import com.github.mangila.springrestfuljpa.persistence.repository.DirectorRepository;
import com.github.mangila.springrestfuljpa.persistence.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        var moviesResource = new ClassPathResource("data/movies.csv");
        var actorsResource = new ClassPathResource("data/actors.csv");
        var directorsResource = new ClassPathResource("data/directors.csv");

        try (var movieReader = new BufferedReader(new InputStreamReader(moviesResource.getInputStream()));
             var actorReader = new BufferedReader(new InputStreamReader(actorsResource.getInputStream()));
             var directorReader = new BufferedReader(new InputStreamReader(directorsResource.getInputStream()))) {

            var movies = movieReader.lines()
                    .map(line -> line.split(","))
                    .map(this::buildMovie)
                    .collect(Collectors.toList());

            var actors = actorReader.lines()
                    .map(line -> line.split(","))
                    .map(this::buildActor)
                    .collect(Collectors.toList());

            var directors = directorReader.lines()
                    .map(line -> line.split(","))
                    .map(this::buildDirector)
                    .collect(Collectors.toList());

            movies.forEach(movie -> {
                // generate 20 random numbers, get from actors list and add actor to movie.
                ThreadLocalRandom.current()
                        .ints(0, actors.size() - 1)
                        .limit(20)
                        .mapToObj(actors::get)
                        .forEach(movie::addActor);

                // generate 1 random number, get from directors list and add director to movie.
                ThreadLocalRandom.current()
                        .ints(0, directors.size() - 1)
                        .limit(1)
                        .mapToObj(directors::get)
                        .forEach(movie::addDirector);
            });

            actorRepository.saveAll(actors);
            directorRepository.saveAll(directors);
            movieRepository.saveAll(movies);

            var persistedActors = actorRepository.findAll();
            // generate 10 random numbers, map actor also as a director.
            var directingActors = ThreadLocalRandom.current()
                    .ints(0, persistedActors.size() - 1)
                    .limit(10)
                    .mapToObj(persistedActors::get)
                    .map(actor -> {
                        final DirectorEntity director = new DirectorEntity();
                        director.setName(actor.getName());
                        director.setPicture(actor.getPicture());
                        director.isActor(actor);
                        return director;
                    }).collect(Collectors.toList());

            directorRepository.saveAll(directingActors);

        }
    }

    private MovieEntity buildMovie(String[] split) {
        String title = split[0];
        String publisherName = split[1];
        URI banner = URI.create(split[2]);
        Genre randomGenre = Genre.values()[ThreadLocalRandom.current().nextInt(0,4)];
        return MovieEntity.builder()
                .title(title)
                .publisher(Publisher.builder().name(publisherName).build())
                .banner(banner)
                .genre(randomGenre)
                .build();
    }

    private ActorEntity buildActor(String[] split) {
        String name = split[0];
        URI picture = URI.create(split[1]);
        String nickName = split[2];
        var actor = ActorEntity.builder()
                .name(name)
                .picture(picture)
                .build();
        actor.getNickNames().add(nickName);
        return actor;
    }

    private DirectorEntity buildDirector(String[] split) {
        String name = split[0];
        URI picture = URI.create(split[1]);
        return DirectorEntity.builder()
                .name(name)
                .picture(picture)
                .build();
    }

}
