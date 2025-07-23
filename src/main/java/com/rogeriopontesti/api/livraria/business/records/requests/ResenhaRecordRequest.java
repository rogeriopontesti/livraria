package com.rogeriopontesti.api.livraria.business.records.requests;

import java.util.UUID;

public record ResenhaRecordRequest(String resenha, UUID livroId) {}
