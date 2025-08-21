package com.apiteste.itau.service;

import com.apiteste.itau.dto.NovaTransacaoDTO;

public interface TransacaoService {
    void novaTransacao(NovaTransacaoDTO transacaoDTO);
}
