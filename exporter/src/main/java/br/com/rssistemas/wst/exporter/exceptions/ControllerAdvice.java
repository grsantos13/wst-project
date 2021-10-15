package br.com.rssistemas.wst.exporter.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    private final MessageSource messageSource;

    public ControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        return buildApiErrors(new ArrayList<>(), List.of(new ObjectError("", e.getMessage())));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = e.getBindingResult().getGlobalErrors();

        return buildApiErrors(fieldErrors, globalErrors);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors bindExceptionHandler(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = e.getBindingResult().getGlobalErrors();

        return buildApiErrors(fieldErrors, globalErrors);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiErrors> responseStatusExceptionHandler(ResponseStatusException e) {
        ApiErrors apiErrors = new ApiErrors();
        apiErrors.addGlobalErrors(e.getReason());
        return ResponseEntity.status(e.getStatus()).body(apiErrors);
    }

    private ApiErrors buildApiErrors(List<FieldError> fieldErrors, List<ObjectError> globalErrors) {
        ApiErrors validationErrors = new ApiErrors();
        globalErrors.forEach(error -> validationErrors.addGlobalErrors(getErrorMessage(error)));
        fieldErrors.forEach(error -> {
            String message = getErrorMessage(error);
            validationErrors.addFieldError(error.getField(), message);
        });

        return validationErrors;
    }

    private String getErrorMessage(ObjectError error) {
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }
}
