package com.rogeriopontesti.api.livraria.business.exceptions;

import java.util.UUID;

public class ResenhaNotFoundException extends RuntimeException {
  public ResenhaNotFoundException(UUID id) {
    super(id.toString());
  }

  public ResenhaNotFoundException(String argumento) {
    super(argumento);
  }
}
