package parsers.saxparser;

/**
 * Created by hudov on 10.08.2017.
 */
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXException;
import java.io.IOException;
public class SAXSimpleMain {
    public static void main(String[ ] args) {
        /*try {
// создание SAX-анализатора
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SimpleAirplaneHandler handler = new SimpleAirplaneHandler();
            reader.setContentHandler(handler);
            reader.parse("data/airplanes.xml");
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока " + e);
        }*/
        AirplanesSAXBuilder saxBuilder = new AirplanesSAXBuilder();
        saxBuilder.buildSetAirplanes("data/airplanes.xml");
        System.out.println(saxBuilder.getAirplanes());
    }
}
