package com.novalabs.authservice.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenUnAuthorized extends RuntimeException{
    public TokenUnAuthorized(String message) {
        super(message);
    }
}
