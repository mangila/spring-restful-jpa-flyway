package com.github.mangila.springrestfuljpa.web.controller;

import com.github.mangila.springrestfuljpa.service.MovieService;
import com.github.mangila.springrestfuljpa.web.dto.MovieDTO;
import com.github.mangila.springrestfuljpa.web.dto.PageDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService service;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "pagination", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageDTO<MovieDTO>> findAll(@RequestParam int page,
                                                     @RequestParam(defaultValue = "3") int size) {
        return ResponseEntity.ok(service.findAll(page, size));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
