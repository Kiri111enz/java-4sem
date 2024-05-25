package org.prac6.abstractFactory;

public class GoshaFactory implements AbstractFactory{
    @Override
    public Cat getCat() {
        return new GoshaCat();
    }

    @Override
    public Dog getDog() {
        return new GoshaDog();
    }
}
