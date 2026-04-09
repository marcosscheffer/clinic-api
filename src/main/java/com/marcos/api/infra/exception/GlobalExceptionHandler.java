package com.marcos.api.infra.exception;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public <T> ResponseEntity<T> handleEntityNotFound(EntityNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FieldErrorDTO>> handleMethodArgumentNotValid(
            MethodArgumentNotValidException e) {
        List<FieldError> erros = e.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(FieldErrorDTO::new).toList());
    }

    private record FieldErrorDTO(String field, String message) {
        public FieldErrorDTO(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
