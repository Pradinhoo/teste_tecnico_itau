package com.apiteste.itau.service;

import com.apiteste.itau.dto.NovaTransacaoDTO;
import com.apiteste.itau.model.Transacao;
import com.apiteste.itau.validation.ValidarNovaTransacao;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TransacaoServiceImpl implements TransacaoService {

     private final List<ValidarNovaTransacao> listaParaValidarNovaTransacao;
     private final Map<Integer, Transacao> transacoes = new HashMap<>();
     private final AtomicInteger atomicInteger = new AtomicInteger();

     public TransacaoServiceImpl(List<ValidarNovaTransacao> listaParaValidarNovaTransacao) {
          this.listaParaValidarNovaTransacao = listaParaValidarNovaTransacao;
     }

     public void novaTransacao(NovaTransacaoDTO novaTransacaoDTO) {
          listaParaValidarNovaTransacao.forEach(v -> v.validarTransacao(novaTransacaoDTO));

          Integer idTransacao = atomicInteger.incrementAndGet();
          Transacao transacao = new Transacao(novaTransacaoDTO.valor(), novaTransacaoDTO.dataHora());

          transacoes.put(idTransacao, transacao);
     }
}
