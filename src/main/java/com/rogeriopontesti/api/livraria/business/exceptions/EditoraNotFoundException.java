package com.rogeriopontesti.api.livraria.business.exceptions;

import java.util.UUID;

public class EditoraNotFoundException extends RuntimeException {

    public EditoraNotFoundException(UUID id) {
        super("Editora não encontrada: " + id);
    }

    public EditoraNotFoundException(String nome) {
        super("Editora não encontrada: " + nome);
    }
}
