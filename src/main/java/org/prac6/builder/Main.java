package org.prac6.builder;

public class Main {
    public static void main(String[] args) {
        GoshaDogBuilder builder = new GoshaDogBuilder();
        builder.setMmr(123);
        builder.setPts(123);
        System.out.println(builder.build().toString());
    }
}
