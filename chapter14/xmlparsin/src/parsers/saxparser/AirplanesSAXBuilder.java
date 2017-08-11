package parsers.saxparser;

/**
 * Created by hudov on 10.08.2017.
 */

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import planes.Airplane;
import java.io.IOException;
import java.util.Set;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
public class AirplanesSAXBuilder {
    static Logger logger = Logger.getLogger(AirplanesSAXBuilder.class);
    private Set<Airplane> airplanes;
    private AirplaneHandler ah;
    private XMLReader reader;
    public AirplanesSAXBuilder() throws IOException {
        logger.addAppender(new FileAppender(new SimpleLayout(),"logs/SAXLog"));
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
            System.err.print("SAX parser error: " + e);
        } catch (IOException e) {
            System.err.print("I/О thread error: " + e);
        }
        airplanes = ah.getAirplanes();
    }
}

