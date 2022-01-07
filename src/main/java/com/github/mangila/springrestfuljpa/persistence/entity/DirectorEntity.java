package com.github.mangila.springrestfuljpa.persistence.entity;

import com.github.mangila.springrestfuljpa.persistence.entity.audit.Auditable;
import com.github.mangila.springrestfuljpa.persistence.entity.converter.URIConverter;
import lombok.*;

import javax.persistence.*;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "director")
@Entity
public class DirectorEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_id", nullable = false)
    private Long directorId;

    private String name;

    @Convert(converter = URIConverter.class)
    private URI picture;

    @Setter(AccessLevel.NONE)
    @OneToOne(optional = true, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_id")
    private ActorEntity actor;

    @OneToMany(targetEntity = MovieEntity.class, mappedBy = "director", fetch = FetchType.EAGER)
    private final Set<MovieEntity> movies = new HashSet<>();

    public void isActor(ActorEntity entity) {
        this.actor = entity;
    }
}