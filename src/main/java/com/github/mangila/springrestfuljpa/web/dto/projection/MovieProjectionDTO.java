package com.github.mangila.springrestfuljpa.web.dto.projection;

import com.github.mangila.springrestfuljpa.persistence.entity.embeddable.Publisher;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;

@Data
@NoArgsConstructor
public class MovieProjectionDTO {
    private Long movieId;
    private String title;
    private Publisher publisher;
    private String genre;
    private URI banner;
}
