package com.rogeriopontesti.api.livraria.business.records.responses;

import java.util.List;
import java.util.UUID;

public record LivroRecordResponse(
        UUID id,
        String titulo,
        String editoraNome,
        List<String> autoresNomes,
        String resenha
) {}
