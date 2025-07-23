package com.rogeriopontesti.api.livraria.business.exceptions;

import java.util.UUID;

public class AutorNotFoundException extends RuntimeException{
    public AutorNotFoundException(UUID id) {
        super(id.toString());
    }

    public AutorNotFoundException(String argumento) {
        super(argumento);
    }
}
