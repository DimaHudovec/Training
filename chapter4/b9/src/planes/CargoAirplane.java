package planes;

/**
 * Created by Dima Hudovec on 03.08.2017.
 */
public class CargoAirplane extends Airplane {
    private int carryingCapacity;
    private static Tipe tipe = Tipe.CARGO;

    public CargoAirplane(int flightRange, String manufacturer, double fuelConsumption, int carryingCapacity) {
        super(flightRange, manufacturer, fuelConsumption);
        this.carryingCapacity = carryingCapacity;
    }

    @Override
    public  Tipe getTipe() {
        return tipe;
    }

    @Override
    public int getCapacity() {
        return carryingCapacity;
    }

    @Override
    public String toString() {
        return "CargoAirplane: " +
                "carryingCapacity = " + carryingCapacity +
                " " + super.toString();
    }
}
