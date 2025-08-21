package com.apiteste.itau.controller;

import com.apiteste.itau.dto.EstatisticasDTO;
import com.apiteste.itau.service.EstatisticaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @GetMapping
    public ResponseEntity<EstatisticasDTO> mostrarEstatistica() {
        EstatisticasDTO estatisticasDTO = estatisticaService.exibirEstatistica();
        return ResponseEntity.status(HttpStatus.OK).body(estatisticasDTO);
    }
}
