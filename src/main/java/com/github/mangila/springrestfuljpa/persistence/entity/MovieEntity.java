package com.github.mangila.springrestfuljpa.persistence.entity;

import com.github.mangila.springrestfuljpa.persistence.entity.audit.Auditable;
import com.github.mangila.springrestfuljpa.persistence.entity.converter.URIConverter;
import com.github.mangila.springrestfuljpa.persistence.entity.embeddable.Publisher;
import com.github.mangila.springrestfuljpa.persistence.entity.constant.Genre;
import lombok.*;

import javax.persistence.*;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movie")
@Entity
public class MovieEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    private Long movieId;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Setter(AccessLevel.NONE)
    @ManyToOne(targetEntity = DirectorEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private DirectorEntity director;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "publisher_name"))
    })
    private Publisher publisher;

    @Convert(converter = URIConverter.class)
    private URI banner;

    @ManyToMany(targetEntity = ActorEntity.class, mappedBy = "movies", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<ActorEntity> actors = new HashSet<>();

    public void addActor(ActorEntity actorEntity) {
        actors.add(actorEntity);
        actorEntity.getMovies().add(this);
    }

    public void addDirector(DirectorEntity directorEntity) {
        this.director = directorEntity;
        directorEntity.getMovies().add(this);
    }

    public void removeActor(ActorEntity actorEntity) {
        actors.remove(actorEntity);
        actorEntity.getMovies().remove(this);
    }

    public void removeDirector(DirectorEntity directorEntity) {
        this.director = null;
        directorEntity.getMovies().remove(this);
    }
}