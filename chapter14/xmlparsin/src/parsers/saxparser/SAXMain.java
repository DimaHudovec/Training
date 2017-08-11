package parsers.saxparser;

/**
 * Created by hudov on 10.08.2017.
 */
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXException;
import java.io.IOException;
public class SAXMain {
    public static void main(String[ ] args) {
        AirplanesSAXBuilder saxBuilder = new AirplanesSAXBuilder();
        saxBuilder.buildSetAirplanes("data/airplanes.xml");
        System.out.println(saxBuilder.getAirplanes());
    }
}
