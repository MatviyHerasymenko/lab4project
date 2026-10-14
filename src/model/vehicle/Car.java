package model.vehicle;

import model.human.Human;

public abstract class Car<T extends Human> extends Vehicle<T> {
    public Car(int capacity) {
        super(capacity);
    }
}