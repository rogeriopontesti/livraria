package com.rogeriopontesti.api.livraria.infrastructure.repositories;

import com.rogeriopontesti.api.livraria.infrastructure.entities.Editora;
import com.rogeriopontesti.api.livraria.infrastructure.entities.Resenha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ResenhaRepository extends JpaRepository<Resenha, UUID> {
    @Query("SELECT r FROM Resenha r WHERE LOWER(CAST(r.resenha AS string)) LIKE LOWER(CONCAT('%', :trecho, '%'))")
    List<Resenha> buscarPorTrecho(@Param("trecho") String trecho);
}
