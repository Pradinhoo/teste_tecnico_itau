package com.apiteste.itau.exception;

public class TransacaoNaoPodeTerValorNegativoException extends RuntimeException {
    public TransacaoNaoPodeTerValorNegativoException() {
        super(MensagensDeErroTransacao.TRANSACAO_NAO_PODE_TER_VALOR_NEGATIVO);
    }
}
