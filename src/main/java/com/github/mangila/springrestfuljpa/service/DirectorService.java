package com.github.mangila.springrestfuljpa.service;

import com.github.mangila.springrestfuljpa.persistence.entity.DirectorEntity;
import com.github.mangila.springrestfuljpa.persistence.repository.DirectorRepository;
import com.github.mangila.springrestfuljpa.service.mapper.DirectorMapper;
import com.github.mangila.springrestfuljpa.web.dto.DirectorDTO;
import com.github.mangila.springrestfuljpa.web.dto.PageDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class DirectorService {

    private final DirectorRepository repository;
    private final DirectorMapper mapper;

    public DirectorDTO findById(Long id) {
        DirectorEntity entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return mapper.toDto(entity);
    }

    public List<DirectorDTO> findAll() {
        return mapper.toDto(repository.findAll());
    }

    public PageDTO<DirectorDTO> findAll(int page, int size) {
        Page<DirectorEntity> pagination = repository.findAll(PageRequest.of(page, size));
        return PageDTO.<DirectorDTO>builder()
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
