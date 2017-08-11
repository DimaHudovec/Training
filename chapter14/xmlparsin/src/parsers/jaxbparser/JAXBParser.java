package parsers.jaxbparser;

/**
 * Created by hudov on 11.08.2017.
 */
import planes.Airplane;
import planes.Airplanes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
public class JAXBParser {
    public static void main(String[ ] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Airplanes.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("data/airplanes.xml");
            Airplanes airplanes = (Airplanes) u.unmarshal(reader);
            System.out.println(airplanes);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
