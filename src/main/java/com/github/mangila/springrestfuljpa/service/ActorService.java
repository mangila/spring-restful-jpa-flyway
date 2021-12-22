package com.github.mangila.springrestfuljpa.service;

import com.github.mangila.springrestfuljpa.persistence.entity.ActorEntity;
import com.github.mangila.springrestfuljpa.persistence.repository.ActorRepository;
import com.github.mangila.springrestfuljpa.service.mapper.ActorMapper;
import com.github.mangila.springrestfuljpa.web.dto.ActorDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ActorService {

    private final ActorRepository repository;
    private final ActorMapper mapper;

    public ActorDTO findById(Long id) {
        ActorEntity entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return mapper.toDto(entity);
    }

    public List<ActorDTO> findAll() {
        return mapper.toDto(repository.findAll());
    }
}
