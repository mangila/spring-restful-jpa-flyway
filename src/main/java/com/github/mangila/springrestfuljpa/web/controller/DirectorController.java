package com.github.mangila.springrestfuljpa.web.controller;

import com.github.mangila.springrestfuljpa.service.DirectorService;
import com.github.mangila.springrestfuljpa.web.dto.DirectorDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path = "{id}")
    public ResponseEntity<DirectorDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
