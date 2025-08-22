package com.apiteste.itau.service;

import com.apiteste.itau.dto.EstatisticasDTO;
import com.apiteste.itau.model.Transacao;
import com.apiteste.itau.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaServiceImpl implements EstatisticaService {

    private final TransacaoRepository transacaoRepository;

    public EstatisticaServiceImpl(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public EstatisticasDTO exibirEstatistica(Integer segundos) {
        List<Transacao> todasAsTransacoes = transacaoRepository.pegarTransacoes();

        Integer segundosParaUsar;

        if (segundos != null) {
            segundosParaUsar = segundos;
        } else {
            segundosParaUsar = 60;
        }

        List<Transacao> ultimosSegundos = todasAsTransacoes.stream()
                .filter(t -> t.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(segundosParaUsar)))
                .toList();

        DoubleSummaryStatistics stats = ultimosSegundos.stream()
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

        System.out.println("Segundos usados " + segundosParaUsar);
        return new EstatisticasDTO(stats.getCount(), stats.getSum(), stats.getAverage(), stats.getMin(), stats.getMax());
    }
}
