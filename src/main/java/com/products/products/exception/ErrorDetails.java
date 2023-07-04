package com.products.products.exception;

import java.util.Date;

/**
 * Classe représentant les détails d'une erreur
 */
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    /**
     * Constructeur
     * @param timestamp Date de l'erreur
     * @param message Message de l'erreur
     * @param details Détails de l'erreur
     */
    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    /**
     * Getter
     * @return Date de l'erreur
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Getter
     * @return Message de l'erreur
     */
    public String getMessage() {
        return message;
    }

    /**
     * Getter
     * @return Détails de l'erreur
     */
    public String getDetails() {
        return details;
    }
}
