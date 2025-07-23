package com.rogeriopontesti.api.livraria.business.records.requests;

import java.util.List;
import java.util.UUID;

public record LivroFindByAllRecordRequest(UUID id, String titulo, List<UUID> autoresIds) {}