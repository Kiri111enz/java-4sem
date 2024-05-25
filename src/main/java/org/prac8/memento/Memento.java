package org.prac8.memento;

class Originator {
    private int state;

    public Originator(int startState) {
        state = startState;
    }

    public void setMemento(Memento m) {
        state = m.state;
    }

    public Memento createMemento() {
        Memento memento = new Memento();
        memento.state = state;
        return memento;
    }

    @Override
    public String toString() {
        return "Originator{" +
                "state=" + state +
                '}';
    }

    public static class Memento {
        private int state;
    }
}

class Main {
    public static void main(String[] args) {
        Originator originator = new Originator(123);
        Originator.Memento memento = originator.createMemento();
        Originator otherOriginator = new Originator(321);
        System.out.println(otherOriginator);
        otherOriginator.setMemento(memento);
        System.out.println(otherOriginator);
    }
}

