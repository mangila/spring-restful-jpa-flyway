package com.github.mangila.springrestfuljpa.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ErrorDTO {
    private String message;
    private int value;
}
