package com.github.mangila.springrestfuljpa.persistence.repository;

import com.github.mangila.springrestfuljpa.persistence.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<DirectorEntity, Long> {
}
