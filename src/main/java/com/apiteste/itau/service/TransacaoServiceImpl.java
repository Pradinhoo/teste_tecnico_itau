package com.apiteste.itau.service;

import com.apiteste.itau.dto.NovaTransacaoDTO;
import com.apiteste.itau.model.Transacao;
import com.apiteste.itau.repository.TransacaoRepository;
import com.apiteste.itau.validation.ValidarNovaTransacao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService {

     private final List<ValidarNovaTransacao> listaParaValidarNovaTransacao;
     private final TransacaoRepository transacaoRepository;

     public TransacaoServiceImpl(List<ValidarNovaTransacao> listaParaValidarNovaTransacao, TransacaoRepository transacaoRepository) {
          this.listaParaValidarNovaTransacao = listaParaValidarNovaTransacao;
          this.transacaoRepository = transacaoRepository;
     }

     public void novaTransacao(NovaTransacaoDTO novaTransacaoDTO) {
          listaParaValidarNovaTransacao.forEach(v -> v.validarTransacao(novaTransacaoDTO));
          Transacao transacao = new Transacao(novaTransacaoDTO.valor(), novaTransacaoDTO.dataHora());
          transacaoRepository.salvarTransacao(transacao);
     }
}
