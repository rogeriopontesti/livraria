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

    public void deleteAutor(Autor autor){
        repository.delete(autor);
    }

    public void deleteAutorPorId(UUID id){
        repository.deleteById(id);
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
