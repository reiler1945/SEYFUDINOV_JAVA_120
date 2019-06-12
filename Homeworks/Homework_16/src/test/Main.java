package test;

import models.Car;
import models.CarStarRemotely;
import models.SimpleCar;
import models.SportCar;

public class Main {

    public static void main(String[] args) {
        SportCar car1 = SportCar.builder().setDistance(100)
                .setId(0)
                .setModel("Ferrari")
                .build();
        car1.engineSound();
        SimpleCar car2 = SimpleCar.builder().setDistance(100)
                .setId(0)
                .setModel("Lada")
                .build();
        car2.engineSound();
    }
}
