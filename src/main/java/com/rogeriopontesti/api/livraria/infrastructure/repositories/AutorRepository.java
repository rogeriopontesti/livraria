package com.rogeriopontesti.api.livraria.infrastructure.repositories;

import com.rogeriopontesti.api.livraria.infrastructure.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {

    List<Autor> findByNomeContaining(String nome);

    List<Autor> findByNomeContainingIgnoreCase(String nome);
}