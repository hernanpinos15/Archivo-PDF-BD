
package app.bd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para saveArchivo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="saveArchivo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="objApJSON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveArchivo", propOrder = {
    "objApJSON"
})
public class SaveArchivo {

    protected String objApJSON;

    /**
     * Obtiene el valor de la propiedad objApJSON.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjApJSON() {
        return objApJSON;
    }

    /**
     * Define el valor de la propiedad objApJSON.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjApJSON(String value) {
        this.objApJSON = value;
    }

}
