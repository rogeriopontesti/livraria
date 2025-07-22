package com.rogeriopontesti.api.livraria.business.services;

import com.rogeriopontesti.api.livraria.business.exceptions.AutorNotFoundException;
import com.rogeriopontesti.api.livraria.business.exceptions.ResenhaNotFoundException;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Autor;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Resenha;
import com.rogeriopontesti.api.livraria.infrastructure.repositories.ResenhaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ResenhaService {

    private final ResenhaRepository repository;

    public ResenhaService(ResenhaRepository repository) {
        this.repository = repository;
    }

    public void salvarResenha(Resenha resenha){
        repository.saveAndFlush(resenha);
    }

    public List<Resenha> listarResenhas(){
        return repository.findAll();
    }

    public Resenha buscarResenhaPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResenhaNotFoundException(id));
    }

    public List<Resenha> buscarResenhasPorNome(String nome) {
        List<Resenha> resenha = repository.findByNomeContainingIgnoreCase(nome);
        if (resenha.isEmpty()) {
            throw new ResenhaNotFoundException(nome);
        }
        return resenha;
    }

    public void deleteResenha(Resenha resenha) {
        if (resenha.getId() == null) {
            throw new AutorNotFoundException("ID do autor não informado.");
        }

        deleteResenhaPorId(resenha.getId());
    }

    public void deleteResenhaPorId(UUID id){
        Resenha resenha = repository.findById(id)
                .orElseThrow(() -> new ResenhaNotFoundException(id));

        repository.delete(resenha);
    }

    public void atualizaResenhaPorId(UUID id, Resenha resenha) {
        Resenha resenhaEntity = repository.findById(id)
                .orElseThrow(() -> new ResenhaNotFoundException(id));

        if (resenha.getResenha() != null) {
            resenhaEntity.setResenha(resenha.getResenha());
        }

        if (resenha.getLivro() != null) {
            resenhaEntity.setLivro(resenha.getLivro());
        }

        repository.save(resenhaEntity);
    }
}
