package com.example.prac10;

import org.springframework.stereotype.Component;

@Component(value = "Trombonist")
public class Trombonist implements Musician {
    @Override
    public void doCoding() {
        System.out.println("Trombonist coding");
    }
}
