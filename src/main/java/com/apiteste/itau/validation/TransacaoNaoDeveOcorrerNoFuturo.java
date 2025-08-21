package com.apiteste.itau.validation;

import com.apiteste.itau.dto.NovaTransacaoDTO;
import com.apiteste.itau.exception.TransacaoNaoPodeOcorrerNoFuturoException;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class TransacaoNaoDeveOcorrerNoFuturo implements ValidarNovaTransacao {

    public void validarTransacao(NovaTransacaoDTO novaTransacaoDTO) {
        if (novaTransacaoDTO.dataHora().isAfter(OffsetDateTime.now())) {
            throw new TransacaoNaoPodeOcorrerNoFuturoException();
        }
    }
}
