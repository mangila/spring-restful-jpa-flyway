package com.github.mangila.springrestfuljpa.persistence.entity.embeddable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Publisher {
    private String name;
}
