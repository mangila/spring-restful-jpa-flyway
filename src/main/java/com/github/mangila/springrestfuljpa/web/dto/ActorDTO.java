package com.github.mangila.springrestfuljpa.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.mangila.springrestfuljpa.web.dto.projection.DirectorProjectionDTO;
import com.github.mangila.springrestfuljpa.web.dto.projection.MovieProjectionDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.List;

@Data
@NoArgsConstructor
public class ActorDTO {
    private Long actorId;
    private String name;
    private List<String> nickNames;
    private URI picture;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DirectorProjectionDTO director;
    private List<MovieProjectionDTO> movies;
}
