package com.example.itbaftest.controler.advice;



import com.example.itbaftest.model.exception.ApiError;
import com.example.itbaftest.model.exception.ExceptionApi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExceptionApi.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError errorDeServidor(ExceptionApi ex) {
        return new ApiError(ex.getCodigo(), ex.getMensaje());
    }





}
