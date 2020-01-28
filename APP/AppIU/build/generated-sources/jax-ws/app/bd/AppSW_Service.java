
package app.bd;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AppSW", targetNamespace = "http://bd.app/", wsdlLocation = "http://localhost:8080/AppAD/AppSW?wsdl")
public class AppSW_Service
    extends Service
{

    private final static URL APPSW_WSDL_LOCATION;
    private final static WebServiceException APPSW_EXCEPTION;
    private final static QName APPSW_QNAME = new QName("http://bd.app/", "AppSW");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/AppAD/AppSW?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        APPSW_WSDL_LOCATION = url;
        APPSW_EXCEPTION = e;
    }

    public AppSW_Service() {
        super(__getWsdlLocation(), APPSW_QNAME);
    }

    public AppSW_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), APPSW_QNAME, features);
    }

    public AppSW_Service(URL wsdlLocation) {
        super(wsdlLocation, APPSW_QNAME);
    }

    public AppSW_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, APPSW_QNAME, features);
    }

    public AppSW_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AppSW_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AppSW
     */
    @WebEndpoint(name = "AppSWPort")
    public AppSW getAppSWPort() {
        return super.getPort(new QName("http://bd.app/", "AppSWPort"), AppSW.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AppSW
     */
    @WebEndpoint(name = "AppSWPort")
    public AppSW getAppSWPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://bd.app/", "AppSWPort"), AppSW.class, features);
    }

    private static URL __getWsdlLocation() {
        if (APPSW_EXCEPTION!= null) {
            throw APPSW_EXCEPTION;
        }
        return APPSW_WSDL_LOCATION;
    }

}