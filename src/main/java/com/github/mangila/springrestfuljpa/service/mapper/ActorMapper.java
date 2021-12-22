package com.github.mangila.springrestfuljpa.service.mapper;

import com.github.mangila.springrestfuljpa.persistence.entity.ActorEntity;
import com.github.mangila.springrestfuljpa.web.dto.ActorDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ActorMapper {

    ActorDTO toDto(ActorEntity entity);

    List<ActorDTO> toDto(List<ActorEntity> entities);
}
