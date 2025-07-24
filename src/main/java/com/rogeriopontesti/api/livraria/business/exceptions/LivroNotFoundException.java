package com.rogeriopontesti.api.livraria.business.exceptions;

import java.io.Serial;
import java.util.UUID;

public class LivroNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public LivroNotFoundException(String message) {
        super(message);
    }
}