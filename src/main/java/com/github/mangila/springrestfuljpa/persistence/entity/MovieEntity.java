package com.github.mangila.springrestfuljpa.persistence.entity;

import com.github.mangila.springrestfuljpa.persistence.entity.audit.Auditable;
import com.github.mangila.springrestfuljpa.persistence.entity.converter.URIConverter;
import com.github.mangila.springrestfuljpa.persistence.entity.embeddable.Publisher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "movie")
public class MovieEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    private Long movieId;

    @Version
    private Long version;

    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "publisher_name"))
    })
    private Publisher publisher;

    @Convert(converter = URIConverter.class)
    private URI banner;

    @ManyToMany(targetEntity = ActorEntity.class, mappedBy = "movies", cascade = CascadeType.ALL)
    private final Set<ActorEntity> actors = new HashSet<>();

    public void addActor(ActorEntity actorEntity) {
        actors.add(actorEntity);
        actorEntity.getMovies().add(this);
    }

    public void removeActor(ActorEntity actorEntity) {
        actors.remove(actorEntity);
        actorEntity.getMovies().remove(this);
    }
}