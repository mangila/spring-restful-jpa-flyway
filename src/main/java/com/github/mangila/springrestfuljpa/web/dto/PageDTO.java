package com.github.mangila.springrestfuljpa.web.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageDTO<T> {
    private List<T> content;
    private Integer page;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
    private Boolean isFirst;
    private Boolean isLast;
    private Boolean hasNext;
    private Boolean hasPrevious;
}
