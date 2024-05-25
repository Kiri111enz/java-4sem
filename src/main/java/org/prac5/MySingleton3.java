package org.prac5;

public class MySingleton3 {
    private static final MySingleton3 instance = new MySingleton3();

    public static MySingleton3 getInstance() {
        return instance;
    }
}
