package com.github.mangila.springrestfuljpa.service;

import com.github.mangila.springrestfuljpa.persistence.entity.MovieEntity;
import com.github.mangila.springrestfuljpa.persistence.repository.MovieRepository;
import com.github.mangila.springrestfuljpa.service.mapper.MovieMapper;
import com.github.mangila.springrestfuljpa.web.dto.MovieDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final MovieMapper mapper;

    public MovieDTO findById(Long id) {
        MovieEntity entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return mapper.toDto(entity);
    }

    public List<MovieDTO> findAll() {
        return mapper.toDto(repository.findAll());
    }
}
