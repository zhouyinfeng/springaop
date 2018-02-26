package com.example.service;

import com.example.security.CurrentUserHolder;
import org.springframework.stereotype.Component;

import java.util.Currency;

@Component
public class AuthService {
    public void checkAccess() {
        String user = CurrentUserHolder.get();
        if(!"admin".equals(user)){
            throw new RuntimeException("operation is not allow");
        }
    }
}
