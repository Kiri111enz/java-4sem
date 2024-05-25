package com.example.prac10;

import org.springframework.stereotype.Component;

@Component(value = "Guitarist")
public class Guitarist implements Musician {
    @Override
    public void doCoding() {
        System.out.println("Guitarist coding");
    }
}
