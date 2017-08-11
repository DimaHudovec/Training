
package planes;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PassengerAirplane complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PassengerAirplane">
 *   &lt;complexContent>
 *     &lt;extension base="{airplanes}Airplane">
 *       &lt;sequence>
 *         &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PassengerAirplane", namespace = "airplanes", propOrder = {
    "capacity"
})
public class PassengerAirplane
    extends Airplane
{


    @XmlElement(namespace = "airplanes", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected int capacity;

    /**
     * Gets the value of the capacity property.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */

    public PassengerAirplane(){}

    public PassengerAirplane(double price, boolean radar, Parameters parameters, String model, String origin, int capacity) {
        super(price, radar, parameters, model, origin);
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link int }
     *     
     */
    @Override
    public void setCapacity(int value) {
        this.capacity = value;
    }

    @Override
    public String toString() {
        return "PassengerAirplane{" +
                "capacity=" + capacity +
                "} " + super.toString();
    }
}
