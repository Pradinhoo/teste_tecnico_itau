package com.apiteste.itau.service;

import com.apiteste.itau.dto.EstatisticasDTO;

public interface EstatisticaService {
    EstatisticasDTO exibirEstatistica(Integer segundos);
}
