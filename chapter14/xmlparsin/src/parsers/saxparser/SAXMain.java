package parsers.saxparser;

/**
 * Created by hudov on 10.08.2017.
 */
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXException;
import java.io.IOException;
public class SAXMain {
    static Logger logger = Logger.getLogger(SAXMain.class);
    public static void main(String[ ] args) throws IOException {
        logger.addAppender(new FileAppender(new SimpleLayout(),"logs/SAXLog"));
        AirplanesSAXBuilder saxBuilder = new AirplanesSAXBuilder();
        saxBuilder.buildSetAirplanes("data/airplanes.xml");
        logger.info(saxBuilder.getAirplanes());
    }
}
