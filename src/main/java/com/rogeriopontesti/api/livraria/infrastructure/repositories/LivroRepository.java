package com.rogeriopontesti.api.livraria.infrastructure.repositories;

import com.rogeriopontesti.api.livraria.infrastructure.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
