package com.github.mangila.springrestfuljpa.web.dto;


import com.github.mangila.springrestfuljpa.persistence.entity.embeddable.Publisher;
import com.github.mangila.springrestfuljpa.web.dto.projection.ActorProjectionDTO;
import com.github.mangila.springrestfuljpa.web.dto.projection.DirectorProjectionDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.List;

@Data
@NoArgsConstructor
public class MovieDTO {
    private Long movieId;
    private String title;
    private Publisher publisher;
    private URI banner;
    private String genre;
    private DirectorProjectionDTO director;
    private List<ActorProjectionDTO> actors;
}
