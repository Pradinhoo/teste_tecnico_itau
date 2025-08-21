package com.apiteste.itau.validation;

import com.apiteste.itau.dto.NovaTransacaoDTO;
import com.apiteste.itau.exception.TransacaoNaoPodeTerValorNegativoException;
import org.springframework.stereotype.Component;

@Component
public class ValorDeveSerIgualOuMaiorQueZero implements ValidarNovaTransacao {

    public void validarTransacao(NovaTransacaoDTO novaTransacaoDTO) {
        if (novaTransacaoDTO.valor() < 0) {
            throw new TransacaoNaoPodeTerValorNegativoException();
        }
    }
}
