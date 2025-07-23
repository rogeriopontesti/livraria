package com.rogeriopontesti.api.livraria.infrastructure.repositories;

import com.rogeriopontesti.api.livraria.infrastructure.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
    List<Livro> findByTituloContaining(String titulo);

    List<Livro> findByTituloContainingIgnoreCase(String titulo);

    List<Livro> findByEditora_NomeContainingIgnoreCase(String nome);
}
