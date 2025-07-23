package com.rogeriopontesti.api.livraria.business.records;

import java.util.UUID;

public record ResenhaRequest(String resenha, UUID livroId) {}
