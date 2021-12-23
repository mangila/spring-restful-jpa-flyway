package com.github.mangila.springrestfuljpa.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.mangila.springrestfuljpa.web.dto.projection.ActorProjectionDTO;
import com.github.mangila.springrestfuljpa.web.dto.projection.MovieProjectionDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.List;

@Data
@NoArgsConstructor
public class DirectorDTO {
    private Long directorId;
    private String name;
    private URI picture;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ActorProjectionDTO actor;
    private List<MovieProjectionDTO> movies;
}
