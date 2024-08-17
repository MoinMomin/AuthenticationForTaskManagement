package com.novalabs.authservice.exception;

import com.novalabs.authservice.utils.CustomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class globalExceptions {
    @ExceptionHandler(TokenUnAuthorized.class)
    public ResponseEntity<Map> tokenUnAuthorized(TokenUnAuthorized tokenUnAuthorized){
        return CustomResponse.forbidden("Token UnAuthorized");
    }
}
