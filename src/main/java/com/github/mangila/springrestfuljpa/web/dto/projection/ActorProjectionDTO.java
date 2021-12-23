package com.github.mangila.springrestfuljpa.web.dto.projection;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.List;

@Data
@NoArgsConstructor
public class ActorProjectionDTO {
    private Long actorId;
    private String name;
    private List<String> nickNames;
    private URI picture;
}
