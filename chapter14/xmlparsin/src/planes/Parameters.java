
package planes;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Parameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Parameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="heigh" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Parameters", namespace = "airplanes", propOrder = {
    "length",
    "width",
    "heigh"
})
public class Parameters {

    @XmlElement(namespace = "airplanes", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected int length;
    @XmlElement(namespace = "airplanes", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected int width;
    @XmlElement(namespace = "airplanes", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected int heigh;

    public Parameters(){}

    public Parameters(int length, int width, int heigh) {
        this.length = length;
        this.width = width;
        this.heigh = heigh;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     int
     *     
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     *
     * @param value
     *     allowed object is
     *     int
     *     
     */
    public void setLength(int value) {
        this.length = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     int
     *     
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value
     *     allowed object is
     *     int
     *     
     */
    public void setWidth(int value) {
        this.width = value;
    }

    /**
     * Gets the value of the heigh property.
     * 
     * @return
     *     possible object is
     *     int
     *     
     */
    public int getHeigh() {
        return heigh;
    }

    /**
     * Sets the value of the heigh property.
     *
     * @param value
     *     allowed object is
     *     int
     *     
     */
    public void setHeigh(int value) {
        this.heigh = value;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "length=" + length +
                ", width=" + width +
                ", heigh=" + heigh +
                '}';
    }
}
