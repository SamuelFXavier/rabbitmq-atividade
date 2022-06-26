package com.dh.catalog;

public class CircuitBreakerException extends Exception {

    public CircuitBreakerException(String mensagem){
        super(mensagem);
    }
}
