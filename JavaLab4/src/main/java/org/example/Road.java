package org.example;

import java.util.ArrayList;
import java.util.List;

public class Road {
    // Використовуємо wildcard для списку транспортних засобів
    public List<Vehicle<?>> carsInRoad = new ArrayList<>();

    public int getCountOfHumans() {
        return carsInRoad.stream()
                .mapToInt(Vehicle::getOccupiedSeats)
                .sum();
    }

    public void addCarToRoad(Vehicle<?> car) {
        carsInRoad.add(car);
    }
}

