package com.cos.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class) //Exception 부분에 IllegalArgumentException 등 해당 exception만 적으면 그거만 탐
    public String handleArgumentException(Exception e){
        return "<h1>"+e.getMessage()+"</h1>";
    }
}
