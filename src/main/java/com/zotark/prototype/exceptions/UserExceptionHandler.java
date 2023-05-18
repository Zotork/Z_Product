package com.zotark.prototype.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zotark.prototype.Model.response.ErrorResponse;
import com.zotark.prototype.Model.response.ValidationErrorMessage;

@ControllerAdvice
@ResponseStatus
public class UserExceptionHandler {
    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<ErrorResponse> registrationException(Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
                             .body(ErrorResponse
                             .builder()
                             .errorMessage(exception.getMessage())
                             .statusCode(400)
                             .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorMessage>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        List<ValidationErrorMessage> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            errors.add(ValidationErrorMessage.builder().errorField(((FieldError)error).getField()).errorMessage(error.getDefaultMessage()).build());

        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(errors);
    }
}
