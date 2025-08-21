package com.apiteste.itau.repository;

import com.apiteste.itau.model.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    private final List<Transacao> listaDeTransacoes = new ArrayList<>();

    public void salvarTransacao(Transacao transacao) {
        listaDeTransacoes.add(transacao);
    }

    public List<Transacao> pegarTransacoes() {
        return listaDeTransacoes;
    }
}
