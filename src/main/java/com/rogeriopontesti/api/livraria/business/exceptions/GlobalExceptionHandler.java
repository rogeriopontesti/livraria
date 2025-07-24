package com.rogeriopontesti.api.livraria.business.exceptions;

import com.rogeriopontesti.api.livraria.infrastructure.config.StandardMessageError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.Instant;
import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AutorNotFoundException.class)
    public ResponseEntity<StandardMessageError> handleAutorNotFoundException(AutorNotFoundException e, HttpServletRequest request) {

        StandardMessageError standardMessageError = new StandardMessageError(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not found",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardMessageError);
    }

    @ExceptionHandler(EditoraNotFoundException.class)
    public ResponseEntity<StandardMessageError> handleEditoraNotFoundException(AutorNotFoundException e, HttpServletRequest request) {

        StandardMessageError standardMessageError = new StandardMessageError(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not found",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardMessageError);
    }
//
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public ResponseEntity<String> handleUUIDConversionError(MethodArgumentTypeMismatchException ex) {
//        if (ex.getRequiredType() == UUID.class) {
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body("ID fornecido não é um UUID válido: " + ex.getValue());
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parâmetro inválido.");
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleGenericException(Exception ex) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("* Nenhum registo encontrado: " + ex.getMessage());
//    }
}
