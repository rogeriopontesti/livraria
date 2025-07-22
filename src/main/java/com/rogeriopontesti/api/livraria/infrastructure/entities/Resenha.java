package com.rogeriopontesti.api.livraria.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "resenhas")
@Entity
public class Resenha {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Lob
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String resenha;

    @OneToOne
    @JoinColumn(name = "livro_id", nullable = false, unique = true)
    private Livro livro;
}
