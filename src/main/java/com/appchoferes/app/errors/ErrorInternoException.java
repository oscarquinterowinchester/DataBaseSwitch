package com.appchoferes.app.errors;

public class ErrorInternoException extends RuntimeException {
    public ErrorInternoException(String mensaje) {
        super(mensaje);
    }
}