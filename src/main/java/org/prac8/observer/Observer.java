package org.prac8.observer;

import java.util.HashSet;
import java.util.regex.Pattern;

interface Observer<T> {
    void update(T value);
}

class ConcreteObserver implements Observer<Integer> {
    private Integer value;

    @Override
    public void update(Integer value) {
        System.out.println(value);
        this.value = value;
    }
}

interface Observable<T> {
    void attach(Observer<T> observer);

    void detach(Observer<T> observer);

    void notify(T value);
}


class ConcreteObservable implements Observable<Integer> {
    private HashSet<Observer<Integer>> observers = new HashSet<>();

    @Override
    public void attach(Observer<Integer> observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer<Integer> observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(Integer value) {
        for (Observer<Integer> observer : observers) {
            observer.update(value);
        }
    }

    public Thread startThread() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                notify(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
        return thread;
    }
}

class Main {
    public static void main(String[] args) {
        ConcreteObservable observable = new ConcreteObservable();
        observable.attach(new ConcreteObserver());
        observable.startThread();
        System.out.println("WAITING");
    }
}