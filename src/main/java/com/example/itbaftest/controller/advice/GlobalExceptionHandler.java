package com.example.itbaftest.controller.advice;



import com.example.itbaftest.model.exception.ApiError;
import com.example.itbaftest.model.exception.ExceptionApi;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExceptionApi.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError errorDeServidor(ExceptionApi ex) {
        return new ApiError(ex.getCodigo(), ex.getMensaje());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError errorDeServidor(MethodArgumentNotValidException ex) {
        String mensajeError=ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).distinct().collect(Collectors.joining(", "));
        return new ApiError(400,mensajeError );
    }





}
