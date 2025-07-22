package com.rogeriopontesti.api.livraria.controllers;

import com.rogeriopontesti.api.livraria.business.services.EditoraService;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Autor;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Editora;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/editoras")
@RequiredArgsConstructor
public class EditoraController {

    private final EditoraService service;

    @GetMapping
    public ResponseEntity<List<Editora>> listarEditoras(){
        return ResponseEntity.ok(service.listarEditoras());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Editora>> listarEditorasPorNome(@PathVariable String nome){
        List<Editora> editoras = service.buscarEditorasPorNome(nome);
        if (editoras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(editoras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> buscarEditora(@PathVariable UUID id){
        return ResponseEntity.ok(service.buscarEditoraPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> salvarEditora(@RequestBody Editora editora) {
        service.salvarAutor(editora);
        return ResponseEntity
                .created(URI.create("/editoras/" + editora.getId()))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEditoraPorId(@PathVariable UUID id) {
        service.deleteEditoraPorId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarEditora(@RequestBody Editora editora) {
        service.deleteEditora(editora);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarEditora(@PathVariable UUID id, @RequestBody Editora editora) {
        service.atualizaEditoraEditoraPorId(id, editora);
        return ResponseEntity.noContent().build();
    }

}
