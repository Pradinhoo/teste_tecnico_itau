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

    public EstatisticasDTO exibirEstatistica() {
        List<Transacao> todasAsTransacoes = transacaoRepository.pegarTransacoes();

        List<Transacao> ultimos60Segundos = todasAsTransacoes.stream()
                .filter(t -> t.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(60)))
                .toList();

        DoubleSummaryStatistics stats = ultimos60Segundos.stream()
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

        return new EstatisticasDTO(stats.getCount(), stats.getSum(), stats.getAverage(), stats.getMin(), stats.getMax());
    }
}
