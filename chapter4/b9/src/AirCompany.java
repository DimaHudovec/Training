import planes.*;

import java.util.ArrayList;

/**
 * Created by hudov on 03.08.2017.
 */
public class AirCompany {
    private String companyName;

    public ArrayList<Airplane> getCompanyPlanes() {
        return companyPlanes;
    }

    public void addCompanyPlanes(ArrayList<Airplane> companyPlanes) {
        for (Airplane plane : companyPlanes) {
            this.companyPlanes.add(plane);
        }
    }

    private ArrayList<Airplane> companyPlanes = new ArrayList<Airplane>();

    public AirCompany(String companyName) {
        this.companyName = companyName;
    }

}
