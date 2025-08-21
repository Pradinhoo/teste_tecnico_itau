package com.apiteste.itau.dto;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record NovaTransacaoDTO(
        @NotNull
        Double valor,
        @NotNull
        OffsetDateTime dataHora) {
}
