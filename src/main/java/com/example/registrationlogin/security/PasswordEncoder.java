package com.example.registrationlogin.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        String raw="1wqa";
        String encode=encoder.encode(raw);
        System.out.println(encode);
    }
}
