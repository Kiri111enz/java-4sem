package org.prac6.factory;


public class Main {
    public static void main(String[] args) {
        DogFactory factory = new DogFactory();
        System.out.println(factory.createDog("Gosha"));
    }
}
