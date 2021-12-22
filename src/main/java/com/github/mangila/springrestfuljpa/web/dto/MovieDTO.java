package com.github.mangila.springrestfuljpa.web.dto;


import com.github.mangila.springrestfuljpa.persistence.entity.embeddable.Publisher;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.List;

@Data
@NoArgsConstructor
public class MovieDTO {
    private Long movieId;
    private String name;
    private Publisher publisher;
    private URI banner;
    private List<ActorProjectionDTO> actors;

    @Data
    @NoArgsConstructor
    public static class ActorProjectionDTO {
        private Long actorId;
        private String name;
        private List<String> nickNames;
        private URI picture;
    }
}
