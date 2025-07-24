package com.rogeriopontesti.api.livraria.business.exceptions;

import java.io.Serial;
import java.util.UUID;

public class AutorNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public AutorNotFoundException(String message) {
        super(message);
    }
}
