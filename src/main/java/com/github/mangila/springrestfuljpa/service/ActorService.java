package com.github.mangila.springrestfuljpa.service;

import com.github.mangila.springrestfuljpa.persistence.entity.ActorEntity;
import com.github.mangila.springrestfuljpa.persistence.repository.ActorRepository;
import com.github.mangila.springrestfuljpa.service.mapper.ActorMapper;
import com.github.mangila.springrestfuljpa.web.dto.ActorDTO;
import com.github.mangila.springrestfuljpa.web.dto.PageDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public PageDTO<ActorDTO> findAll(int page) {
        Page<ActorEntity> pagination = repository.findAll(PageRequest.of(page, 10));
        return PageDTO.<ActorDTO>builder()
                .content(mapper.toDto(pagination.toList()))
                .page(page)
                .size(10)
                .isFirst(pagination.isFirst())
                .isLast(pagination.isLast())
                .totalElements(pagination.getTotalElements())
                .hasNext(pagination.hasNext())
                .hasPrevious(pagination.hasPrevious())
                .totalPages(pagination.getTotalPages())
                .build();
    }
}
