package org.acme.dto;

public class FieldError {
    private String field;
    private String message;

    public String getCampos() {
        return field;
    }

    public String getMenssagens() {
        return message;
    }

    public FieldError(String field, String message) {
        this.field = field;
        this.message = message;
    }

}
