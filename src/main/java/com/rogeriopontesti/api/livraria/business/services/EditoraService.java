package com.rogeriopontesti.api.livraria.business.services;

import com.rogeriopontesti.api.livraria.business.exceptions.AutorNotFoundException;
import com.rogeriopontesti.api.livraria.business.exceptions.EditoraNotFoundException;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Autor;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Editora;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Livro;
import com.rogeriopontesti.api.livraria.infrastructure.repositories.EditoraRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EditoraService {

    private final EditoraRepository repository;

    public EditoraService(EditoraRepository repository) {
        this.repository = repository;
    }

    public void salvarAutor(Editora editora){
        repository.saveAndFlush(editora);
    }

    public List<Editora> listarEditoras(){
        return repository.findAll();
    }

    public Editora buscarEditoraPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EditoraNotFoundException(id));
    }

    public List<Editora> buscarEditorasPorNome(String nome) {
        List<Editora> editoras = repository.findByNomeContainingIgnoreCase(nome);
        if (editoras.isEmpty()) {
            throw new AutorNotFoundException(nome);
        }
        return editoras;
    }

    public void deleteEditora(Editora editora) {
        if (editora.getId() == null) {
            throw new EditoraNotFoundException("ID da editora não informado.");
        }
        deleteEditoraPorId(editora.getId());
    }

    public void deleteEditoraPorId(UUID id) {
        Editora editora = repository.findById(id)
                .orElseThrow(() -> new EditoraNotFoundException(id));

        List<Livro> livros = editora.getLivros();

        if (livros != null && !livros.isEmpty()) {
            for (Livro livro : livros) {
                if (livro.getAutores() != null) {
                    for (Autor autor : livro.getAutores()) {
                        autor.getLivros().remove(livro);
                    }
                    livro.getAutores().clear();
                }

                if (livro.getResenha() != null) {
                    livro.setResenha(null);
                }

                livro.setEditora(null);
            }
        }

        editora.setLivros(null);
        repository.save(editora);
        repository.delete(editora);
    }

    public void atualizaEditoraEditoraPorId(UUID id, Editora editora) {
        Editora editoraEntity = repository.findById(id)
                .orElseThrow(() -> new AutorNotFoundException(id));

        if (editora.getNome() != null) {
            editoraEntity.setNome(editora.getNome());
        }

        if (editora.getLivros() != null) {
            editoraEntity.setLivros(editora.getLivros());
        }

        repository.save(editoraEntity);
    }
}
