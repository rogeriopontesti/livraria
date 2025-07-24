package com.rogeriopontesti.api.livraria.controllers;

import com.rogeriopontesti.api.livraria.business.records.responses.LivroRecordResponse;
import com.rogeriopontesti.api.livraria.business.services.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    @Autowired
    public final LivroService service;

    @GetMapping
    public ResponseEntity<List<LivroRecordResponse>> listarLivros(){
        List<LivroRecordResponse> livros = service.listarLivros();
        if (livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroRecordResponse> buscarLivro(@PathVariable UUID id) {
        LivroRecordResponse livro = service.buscarLivroPorId(id);
        if (livro == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livro);
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<LivroRecordResponse>> listarLivrosPorNome(@PathVariable String titulo) {
        List<LivroRecordResponse> livros = service.buscarLivrosPorTitulo(titulo);
        if (livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/editora/{nome}")
    public ResponseEntity<List<LivroRecordResponse>> listarLivrosPorEditora(@PathVariable String nome) {
        List<LivroRecordResponse> livros = service.buscarLivrosPorNomeDaEditora(nome);
        if (livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livros);
    }
}
