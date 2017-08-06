package planes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Airplane {
    /** Airplane flight range */
    private int flightRange;

    /** Airplane fuel consumption */
    private double fuelConsumption;

    /** Airplane manufacturer */
    private String manufacturer;

    public Airplane(int flightRange, String manufacturer , double fuelConsumption) {
        this.flightRange = flightRange;
        this.manufacturer = manufacturer;
        this.fuelConsumption = fuelConsumption;
    }

    public abstract int getCapacity();

    public abstract Tipe getTipe();

    @Override
    public String toString() {
        return "flightRange = " + flightRange +
                ", fuelConsumption = " + fuelConsumption +
                ", manufacturer = " + manufacturer + '\'' +
                ' ';
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public double getFuelConsumption() { return fuelConsumption; }

}
