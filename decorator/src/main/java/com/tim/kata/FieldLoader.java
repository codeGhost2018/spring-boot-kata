package com.tim.kata;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FieldLoader {

    public String getSecret() {
        return UUID.randomUUID().toString();
    }
}
