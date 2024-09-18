package com.api.practica.Exception;

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(String message){
        super(message);
    }
}
