package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle<T extends Human> {
    private final int maxSeats;
    private final List<T> passengers = new ArrayList<>();

    public Vehicle(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getOccupiedSeats() {
        return passengers.size();
    }

    public void boardPassenger(T passenger) {
        if (passengers.size() >= maxSeats) {
            throw new VehicleFullException("Немає вільних місць у транспортному засобі.");
        }
        passengers.add(passenger);
    }

    public void alightPassenger(T passenger) {
        if (!passengers.remove(passenger)) {
            throw new PassengerNotFoundException("Пасажир не знаходиться у цьому транспортному засобі.");
        }
    }
}