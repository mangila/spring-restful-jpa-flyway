package com.github.mangila.springrestfuljpa.web.controller;

import com.github.mangila.springrestfuljpa.service.ActorService;
import com.github.mangila.springrestfuljpa.web.dto.ActorDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/actor")
@AllArgsConstructor
public class ActorController {

    private final ActorService service;

    @GetMapping
    public ResponseEntity<List<ActorDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ActorDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
