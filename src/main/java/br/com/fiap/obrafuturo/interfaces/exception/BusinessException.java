package br.com.fiap.obrafuturo.interfaces.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
