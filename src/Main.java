import model.human.*;
import model.vehicle.*;
import service.Road;

public class Main {
    public static void main(String[] args) {
          Road road = new Road();

        Bus bus = new Bus(30);
        FireTruck fireTruck = new FireTruck(4);
        PoliceCar policeCar = new PoliceCar(2);

        bus.boardPassenger(new Human("Іван"));
        fireTruck.boardPassenger(new Firefighter("Петро"));
        policeCar.boardPassenger(new PoliceOfficer("Олексій"));

        road.addCarToRoad(bus);
        road.addCarToRoad(fireTruck);
        road.addCarToRoad(policeCar);

        System.out.println("Кількість людей на дорозі: " + road.getCountOfHumans());
    }
}