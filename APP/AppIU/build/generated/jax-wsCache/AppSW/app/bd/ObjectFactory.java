
package app.bd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the app.bd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LoadArchivo_QNAME = new QName("http://bd.app/", "loadArchivo");
    private final static QName _LoadArchivoResponse_QNAME = new QName("http://bd.app/", "loadArchivoResponse");
    private final static QName _SaveArchivo_QNAME = new QName("http://bd.app/", "saveArchivo");
    private final static QName _SaveArchivoResponse_QNAME = new QName("http://bd.app/", "saveArchivoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: app.bd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoadArchivo }
     * 
     */
    public LoadArchivo createLoadArchivo() {
        return new LoadArchivo();
    }

    /**
     * Create an instance of {@link LoadArchivoResponse }
     * 
     */
    public LoadArchivoResponse createLoadArchivoResponse() {
        return new LoadArchivoResponse();
    }

    /**
     * Create an instance of {@link SaveArchivo }
     * 
     */
    public SaveArchivo createSaveArchivo() {
        return new SaveArchivo();
    }

    /**
     * Create an instance of {@link SaveArchivoResponse }
     * 
     */
    public SaveArchivoResponse createSaveArchivoResponse() {
        return new SaveArchivoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadArchivo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bd.app/", name = "loadArchivo")
    public JAXBElement<LoadArchivo> createLoadArchivo(LoadArchivo value) {
        return new JAXBElement<LoadArchivo>(_LoadArchivo_QNAME, LoadArchivo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadArchivoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bd.app/", name = "loadArchivoResponse")
    public JAXBElement<LoadArchivoResponse> createLoadArchivoResponse(LoadArchivoResponse value) {
        return new JAXBElement<LoadArchivoResponse>(_LoadArchivoResponse_QNAME, LoadArchivoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveArchivo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bd.app/", name = "saveArchivo")
    public JAXBElement<SaveArchivo> createSaveArchivo(SaveArchivo value) {
        return new JAXBElement<SaveArchivo>(_SaveArchivo_QNAME, SaveArchivo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveArchivoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bd.app/", name = "saveArchivoResponse")
    public JAXBElement<SaveArchivoResponse> createSaveArchivoResponse(SaveArchivoResponse value) {
        return new JAXBElement<SaveArchivoResponse>(_SaveArchivoResponse_QNAME, SaveArchivoResponse.class, null, value);
    }

}
