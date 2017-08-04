package planes;

import java.util.ArrayList;

/**
 * Created by Dima Hudovec on 03.08.2017.
 */
public class PassengerAirplane extends Airplane {
    private int capacity;
    private static Tipe tipe = Tipe.PASSENGER;

    public PassengerAirplane(int flightRange, String manufacturer, double fuelConsumption, int capacity) {
        super(flightRange, manufacturer, fuelConsumption);
        this.capacity = capacity;
    }
    @Override
    public Tipe getTipe() {
        return tipe;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "PassengerAirplane: " +
                "capacity = " + capacity +
                " " + super.toString();
    }


}

