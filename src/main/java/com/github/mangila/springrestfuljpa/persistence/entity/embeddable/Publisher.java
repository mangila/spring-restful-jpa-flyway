package com.github.mangila.springrestfuljpa.persistence.entity.embeddable;

import lombok.*;

import javax.persistence.Embeddable;

@Builder
@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    private String name;
}
