package org.prac6.factory;

public class DogFactory {
    Dog createDog(String type) {
        switch (type) {
            case "Gosha" -> {
                return new GoshaDog();
            }
            default -> {
                throw new RuntimeException();
            }
        }
    }
}
