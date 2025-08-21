package com.apiteste.itau.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TransacaoNaoPodeOcorrerNoFuturoException.class)
    public ResponseEntity<Void> handleTransacaoNaoPodeOcorrerNoFuturo() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

    @ExceptionHandler(TransacaoNaoPodeTerValorNegativoException.class)
    public ResponseEntity<Void> handleTransacaoNaoPodeTerValorNegativo() {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Void> jsonVazio() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
