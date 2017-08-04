package planes;

import java.util.ArrayList;

public abstract class Airplane {

    private int flightRange;

    private double fuelConsumption;

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

    public static ArrayList<Airplane> sortByRange (ArrayList<Airplane> airplanes){
        for (int i = airplanes.size() - 1 ; i >= 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if(airplanes.get(j).getFlightRange() > airplanes.get(j+1).getFlightRange()){
                    Airplane plane = airplanes.get(j);
                    airplanes.set(j,airplanes.get(j+1));
                    airplanes.set(j+1,plane);
                }
            }
        }
        return airplanes;
    }

    public static int [] getTotalCapacity(ArrayList<Airplane> planes){
        int [] capas = new int[2];
        for (int i = 0 ; i < 2 ; i++){
            capas[i] = 0;
        }
        for (Airplane plane : planes) {
            if(plane.getTipe() == Tipe.PASSENGER){
                capas[0] += plane.getCapacity();
            }
            else if(plane.getTipe() == Tipe.CARGO){
                capas[1] += plane.getCapacity();
            }
        }
        return capas;
    }



    public static ArrayList<Airplane> filterByFuelCons (ArrayList<Airplane> airplanes, int min, int max){
        ArrayList<Airplane> filteredPlanes = new ArrayList<Airplane>();
        for (Airplane plane : airplanes) {
            if(plane.getFuelConsumption() < max && plane.getFuelConsumption() > min){
                filteredPlanes.add(plane);
            }
        }
        return filteredPlanes;
    }

}
