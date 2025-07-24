package com.rogeriopontesti.api.livraria.business.services;

import com.rogeriopontesti.api.livraria.business.exceptions.AutorNotFoundException;
import com.rogeriopontesti.api.livraria.business.exceptions.LivroNotFoundException;
import com.rogeriopontesti.api.livraria.business.exceptions.ResenhaNotFoundException;
import com.rogeriopontesti.api.livraria.business.records.requests.ResenhaRecordRequest;
import com.rogeriopontesti.api.livraria.infrastructure.config.Labels;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Livro;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Resenha;
import com.rogeriopontesti.api.livraria.infrastructure.repositories.LivroRepository;
import com.rogeriopontesti.api.livraria.infrastructure.repositories.ResenhaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ResenhaService {

    @Autowired
    private final ResenhaRepository repository;

    @Autowired
    private final LivroRepository livroRepository;

    public ResenhaService(ResenhaRepository repository, LivroRepository livroRepository) {
        this.repository = repository;
        this.livroRepository = livroRepository;
    }

    public List<Resenha> listarResenhas() {
        return repository.findAll();
    }

    public Resenha buscarResenhaPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResenhaNotFoundException(
                        Labels.getErroNotFoundResenha(id.toString())
                ));
    }

    public List<Resenha> buscarResenhasPorTrecho(String texto) {
        List<Resenha> resenha = repository.buscarPorTrecho(texto);
        if (resenha.isEmpty()) {
            throw new ResenhaNotFoundException(
                    Labels.getErroNotFoundResenha(texto)
            );
        }
        return resenha;
    }

    public void salvarResenha(ResenhaRecordRequest request) {

        Livro livro = livroRepository.findById(request.livroId())
                .orElseThrow(() -> new LivroNotFoundException(
                        Labels.getErroNotFoundLivro(request.livroId().toString())
                ));

        Resenha novaResenha = Resenha.builder()
                .resenha(request.resenha())
                .livro(livro)
                .build();

        livro.setResenha(novaResenha);
        livroRepository.save(livro);
    }

    public void deleteResenha(Resenha resenha) {
        if (resenha.getId() == null) {
            throw new ResenhaNotFoundException(
                    Labels.getErroNullOrNonExistentId()
            );
        }

        deleteResenhaPorId(resenha.getId());
    }

    public void deleteResenhaPorId(UUID id) {
        Resenha resenha = repository.findById(id)
                .orElseThrow(() -> new ResenhaNotFoundException(
                        Labels.getErroNotFoundResenha(id.toString())
                ));

        Livro livro = resenha.getLivro();
        if (livro != null) {
            livro.setResenha(null);
            livroRepository.save(livro);
        }

        repository.delete(resenha);
    }

    public void atualizaResenhaPorId(UUID id, Resenha resenha) {
        Resenha resenhaEntity = repository.findById(id)
                .orElseThrow(() -> new ResenhaNotFoundException(
                        Labels.getErroNotFoundResenha(id.toString())
                ));

        if (resenha.getResenha() != null) {
            resenhaEntity.setResenha(resenha.getResenha());
        }

        if (resenha.getLivro() != null) {
            resenhaEntity.setLivro(resenha.getLivro());
        }

        repository.save(resenhaEntity);
    }
}
