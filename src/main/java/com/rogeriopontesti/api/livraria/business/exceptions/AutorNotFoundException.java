package com.rogeriopontesti.api.livraria.business.exceptions;

import java.util.UUID;

public class AutorNotFoundException extends RuntimeException{
    public AutorNotFoundException(UUID id) {
        super("Autor não encontrado: " + id);
    }

    public AutorNotFoundException(String nome) {
        super("Autor não encontrado: " + nome);
    }
}
