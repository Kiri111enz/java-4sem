package org.prac5;

public class MySingleton1 {
    private static MySingleton1 instance;

    public static MySingleton1 getInstance() {
        if (instance == null){
            synchronized (MySingleton1.class) {
                if (instance != null) {
                    instance = new MySingleton1();
                }
            }
        }
        return instance;
    }
}
