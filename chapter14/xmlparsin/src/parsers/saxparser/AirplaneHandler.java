package parsers.saxparser;


import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import planes.Airplane;
import planes.CargoAirplane;
import planes.PassengerAirplane;

/**
 * Created by hudov on 10.08.2017.
 */
public class AirplaneHandler extends DefaultHandler {
    private Set<Airplane> airplanes;
    private Airplane current = null;
    private AirplaneEnum currentEnum = null;
    private EnumSet<AirplaneEnum> withText;
    public AirplaneHandler() {
        airplanes = new HashSet<Airplane>();
        withText = EnumSet.range(AirplaneEnum.PRICE, AirplaneEnum.HEIGH);
    }
    public Set<Airplane> getAirplanes() {
        return airplanes;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("cargoairplane".equals(localName)){
            current = new CargoAirplane();
            current.setModel(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                current.setOrigin(attrs.getValue(1));
            }
        }
        else if ("passengerairplane".equals(localName)) {
            current = new PassengerAirplane();
            current.setModel(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                current.setOrigin(attrs.getValue(1));
            }
        }
        else {
            AirplaneEnum temp = AirplaneEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if ("cargoairplane".equals(localName) || "passengerairplane".equals(localName)) {
            airplanes.add(current);
        }
    }
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            if(currentEnum == AirplaneEnum.PRICE) {
                current.setPrice(Double.parseDouble(s));
            }
            else if(currentEnum == AirplaneEnum.RADAR) {
                current.setRadar(Boolean.parseBoolean(s));
            }
            else if(currentEnum == AirplaneEnum.CAPACITY || currentEnum == AirplaneEnum.CARIGECAPACITY) {
                current.setCapacity(Integer.parseInt(s));
            }
            else if(currentEnum == AirplaneEnum.LENGT) {
                current.getParameters().setLength(Integer.parseInt(s));
            }
            else if(currentEnum == AirplaneEnum.WIDTH) {
                current.getParameters().setWidth(Integer.parseInt(s));
            }
            else if(currentEnum == AirplaneEnum.HEIGH) {
                current.getParameters().setHeigh(Integer.parseInt(s));
            }
            else
                throw new EnumConstantNotPresentException(
                        currentEnum.getDeclaringClass(), currentEnum.name());
            }
        currentEnum = null;
    }
}
