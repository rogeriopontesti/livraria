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
public class ResenhaService {
}
