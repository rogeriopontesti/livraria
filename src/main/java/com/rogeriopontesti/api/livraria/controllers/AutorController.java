package com.rogeriopontesti.api.livraria.controllers;

import com.rogeriopontesti.api.livraria.business.services.AutorService;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Autor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService service;

    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores(){
        return ResponseEntity.ok(service.listarAutores());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Autor>> listarAutoresPorNome(@PathVariable String nome){
        List<Autor> autores = service.buscarAutoresPorNome(nome);
        if (autores.isEmpty()) {
            return ResponseEntity.noContent().build();  // HTTP 204
        }
        return ResponseEntity.ok(autores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarAutor(@PathVariable UUID id){
        return ResponseEntity.ok(service.buscarAutorPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> salvarAutor(@RequestBody Autor autor){
        service.salvarAutor(autor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAutorPorId(@RequestParam UUID id){
        service.deleteAutorPorId(id);
        return ResponseEntity.ok().build();
    }

}
