package br.com.rssistemas.wst.user.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String entity, String field, String value) {
        super(entity + " not found with " + field + " value " + value);
    }
}
