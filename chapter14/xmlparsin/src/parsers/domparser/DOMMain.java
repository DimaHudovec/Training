package parsers.domparser;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import parsers.saxparser.SAXMain;

import java.io.IOException;

/**
 * Created by hudov on 11.08.2017.
 */
public class DOMMain {
    static Logger logger = Logger.getLogger(DOMMain.class);
    public static void main(String [] args) throws IOException {
        logger.addAppender(new FileAppender(new SimpleLayout(),"logs/DOMLog"));
        AirplanesDOMBuilder domBuilder = new AirplanesDOMBuilder();
        domBuilder.buildSetAirplanes("data/airplanes.xml");
        logger.info(domBuilder.getAirplanes());
    }
}
