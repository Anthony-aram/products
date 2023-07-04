package com.products.products.exception;

import org.springframework.http.HttpStatus;

/**
 * Exception générique
 */
public class ProductAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;

    /**
     * Constructeur
     * @param status Status
     * @param message Message
     */
    public ProductAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ProductAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    /**
     * Getter
     * @return Status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Getter
     * @return Message
     */
    @Override
    public String getMessage() {
        return message;
    }
}
