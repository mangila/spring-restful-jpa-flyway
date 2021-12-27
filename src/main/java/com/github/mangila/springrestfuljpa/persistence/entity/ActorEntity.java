package com.github.mangila.springrestfuljpa.persistence.entity;

import com.github.mangila.springrestfuljpa.persistence.entity.audit.Auditable;
import com.github.mangila.springrestfuljpa.persistence.entity.converter.URIConverter;
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
@Table(name = "actor")
@Entity
public class ActorEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false)
    private Long actorId;

    private String name;

    @OneToOne(mappedBy = "actor")
    private DirectorEntity director;

    @CollectionTable(name = "actor_nickname", joinColumns = @JoinColumn(name = "actor_id"))
    @Column(name = "nickname")
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private final Set<String> nickNames = new HashSet<>();

    @Convert(converter = URIConverter.class)
    private URI picture;

    @ManyToMany(targetEntity = MovieEntity.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "movies_actors",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private final Set<MovieEntity> movies = new HashSet<>();
}
