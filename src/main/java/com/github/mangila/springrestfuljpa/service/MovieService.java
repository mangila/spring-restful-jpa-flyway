package com.github.mangila.springrestfuljpa.service;

import com.github.mangila.springrestfuljpa.persistence.entity.MovieEntity;
import com.github.mangila.springrestfuljpa.persistence.repository.MovieRepository;
import com.github.mangila.springrestfuljpa.service.mapper.MovieMapper;
import com.github.mangila.springrestfuljpa.web.dto.MovieDTO;
import com.github.mangila.springrestfuljpa.web.dto.PageDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public PageDTO<MovieDTO> findAll(int page, int size) {
        Page<MovieEntity> pagination = repository.findAll(PageRequest.of(page, size));
        return PageDTO.<MovieDTO>builder()
                .content(mapper.toDto(pagination.toList()))
                .page(page)
                .size(size)
                .isFirst(pagination.isFirst())
                .isLast(pagination.isLast())
                .totalElements(pagination.getTotalElements())
                .hasNext(pagination.hasNext())
                .hasPrevious(pagination.hasPrevious())
                .totalPages(pagination.getTotalPages())
                .build();
    }
}
