import parsers.domparser.DOMMain;
import parsers.saxparser.SAXMain;
import parsers.staxparser.StAXMain;

import java.io.IOException;

/**
 * Created by hudov on 11.08.2017.
 */
public class Runner {
    public static void main (String [] args) throws IOException {
        SAXMain.main(args);
        StAXMain.main(args);
        DOMMain.main(args);
    }
}
