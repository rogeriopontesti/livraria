package com.rogeriopontesti.api.livraria.business.services;

import com.rogeriopontesti.api.livraria.business.exceptions.AutorNotFoundException;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Autor;
import com.rogeriopontesti.api.livraria.infrastructure.repositories.AutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public void salvarAutor(Autor autor){
        repository.saveAndFlush(autor);
    }

    public List<Autor> listarAutores(){
        return repository.findAll();
    }

    public Autor buscarAutorPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new AutorNotFoundException(id));
    }

    public List<Autor> buscarAutoresPorNome(String nome) {
        List<Autor> autores = repository.findByNomeContainingIgnoreCase(nome);
        if (autores.isEmpty()) {
            throw new AutorNotFoundException(nome);
        }
        return autores;
    }

    public void deleteAutor(Autor autor) {
        if (autor.getId() == null) {
            throw new AutorNotFoundException("ID do autor não informado.");
        }

        Autor autorAtual = repository.findById(autor.getId())
                .orElseThrow(() -> new AutorNotFoundException(autor.getId()));

        if (autorAtual.getLivros() != null) {
            autorAtual.getLivros().forEach(livro -> livro.getAutores().remove(autorAtual));
            autorAtual.setLivros(null);
        }

        repository.save(autorAtual);
        repository.delete(autorAtual);
    }

    public void deleteAutorPorId(UUID id){
        Autor autor = repository.findById(id)
                .orElseThrow(() -> new AutorNotFoundException(id));

        if (autor.getLivros() != null) {
            autor.getLivros().forEach(livro -> livro.getAutores().remove(autor));
            autor.setLivros(null);
        }

        repository.save(autor);
        repository.delete(autor);
    }

    public void atualizaAutorPorId(UUID id, Autor autor) {
        Autor autorEntity = repository.findById(id)
                .orElseThrow(() -> new AutorNotFoundException(id));

        if (autor.getNome() != null) {
            autorEntity.setNome(autor.getNome());
        }

        if (autor.getLivros() != null) {
            autorEntity.setLivros(autor.getLivros());
        }

        repository.save(autorEntity);
    }
}
