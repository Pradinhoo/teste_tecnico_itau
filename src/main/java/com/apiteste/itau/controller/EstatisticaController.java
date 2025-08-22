package com.apiteste.itau.controller;

import com.apiteste.itau.dto.EstatisticasDTO;
import com.apiteste.itau.service.EstatisticaService;

import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @GetMapping({"/estatistica", "/estatistica/{segundos}"})
    public ResponseEntity<EstatisticasDTO> mostrarEstatistica(@PathVariable(required = false) @Nullable Integer segundos) {
        EstatisticasDTO estatisticasDTO = estatisticaService.exibirEstatistica(segundos);
        return ResponseEntity.status(HttpStatus.OK).body(estatisticasDTO);
    }
}
