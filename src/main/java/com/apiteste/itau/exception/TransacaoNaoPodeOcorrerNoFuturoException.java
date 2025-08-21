package com.apiteste.itau.exception;

public class TransacaoNaoPodeOcorrerNoFuturoException extends RuntimeException {
    public TransacaoNaoPodeOcorrerNoFuturoException() {
        super(MensagensDeErroTransacao.TRANSACAO_NAO_PODE_OCORRER_NO_FUTURO);
    }
}
