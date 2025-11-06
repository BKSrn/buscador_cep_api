package com.example.buscador_cep_api.exception;

public class CepTamanhoException extends RuntimeException {
    private String message;

    public CepTamanhoException(String message) {
        this.message = message;
    }

    public CepTamanhoException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
