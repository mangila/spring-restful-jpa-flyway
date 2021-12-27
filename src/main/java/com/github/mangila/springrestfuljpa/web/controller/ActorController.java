package com.github.mangila.springrestfuljpa.web.controller;

import com.github.mangila.springrestfuljpa.service.ActorService;
import com.github.mangila.springrestfuljpa.web.dto.ActorDTO;
import com.github.mangila.springrestfuljpa.web.dto.PageDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "pagination")
    public ResponseEntity<PageDTO<ActorDTO>> findAll(@RequestParam int page) {
        return ResponseEntity.ok(service.findAll(page));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ActorDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
