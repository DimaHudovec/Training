package parsers.staxparser;

/**
 * Created by hudov on 11.08.2017.
 */
import parsers.saxparser.AirplaneEnum;
import planes.Airplane;
import planes.CargoAirplane;
import planes.Parameters;
import planes.PassengerAirplane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
public class AirplanesStAXBuilder {
    private HashSet<Airplane> airplanes = new HashSet<>();
    private XMLInputFactory inputFactory;
    public AirplanesStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }
    public Set<Airplane> getAirplanes() {
        return airplanes;
    }
    public void buildSetAirplanes(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
// StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (AirplaneEnum.valueOf(name.toUpperCase()) == AirplaneEnum.CARGOAIRPLANE ||
                            AirplaneEnum.valueOf(name.toUpperCase()) == AirplaneEnum.PASSENGERAIRPLANE) {
                        Airplane ap = buildAirplane(reader, name.toUpperCase());
                        airplanes.add(ap);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file "+fileName+" : "+e);
            }
        }
    }
    private Airplane buildAirplane(XMLStreamReader reader, String airplaneType) throws XMLStreamException {
        Airplane airplane = new CargoAirplane();
        if(AirplaneEnum.valueOf(airplaneType) == AirplaneEnum.PASSENGERAIRPLANE){
            airplane = new PassengerAirplane();
        }
        airplane.setModel(reader.getAttributeValue(null, AirplaneEnum.MODEL.getValue()));
        airplane.setOrigin(reader.getAttributeValue(null,AirplaneEnum.ORIGIN.getValue())); // проверить на null
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            if(type == XMLStreamConstants.START_ELEMENT) {
                name = reader.getLocalName();
                if (AirplaneEnum.valueOf(name.toUpperCase()) == AirplaneEnum.PRICE) {
                    airplane.setPrice(Double.parseDouble(getXMLText(reader)));
                }
                if (AirplaneEnum.valueOf(name.toUpperCase()) == AirplaneEnum.RADAR) {
                    airplane.setRadar(Boolean.parseBoolean(getXMLText(reader)));
                }
                if (AirplaneEnum.valueOf(name.toUpperCase()) == AirplaneEnum.PARAMETERS) {
                    airplane.setParameters(getXMLParameters(reader));
                }
                if (AirplaneEnum.valueOf(name.toUpperCase()) == AirplaneEnum.CAPACITY ||
                        AirplaneEnum.valueOf(name.toUpperCase()) == AirplaneEnum.CARIGECAPACITY) {
                    airplane.setCapacity(Integer.parseInt(getXMLText(reader)));
                }
            }
            else if(type == XMLStreamConstants.END_ELEMENT){
                name = reader.getLocalName();
                if (AirplaneEnum.valueOf(name.toUpperCase()) == AirplaneEnum.CARGOAIRPLANE ||
                        AirplaneEnum.valueOf(name.toUpperCase()) == AirplaneEnum.PASSENGERAIRPLANE) {
                    return airplane;
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }
    private Parameters getXMLParameters(XMLStreamReader reader) throws XMLStreamException {
        Parameters parameters = new Parameters();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            if(type == XMLStreamConstants.START_ELEMENT) {
                name = reader.getLocalName();
                if (AirplaneEnum.valueOf(name.toUpperCase()) == AirplaneEnum.LENGT) {
                    parameters.setLength(Integer.parseInt(getXMLText(reader)));
                }
                if (AirplaneEnum.valueOf(name.toUpperCase()) == AirplaneEnum.WIDTH) {
                    parameters.setWidth(Integer.parseInt(getXMLText(reader)));
                }
                if (AirplaneEnum.valueOf(name.toUpperCase()) == AirplaneEnum.HEIGH) {
                    parameters.setHeigh(Integer.parseInt(getXMLText(reader)));
                }
            }
            else if (type == XMLStreamConstants.END_ELEMENT){
                name = reader.getLocalName();
                if (AirplaneEnum.valueOf(name.toUpperCase()) == AirplaneEnum.PARAMETERS){
                    return parameters;
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag Parameters");
    }
    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
