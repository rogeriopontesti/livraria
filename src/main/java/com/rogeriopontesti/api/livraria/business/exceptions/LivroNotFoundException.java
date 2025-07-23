package com.rogeriopontesti.api.livraria.business.exceptions;

import java.util.UUID;

public class LivroNotFoundException extends RuntimeException {
    public LivroNotFoundException(UUID id) {
        super(id.toString());
    }

    public LivroNotFoundException(String argumento) {
        super(argumento);
    }
}