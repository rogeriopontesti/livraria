package com.rogeriopontesti.api.livraria.infrastructure.repositories;

import com.rogeriopontesti.api.livraria.infrastructure.entities.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EditoraRepository extends JpaRepository<Editora, UUID> {

    List<Editora> findByNomeContaining(String nome);

    List<Editora> findByNomeContainingIgnoreCase(String nome);

}
