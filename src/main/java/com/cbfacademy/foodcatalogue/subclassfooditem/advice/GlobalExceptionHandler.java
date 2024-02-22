package com.foodcatalogue.exception; 

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cbfacademy.foodcatalogue.subclassfooditem.exception.ErrorMessage;
import com.cbfacademy.foodcatalogue.subclassfooditem.exception.ResourceNotFoundException; // Correct import


@ControllerAdvice //Methods are now applicable to all controllers
public class GlobalExceptionHandler {

    // Exception handlers go here

    @ExceptionHandler(ResourceNotFoundException) //Method should be invoked when the exception is thrown
    @ResponseStatus(HttpStatus.NOT_FOUND) //Status code should be 404
    @ResponseBody //Return type should be JSON
    public ErrorMessage handleResourceNotFoundException(ResourceNotFoundException ex) { 
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)  
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //Status code should be 500 
    @ResponseBody //Return type should be JSON 
    public ErrorMessage handleException(Exception ex) { 
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An  unexpected error has occurred");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors); // custom class to structure error messages
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}

    
