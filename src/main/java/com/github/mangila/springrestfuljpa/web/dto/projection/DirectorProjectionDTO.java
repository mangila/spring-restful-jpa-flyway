package com.github.mangila.springrestfuljpa.web.dto.projection;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;

@Data
@NoArgsConstructor
public class DirectorProjectionDTO {
    private Long directorId;
    private String name;
    private URI picture;
}
