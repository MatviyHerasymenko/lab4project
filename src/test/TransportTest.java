package test;

import model.human.Firefighter;
import model.human.Human;
import model.human.PoliceOfficer;
import model.vehicle.Bus;
import model.vehicle.FireTruck;
import model.vehicle.PoliceCar;
import model.vehicle.Taxi;
import service.Road;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransportTest {

    @Test
    void testPassengerBoardingAndCapacity() {
        Bus bus = new Bus(2);
        Human person1 = new Human("Іван");
        Human person2 = new Human("Марія");
        Human person3 = new Human("Олег");

        bus.boardPassenger(person1);
        bus.boardPassenger(person2);

        assertEquals(2, bus.getOccupiedSeats());
        assertThrows(IllegalStateException.class, () -> bus.boardPassenger(person3));
    }

    @Test
    void testPassengerUnboardingException() {
        Taxi taxi = new Taxi(4);
        Human person = new Human("Петро");

        assertThrows(IllegalArgumentException.class, () -> taxi.unboardPassenger(person));
    }

    @Test
    void testSpecializedVehiclesGenerics() {
        FireTruck fireTruck = new FireTruck(3);
        Firefighter firefighter = new Firefighter("Сергій");

        fireTruck.boardPassenger(firefighter);
        assertEquals(1, fireTruck.getOccupiedSeats());

    }

    @Test
    void testRoadHumanCounting() {
        Road road = new Road();

        Bus bus = new Bus(30);
        bus.boardPassenger(new Human("Пасажир 1"));

        FireTruck fireTruck = new FireTruck(4);
        fireTruck.boardPassenger(new Firefighter("Пожежник 1"));

        PoliceCar policeCar = new PoliceCar(2);
        policeCar.boardPassenger(new PoliceOfficer("Поліцейський 1"));

        road.addCarToRoad(bus);
        road.addCarToRoad(fireTruck);
        road.addCarToRoad(policeCar);

        assertEquals(3, road.getCountOfHumans());
    }
}