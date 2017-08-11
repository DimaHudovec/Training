package parsers.staxparser;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;

/**
 * Created by hudov on 11.08.2017.
 */
public class StAXMain {
    static Logger logger = Logger.getLogger(StAXMain.class);
    public static void main(String [] args) throws IOException {
        logger.addAppender(new FileAppender(new SimpleLayout(),"logs/StAXLog"));
        AirplanesStAXBuilder staxBuilder = new AirplanesStAXBuilder();
        staxBuilder.buildSetAirplanes("data/airplanes.xml");
        logger.info(staxBuilder.getAirplanes());
    }
}
