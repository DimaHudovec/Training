import planes.*;

import java.util.ArrayList;

/**
 * Created by Dima Hudovec on 03.08.2017.
 */
public class AirCompany {
    private String companyName;

    public ArrayList<Airplane> getCompanyPlanes() {
        return companyPlanes;
    }

    public void addCompanyPlanes(ArrayList<Airplane> companyPlanes) {
        this.companyPlanes.addAll(companyPlanes);
    }

    private ArrayList<Airplane> companyPlanes = new ArrayList<Airplane>();

    public AirCompany(String companyName) {
        this.companyName = companyName;
    }

}
