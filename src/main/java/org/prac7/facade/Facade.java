package org.prac7.facade;

public class Facade {
    private Friend friend = new Friend();
    private Enemy enemy = new Enemy();

    public void sayHelloToPeople() {
        friend.sayHello();
        enemy.sayHello();
    }

    public void sayByeToPeople() {
        friend.sayBye();
        enemy.sayBye();
    }
}

class Friend {
    public void sayHello() {
        System.out.println("Hi friend");
    }

    public void sayBye() {
        System.out.println("Bye");
    }
}

class Enemy {
    public void sayHello() {
        System.out.println("Grrr...");
    }

    public void sayBye() {
        System.out.println("...");
    }
}

class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.sayHelloToPeople();
        facade.sayByeToPeople();
    }
}
