package com.example.prac10;

import org.springframework.stereotype.Component;

@Component(value = "Drummer")
public class Drummer implements Musician {
    @Override
    public void doCoding() {
        System.out.println("Drummer coding");
    }
}
