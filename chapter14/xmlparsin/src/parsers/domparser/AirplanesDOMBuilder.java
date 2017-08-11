package parsers.domparser;

/**
 * Created by hudov on 11.08.2017.
 */
import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import planes.Airplane;
import planes.CargoAirplane;
import planes.Parameters;
import planes.PassengerAirplane;

public class AirplanesDOMBuilder {
    static Logger logger = Logger.getLogger(AirplanesDOMBuilder.class);
    private Set<Airplane> airplanes;
    private DocumentBuilder docBuilder;
    public AirplanesDOMBuilder() throws IOException {
        logger.addAppender(new FileAppender(new SimpleLayout(),"logs/DOMLog"));
        this.airplanes = new HashSet<Airplane>();
// создание DOM-анализатора
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("Parser configuration error: " + e);
        }
    }
    public Set<Airplane> getAirplanes() {
        return airplanes;
    }
    public void buildSetAirplanes(String fileName) {
        Document doc = null;
        try {
// parsing XML-документа и создание древовидной структуры
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
// получение списка дочерних элементов <student>
            NodeList airplanesList = root.getElementsByTagName("cargoairplane");
            for (int i = 0; i < airplanesList.getLength(); i++) {
                Element airplaneElement = (Element) airplanesList.item(i);
                Airplane airplane = buildAirplane(airplaneElement);
                airplanes.add(airplane);
            }
            airplanesList = root.getElementsByTagName("passengerairplane");
            for (int i = 0; i < airplanesList.getLength(); i++) {
                Element airplaneElement = (Element) airplanesList.item(i);
                Airplane airplane = buildAirplane(airplaneElement);
                airplanes.add(airplane);
            }
        } catch (IOException e) {
            logger.error("File error or I/O error: " + e);
        } catch (SAXException e) {
            logger.error("Parsing failure: " + e);
        }
    }
    private Airplane buildAirplane(Element airplaneElement) {
        Airplane airplane = new CargoAirplane();

        if(airplaneElement.getTagName() == "passengerairplane"){
            airplane = new PassengerAirplane();
        }
// заполнение объекта student
        airplane.setModel(airplaneElement.getAttribute("model"));
        airplane.setOrigin(airplaneElement.getAttribute("origin"));
        airplane.setPrice(Double.parseDouble(getElementTextContent(
                airplaneElement,"price")));
        airplane.setRadar(Boolean.parseBoolean(getElementTextContent(
                airplaneElement,"radar")));
        Parameters parameters = airplane.getParameters();
// заполнение объекта address
        Element parametersElement = (Element) airplaneElement.getElementsByTagName(
                "parameters").item(0);
        parameters.setLength(Integer.parseInt(getElementTextContent(
                airplaneElement,"lengt")));
        parameters.setWidth(Integer.parseInt(getElementTextContent(
                airplaneElement,"width")));
        parameters.setHeigh(Integer.parseInt(getElementTextContent(
                airplaneElement,"heigh")));
        if(airplaneElement.getTagName() == "cargoairplane") {
            airplane.setCapacity(Integer.parseInt(getElementTextContent(
                    airplaneElement,"carigecapacity")));
        }
        if(airplaneElement.getTagName() == "passengerairplane"){
            airplane.setCapacity(Integer.parseInt(getElementTextContent(
                    airplaneElement,"capacity")));
        }
        return airplane;
    }
    // получение текстового содержимого тега
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}