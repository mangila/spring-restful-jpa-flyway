package com.github.mangila.springrestfuljpa.web.controller;

import com.github.mangila.springrestfuljpa.service.DirectorService;
import com.github.mangila.springrestfuljpa.web.dto.DirectorDTO;
import com.github.mangila.springrestfuljpa.web.dto.PageDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/director")
@AllArgsConstructor
public class DirectorController {

    private final DirectorService service;

    @GetMapping
    public ResponseEntity<List<DirectorDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "pagination", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageDTO<DirectorDTO>> findAll(@RequestParam int page,
                                                        @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(service.findAll(page, size));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<DirectorDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
