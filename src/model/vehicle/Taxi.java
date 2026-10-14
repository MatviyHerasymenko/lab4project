package model.vehicle;

import model.human.Human;

public class Taxi extends Car<Human> {
    public Taxi(int capacity) {
        super(capacity);
    }
}