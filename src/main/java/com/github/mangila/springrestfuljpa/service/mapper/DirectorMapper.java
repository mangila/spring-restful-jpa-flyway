package com.github.mangila.springrestfuljpa.service.mapper;

import com.github.mangila.springrestfuljpa.persistence.entity.DirectorEntity;
import com.github.mangila.springrestfuljpa.web.dto.DirectorDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DirectorMapper {

    DirectorDTO toDto(DirectorEntity entity);

    List<DirectorDTO> toDto(List<DirectorEntity> entities);
}
