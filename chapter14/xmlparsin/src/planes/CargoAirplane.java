
package planes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CargoAirplane complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CargoAirplane">
 *   &lt;complexContent>
 *     &lt;extension base="{airplanes}Airplane">
 *       &lt;sequence>
 *         &lt;element name="carigecapacity" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CargoAirplane", namespace = "airplanes", propOrder = {
    "carigecapacity"
})
public class CargoAirplane
    extends Airplane
{

    public CargoAirplane() {}

    public CargoAirplane(double price, boolean radar, Parameters parameters, String model, String origin, int carigecapacity) {
        super(price, radar, parameters, model, origin);
        this.carigecapacity = carigecapacity;
    }

    @XmlElement(namespace = "airplanes")
    protected int carigecapacity;

    /**
     * Gets the value of the carigecapacity property.
     * 
     */
    @Override
    public int getCapacity() {
        return carigecapacity;
    }

    /**
     * Sets the value of the carigecapacity property.
     * 
     */
    @Override
    public void setCapacity(int value) {
        this.carigecapacity = value;
    }

    @Override
    public String toString() {
        return "CargoAirplane{" +
                "carigecapacity=" + carigecapacity +
                "} " + super.toString();
    }
}
