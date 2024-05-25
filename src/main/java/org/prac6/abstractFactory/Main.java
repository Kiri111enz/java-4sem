package org.prac6.abstractFactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new GoshaFactory();
        System.out.println(factory.getCat());
        System.out.println(factory.getCat());
        System.out.println(factory.getDog());
    }
}
