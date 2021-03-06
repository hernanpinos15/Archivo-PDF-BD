
package app.bd;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AppSW", targetNamespace = "http://bd.app/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AppSW {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadArchivo", targetNamespace = "http://bd.app/", className = "app.bd.LoadArchivo")
    @ResponseWrapper(localName = "loadArchivoResponse", targetNamespace = "http://bd.app/", className = "app.bd.LoadArchivoResponse")
    @Action(input = "http://bd.app/AppSW/loadArchivoRequest", output = "http://bd.app/AppSW/loadArchivoResponse")
    public String loadArchivo();

    /**
     * 
     * @param objApJSON
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "saveArchivo", targetNamespace = "http://bd.app/", className = "app.bd.SaveArchivo")
    @ResponseWrapper(localName = "saveArchivoResponse", targetNamespace = "http://bd.app/", className = "app.bd.SaveArchivoResponse")
    @Action(input = "http://bd.app/AppSW/saveArchivoRequest", output = "http://bd.app/AppSW/saveArchivoResponse")
    public Boolean saveArchivo(
        @WebParam(name = "objApJSON", targetNamespace = "")
        String objApJSON);

}
