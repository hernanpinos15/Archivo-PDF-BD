/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bd;

import app.archivo.ln.ArchivosLN;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author herna
 */
@WebService(serviceName = "AppSW")
public class AppSW {

    ArchivosLN archivoln = new ArchivosLN();
    @WebMethod(operationName = "saveArchivo")
    public Boolean saveArchivo(@WebParam(name = "objApJSON") String objApJSON) {
        Boolean result = false;
        try {
            result = archivoln.saveArchivo(objApJSON);
        } catch (Exception e) {
            Logger.getLogger("archivoWSAcdatos").log(Level.SEVERE, "app.sw", e.getClass().getName() + "*****" + e.getMessage());
            System.err.println("ERROR: " + e.getClass().getName() + "***" + e.getMessage());
        }
        return result;
    }

    /* *************************************************************************
     *  Mostrar archivo pdf
     * *************************************************************************
     */
    @WebMethod(operationName = "loadArchivo")
    public String loadArchivo() {
        String result = "";
        try {
            result = archivoln.loadArchivo();
        } catch (Exception e) {
            Logger.getLogger("archivoWSAcdatos").log(Level.SEVERE, "app.sw", e.getClass().getName() + "*****" + e.getMessage());
            System.err.println("ERROR: " + e.getClass().getName() + "***" + e.getMessage());
        }
        return result;
    }
    
}
