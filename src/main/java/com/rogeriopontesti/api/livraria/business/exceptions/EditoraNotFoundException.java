package com.rogeriopontesti.api.livraria.business.exceptions;

import java.util.UUID;

public class EditoraNotFoundException extends RuntimeException {

    public EditoraNotFoundException(UUID id) {
        super(id.toString());
    }

    public EditoraNotFoundException(String argumento) {
        super(argumento);
    }
}
