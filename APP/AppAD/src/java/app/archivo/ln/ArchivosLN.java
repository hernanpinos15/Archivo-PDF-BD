package app.archivo.ln;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import app.archivos.ad.ArchivoAD;
import app.bd.AccesoDatos;

public class ArchivosLN {

    AccesoDatos ad = new AccesoDatos();
    Gson gson = new Gson();
    ArchivoAD pdfAD = new ArchivoAD();
    String strSQL = "";

    public Boolean saveArchivo(String objApJSON) throws SQLException {
        Boolean respuesta = false;
        Integer idApp = 0;
        if (ad.Connectar() != 0) {
            pdfAD = gson.fromJson(objApJSON, ArchivoAD.class);
            idApp = pdfAD.guardarArchivo(ad, pdfAD.getArchivo());
            if(idApp >= 1){
                respuesta = true;
            }else{
                respuesta = false;
            }
        }
        return respuesta;
    }

    /**
     * @return
     */
    public String loadArchivo(){
        String result = "";
        if (ad.Connectar() != 0) {
            try {
                pdfAD.agregarArchivo(ad);
                result = gson.toJson(pdfAD);
            } catch (JsonSyntaxException e) {
                Logger.getLogger("ArchivoLN").log(java.util.logging.Level.SEVERE, "archivo.ln", e.getClass().getName() + "-----" + e.getMessage());
                System.err.println("ERROR: " + e.getClass().getName() + "----" + e.getMessage());
            }
        }
        ad.Desconectar();
        return result;

    }
    
}
