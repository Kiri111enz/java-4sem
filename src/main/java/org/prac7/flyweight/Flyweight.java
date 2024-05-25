package org.prac7.flyweight;

import java.util.HashMap;

public class Flyweight {
    private String information;
    public Flyweight(String someInformation) {
        this.information = someInformation;
    }

    @Override
    public String toString() {
        return "Flyweight{" +
                "information='" + information + '\'' +
                '}';
    }
}

class Factory {
    private final HashMap<String, Flyweight> cash = new HashMap<>();
    public Flyweight getFlyweight(String information) {
        if (!cash.containsKey(information)) {
            cash.put(information, new Flyweight(information));
        }
        return cash.get(information);
    }
}

class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        System.out.println(System.identityHashCode(factory.getFlyweight("stepa")));
        System.out.println(System.identityHashCode(factory.getFlyweight("stepa")));
    }
}
