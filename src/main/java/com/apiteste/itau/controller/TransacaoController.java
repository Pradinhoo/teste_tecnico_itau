package com.apiteste.itau.controller;

import com.apiteste.itau.dto.NovaTransacaoDTO;
import com.apiteste.itau.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    ResponseEntity<Void> novaTransacao(@RequestBody @Valid NovaTransacaoDTO novaTransacaoDTO) {
        transacaoService.novaTransacao(novaTransacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    ResponseEntity<Void> deletarTransacoes() {
        transacaoService.deletarTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
