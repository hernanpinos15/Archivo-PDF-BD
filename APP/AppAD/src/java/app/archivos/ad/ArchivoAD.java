/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.archivos.ad;

import app.archivos.Archivo;
import app.bd.AccesoDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Logger;

public class ArchivoAD extends Archivo {

    public Integer guardarArchivo(AccesoDatos ad, byte[] archivo) {
        Integer idApp = 0;
        String SQLInsert = "";
        try {
            SQLInsert = "INSERT INTO tb_app (archivos) VALUES (?) returning id_app;";
            PreparedStatement consultaPDF = ad.getCon().prepareStatement(SQLInsert);
            ResultSet rs;
            consultaPDF.setBytes(1, archivo);
            rs = consultaPDF.executeQuery();
            while (rs.next()) {               
                idApp = rs.getInt(1);    
            }
            rs.close();
            consultaPDF.close();
        } catch (SQLException e) {
            Logger.getLogger("ArchivoAD").log(java.util.logging.Level.SEVERE, "archivo.ad", e.getClass().getName() + "-----" + e.getMessage());
            System.err.println("ERROR: " + e.getClass().getName() + "----" + e.getMessage());
        }
        return idApp;
    }
    
    public void agregarArchivo(AccesoDatos ad) {
        try {
            String SQL = "SELECT archivos FROM tb_app ORDER BY id_app DESC LIMIT 1";
            if (ad.EjecutarSQL(SQL) != 0) {
                ResultSet rsArchivo = ad.getRs();
                while (rsArchivo.next()) {
                    this.agregarArchivoByte(rsArchivo);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger("ArchivoAD").log(java.util.logging.Level.SEVERE, "archivo.ad", e.getClass().getName() + "-----" + e.getMessage());
            System.err.println("ERROR: " + e.getClass().getName() + "----" + e.getMessage());
        }
    }
    
    /**
     * @param rsArchivo
     */
    public void agregarArchivoByte(ResultSet rsArchivo) {
        try {
            this.setArchivo(rsArchivo.getBytes("archivos"));
        } catch (SQLException e) {
            Logger.getLogger("ArchivoAD").log(java.util.logging.Level.SEVERE, "archivo.ad", e.getClass().getName() + "-----" + e.getMessage());
            System.err.println("ERROR: " + e.getClass().getName() + "----" + e.getMessage());
        }
    }

}
