package model.vehicle;

import model.human.Human;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle<T extends Human> {
    private final int capacity;
    private final List<T> passengers = new ArrayList<>();

    public Vehicle(int capacity) {
        this.capacity = capacity;
    }

    public int getMaxCapacity() {
        return capacity;
    }

    public int getOccupiedSeats() {
        return passengers.size();
    }

    public void boardPassenger(T passenger) {
        if (passengers.size() >= capacity) {
            throw new IllegalStateException("Усі місця в транспортному засобі зайняті!");
        }
        passengers.add(passenger);
    }

    public void unboardPassenger(T passenger) {
        if (!passengers.contains(passenger)) {
            throw new IllegalArgumentException("Пасажир " + passenger.getName() + " відсутній у ТЗ!");
        }
        passengers.remove(passenger);
    }

    public List<T> getPassengers() {
        return new ArrayList<>(passengers);
    }
}