package com.inditex.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
class ErrorHandlingControllerAdvice {

    @ExceptionHandler(PriceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    ErrorResponse onPriceNotFoundException(PriceNotFoundException e){
        return  ErrorResponse.builder()
                .msg(e.getMessage())
                .code(HttpStatus.NOT_FOUND.value())
                .build();
    }

}
