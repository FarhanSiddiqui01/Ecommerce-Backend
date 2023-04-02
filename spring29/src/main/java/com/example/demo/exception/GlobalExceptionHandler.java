package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(value = RecordNotFound.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(RecordNotFound ex){
    ErrorMessage errorMessage = ErrorMessage.builder().body(ex.getMessage()).code(HttpStatus.NOT_FOUND)
            .timeStamp(LocalDateTime.now()).build();
    return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);
}

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> response = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(er->{
            String fieldName = ((FieldError)er).getField();
            String message = er.getDefaultMessage();
            response.put(fieldName,message);
        });
        return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);}

}
