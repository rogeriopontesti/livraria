package com.rogeriopontesti.api.livraria.infrastructure.repositories;

import com.rogeriopontesti.api.livraria.infrastructure.entities.Resenha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResenhaRepository extends JpaRepository<Resenha, UUID> {
}
