package com.rogeriopontesti.api.livraria.business.exceptions;

import java.util.UUID;

public class ResenhaNotFoundException extends RuntimeException {
  public ResenhaNotFoundException(UUID id) {
    super("Resenha não encontrada: " + id);
  }

  public ResenhaNotFoundException(String nome) {
    super("Resenha não encontrada: " + nome);
  }
}
