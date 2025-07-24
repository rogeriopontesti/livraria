package com.rogeriopontesti.api.livraria.business.services;

import com.rogeriopontesti.api.livraria.business.exceptions.AutorNotFoundException;
import com.rogeriopontesti.api.livraria.infrastructure.config.Labels;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Autor;
import com.rogeriopontesti.api.livraria.infrastructure.repositories.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AutorService {

    @Autowired
    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public List<Autor> listarAutores(){
        return repository.findAll();
    }

    public Autor buscarAutorPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new AutorNotFoundException(Labels.getErroNotFoundAutor(id.toString())));
    }

    public List<Autor> buscarAutoresPorNome(String nome) {
        List<Autor> autores = repository.findByNomeContainingIgnoreCase(nome);
        if (autores.isEmpty()) {
            throw new AutorNotFoundException(Labels.getErroNotFoundAutor(nome));
        }
        return autores;
    }

    public void salvarAutor(Autor autor){
        repository.saveAndFlush(autor);
    }

    public void deleteAutor(Autor autor) {
        if (autor.getId() == null) {
            throw new AutorNotFoundException(Labels.getErroNullOrNonExistentId());
        }

        deleteAutorPorId(autor.getId());
    }

    public void deleteAutorPorId(UUID id){
        Autor autor = repository.findById(id)
                .orElseThrow(() -> new AutorNotFoundException(
                        Labels.getErroNotFoundAutor(id.toString())
                ));

        if (autor.getLivros() != null) {
            autor.getLivros().forEach(livro -> livro.getAutores().remove(autor));
            autor.setLivros(null);
        }

        repository.save(autor);
        repository.delete(autor);
    }

    public void atualizaAutorPorId(UUID id, Autor autor) {
        Autor autorEntity = repository.findById(id)
                .orElseThrow(() -> new AutorNotFoundException(
                        Labels.getErroNotFoundAutor(id.toString())
                ));

        if (autor.getNome() != null) {
            autorEntity.setNome(autor.getNome());
        }

        if (autor.getLivros() != null) {
            autorEntity.setLivros(autor.getLivros());
        }

        repository.save(autorEntity);
    }
}
