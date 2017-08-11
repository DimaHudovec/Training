package parsers.saxparser;

/**
 * Created by hudov on 10.08.2017.
 */

import planes.Airplane;
import java.io.IOException;
import java.util.Set;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
public class AirplanesSAXBuilder {
    private Set<Airplane> airplanes;
    private AirplaneHandler ah;
    private XMLReader reader;
    public AirplanesSAXBuilder() {
// создание SAX-анализатора
        ah = new AirplaneHandler();
        try {
// создание объекта-обработчика
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(ah);
        } catch (SAXException e) {
            System.err.print("SAX parser error: " + e);
        }
    }
    public Set<Airplane> getAirplanes() {
        return airplanes;
    }
    public void buildSetAirplanes(String fileName) {
        try {
// разбор XML-документа
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        airplanes = ah.getAirplanes();
    }
}

