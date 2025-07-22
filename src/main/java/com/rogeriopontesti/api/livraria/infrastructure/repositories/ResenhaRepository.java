package com.rogeriopontesti.api.livraria.infrastructure.repositories;

import com.rogeriopontesti.api.livraria.infrastructure.entities.Editora;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Resenha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ResenhaRepository extends JpaRepository<Resenha, UUID> {
    List<Resenha> findByNomeContaining(String nome);

    List<Resenha> findByNomeContainingIgnoreCase(String nome);
}
