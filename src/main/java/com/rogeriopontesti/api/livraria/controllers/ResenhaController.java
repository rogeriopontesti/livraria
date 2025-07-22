package com.rogeriopontesti.api.livraria.controllers;

import com.rogeriopontesti.api.livraria.business.services.ResenhaService;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Editora;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Resenha;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/resenhas")
@RequiredArgsConstructor
public class ResenhaController {

    private final ResenhaService service;

    @GetMapping
    public ResponseEntity<List<Resenha>> listarRsenhas(){
        return ResponseEntity.ok(service.listarResenhas());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Resenha>> listarResenhasPorTexto(@PathVariable String texto){
        List<Resenha> resenhas = service.buscarResenhasPorTexto(texto);
        if (resenhas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resenhas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resenha> buscarResenha(@PathVariable UUID id){
        return ResponseEntity.ok(service.buscarResenhaPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> buscarResenha(@RequestBody Resenha resenha) {
        service.salvarResenha(resenha);
        return ResponseEntity
                .created(URI.create("/editoras/" + resenha.getId()))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarResenhaPorId(@PathVariable UUID id) {
        service.deleteResenhaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarResenha(@RequestBody Resenha resenha) {
        service.deleteResenha(resenha);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarResenha(@PathVariable UUID id, @RequestBody Resenha resenha) {
        service.atualizaResenhaPorId(id, resenha);
        return ResponseEntity.noContent().build();
    }
}
