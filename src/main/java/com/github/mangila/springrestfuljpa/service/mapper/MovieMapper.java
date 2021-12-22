package com.github.mangila.springrestfuljpa.service.mapper;

import com.github.mangila.springrestfuljpa.persistence.entity.MovieEntity;
import com.github.mangila.springrestfuljpa.web.dto.MovieDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MovieMapper {

    MovieDTO toDto(MovieEntity entity);

    List<MovieDTO> toDto(List<MovieEntity> entities);
}
