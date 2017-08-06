package planecontrol;

import planes.Airplane;
import planes.Tipe;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Dima Hudovec on 06.08.2017.
 */
public class Control {
    public static ArrayList<Airplane> sortByRange (ArrayList<Airplane> airplanes){
        return airplanes
                .stream()
                .sorted((p1,p2) -> Integer.compare(p1.getFlightRange(),p2.getFlightRange()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static int [] getTotalCapacity(ArrayList<Airplane> planes){
        int [] capas = new int[2];
        capas[0] = planes
                .stream()
                .filter(p -> p.getTipe() == Tipe.PASSENGER)
                .mapToInt(Airplane::getCapacity)
                .sum();
        capas[1] = planes
                .stream()
                .filter(p -> p.getTipe() == Tipe.CARGO)
                .mapToInt(Airplane::getCapacity)
                .sum();
        return capas;
    }



    public static ArrayList<Airplane> filterByFuelCons (ArrayList<Airplane> airplanes, int min, int max){
        return airplanes
                .stream()
                .filter(p -> p.getFuelConsumption() < max && p.getFuelConsumption() > min)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
