package com.github.mangila.springrestfuljpa.persistence.repository;


import com.github.mangila.springrestfuljpa.persistence.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<ActorEntity, Long> {
}