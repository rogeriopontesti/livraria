package com.rogeriopontesti.api.livraria.business.services;

import com.rogeriopontesti.api.livraria.business.exceptions.AutorNotFoundException;
import com.rogeriopontesti.api.livraria.business.exceptions.LivroNotFoundException;
import com.rogeriopontesti.api.livraria.business.records.responses.LivroRecordResponse;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Autor;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Livro;
import com.rogeriopontesti.api.livraria.infrastructure.repositories.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class LivroService {

    @Autowired
    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<LivroRecordResponse> listarLivros(){
        List<Livro> livros = repository.findAll();
        return livros.stream()
                .map(livro -> new LivroRecordResponse(
                        livro.getId(),
                        livro.getTitulo(),
                        livro.getEditora() != null ? livro.getEditora().getNome() : null,
                        livro.getAutores() != null
                                ? livro.getAutores().stream().map(autor -> autor.getNome()).toList()
                                : List.of(),
                        livro.getResenha() != null ? livro.getResenha().getResenha() : null
                )).toList();
    }

    public LivroRecordResponse buscarLivroPorId(UUID id) {
        Livro livro = repository.findById(id)
                .orElseThrow(() -> new LivroNotFoundException(id));

        return new LivroRecordResponse(
                livro.getId(),
                livro.getTitulo(),
                livro.getEditora() != null ? livro.getEditora().getNome() : null,
                livro.getAutores() != null
                        ? livro.getAutores().stream().map(autor -> autor.getNome()).toList()
                        : List.of(),
                livro.getResenha() != null ? livro.getResenha().getResenha() : null
        );
    }

    public List<LivroRecordResponse> buscarLivrosPorTitulo(String titulo) {
        List<Livro> livros = repository.findByTituloContainingIgnoreCase(titulo);
        if (livros.isEmpty()) {
            throw new LivroNotFoundException(titulo);
        }
        return livros.stream()
                .map(livro -> new LivroRecordResponse(
                        livro.getId(),
                        livro.getTitulo(),
                        livro.getEditora() != null ? livro.getEditora().getNome() : null,
                        livro.getAutores() != null
                                ? livro.getAutores().stream().map(autor -> autor.getNome()).toList()
                                : List.of(),
                        livro.getResenha() != null ? livro.getResenha().getResenha() : null
                )).toList();
    }

    public List<LivroRecordResponse> buscarLivrosPorNomeDaEditora(String nomeEditora) {
        List<Livro> livros = repository.findByEditora_NomeContainingIgnoreCase(nomeEditora);
        if (livros.isEmpty()) {
            throw new LivroNotFoundException(nomeEditora);
        }
        return livros.stream()
                .map(livro -> new LivroRecordResponse(
                        livro.getId(),
                        livro.getTitulo(),
                        livro.getEditora() != null ? livro.getEditora().getNome() : null,
                        livro.getAutores() != null
                                ? livro.getAutores().stream().map(Autor::getNome).toList()
                                : List.of(),
                        livro.getResenha() != null ? livro.getResenha().getResenha() : null
                ))
                .toList();
    }
}
