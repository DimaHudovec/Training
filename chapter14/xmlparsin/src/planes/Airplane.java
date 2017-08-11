
package planes;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Airplane complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Airplane">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="radar" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="parameters" type="{airplanes}Parameters"/>
 *       &lt;/sequence>
 *       &lt;attribute name="model" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="origin" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Airplane", namespace = "airplanes", propOrder = {
    "price",
    "radar",
    "parameters"
})
@XmlSeeAlso({
    PassengerAirplane.class,
    CargoAirplane.class
})
public abstract class Airplane {

    @XmlElement(namespace = "airplanes")
    protected double price;
    @XmlElement(namespace = "airplanes")
    protected boolean radar;
    @XmlElement(namespace = "airplanes", required = true)
    protected Parameters parameters = new Parameters();
    @XmlAttribute(name = "model", required = true)
    protected String model;
    @XmlAttribute(name = "origin", required = true)
    protected String origin;

    public Airplane(){}

    public Airplane(double price, boolean radar, Parameters parameters, String model, String origin) {
        this.price = price;
        this.radar = radar;
        this.parameters = parameters;
        this.model = model;
        this.origin = origin;
    }

    /**
     * Gets the value of the price property.
     *
     */
    public abstract int getCapacity();

    /**
     * Sets the value of the price property.
     *
     */
    public abstract void setCapacity(int value);
    /**
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Gets the value of the radar property.
     * 
     */
    public boolean isRadar() {
        return radar;
    }

    /**
     * Sets the value of the radar property.
     * 
     */
    public void setRadar(boolean value) {
        this.radar = value;
    }

    /**
     * Gets the value of the parameters property.
     * 
     * @return
     *     possible object is
     *     {@link Parameters }
     *     
     */
    public Parameters getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parameters }
     *     
     */
    public void setParameters(Parameters value) {
        this.parameters = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    @Override
    public String toString() {
        return  "price=" + price +
                ", radar=" + radar +
                ", parameters=" + parameters +
                ", model='" + model + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
