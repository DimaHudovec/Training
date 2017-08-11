package planes;

/**
 * Created by hudov on 11.08.2017.
 */

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "airplanes", name = "airplanes")
public class Airplanes {
    @XmlElement(name="airplanes")
    private ArrayList<Airplane> list = new ArrayList<Airplane>();
    public Airplanes() {
        super();
    }
    public void setList(ArrayList<Airplane> list) {
        this.list = list;
    }
    public boolean add(Airplane airplane) {
        return list.add(airplane);
    }
    @Override
    public String toString() {
        return "Airplanes [list=" + list + "]";
    }
}
