import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleGenericsTest {

    @Test
    void testTaxiCanCarryAnyone() {
        Taxi taxi = new Taxi(3);
        taxi.boardPassenger(new RegularPassenger("Іван"));
        taxi.boardPassenger(new Policeman("Петро"));
        taxi.boardPassenger(new Firefighter("Олексій"));

        assertEquals(3, taxi.getOccupiedSeats());
    }

    @Test
    void testPoliceCarOnlyAcceptsPolicemen() {
        PoliceCar policeCar = new PoliceCar(2);
        Policeman cop = new Policeman("Максим");
        policeCar.boardPassenger(cop);

        // Наступний рядок не скомпілюється, що і є вимогою generics:
        // policeCar.boardPassenger(new RegularPassenger("Анна"));

        assertEquals(1, policeCar.getOccupiedSeats());
    }

    @Test
    void testVehicleFullExceptionIsThrown() {
        FireEngine fireEngine = new FireEngine(1);
        fireEngine.boardPassenger(new Firefighter("Богдан"));

        assertThrows(VehicleFullException.class, () -> {
            fireEngine.boardPassenger(new Firefighter("Олег"));
        });
    }

    @Test
    void testPassengerNotFoundExceptionIsThrown() {
        Bus bus = new Bus(10);
        RegularPassenger passenger = new RegularPassenger("Олена");

        assertThrows(PassengerNotFoundException.class, () -> {
            bus.alightPassenger(passenger);
        });
    }

    @Test
    void testRoadCalculatesTotalHumansCorrectly() {
        Road road = new Road();

        Taxi taxi = new Taxi(4);
        taxi.boardPassenger(new RegularPassenger("Пасажир 1"));
        taxi.boardPassenger(new Policeman("Коп у відпустці"));

        FireEngine fireEngine = new FireEngine(3);
        fireEngine.boardPassenger(new Firefighter("Пожежник 1"));

        road.addCarToRoad(taxi);
        road.addCarToRoad(fireEngine);

        assertEquals(3, road.getCountOfHumans());
    }
}
