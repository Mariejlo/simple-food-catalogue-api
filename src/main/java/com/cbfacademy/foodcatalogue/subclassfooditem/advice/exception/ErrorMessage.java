/*package com.cbfacademy.foodcatalogue.subclassfooditem.advice.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorMessage { //Class to send back consistent error response format
    

    private final int statusCode;
    private final String message;

    public ErrorMessage(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ErrorMessage(int value, String string, List<String> errors) {
        this.statusCode = 0;
        this.message = "";
        
    }

    // Getters
    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    // New method for handling exceptions
    public static ErrorMessage handleException(Exception e) {
        int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String message = "An unexpected error occurred.";

        if (e instanceof ResourceNotFoundException) {
            statusCode = ((ResourceNotFoundException) e).getHttpStatus().value();
            message = e.getMessage();
        }

        return new ErrorMessage(statusCode, message);
    }
}
*/
