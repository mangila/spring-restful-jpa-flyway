package com.github.mangila.springrestfuljpa.persistence.entity;

import com.github.mangila.springrestfuljpa.persistence.entity.audit.Auditable;
import com.github.mangila.springrestfuljpa.persistence.entity.converter.URIConverter;
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
@Entity(name = "actor")
public class ActorEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false)
    private Long actorId;

    @Version
    private Long version;

    private String name;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private final Set<String> nickNames = new HashSet<>();

    @Convert(converter = URIConverter.class)
    private URI picture;

    @ManyToMany(targetEntity = MovieEntity.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private final Set<MovieEntity> movies = new HashSet<>();
}
