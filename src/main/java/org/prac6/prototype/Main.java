package org.prac6.prototype;

import org.prac6.prototype.GoshaDog;

public class Main {
    public static void main(String[] args) {
        GoshaDog dog = new GoshaDog(123);
        System.out.println(dog.clone());
    }
}
