/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author
 */
public class AccesoDatos {

    private Connection con;
    private Exception error;
    private ResultSet rs;

    public AccesoDatos() {
        this.con = null;
        this.error = null;
    }

    /**
     * @return the error
     */
    public Exception getError() {
        return error;
    }

    /*0 signifiuca falso y cualkier otro valor es verdadero*/
    public ResultSet getRs() {
        return rs;
    }

    public Byte Connectar() {
        Byte result = 0;
        try {
            if (this.con == null) {
                Class.forName(app.bd.Global.driverclass);
                result = 1;
                this.con = DriverManager.getConnection(app.bd.Global.databaseURL, app.bd.Global.usuarioDB, app.bd.Global.claveDB);
                result = 2;
            } else {
                result = 2;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("ERROR: " + e.getClass().getName() + "***" + e.getMessage());
            this.error = e;
        } finally {
            return result;
        }

    }

    public Byte Desconectar() {
        Byte result = 0;
        try {
            this.getCon().close();
            /*este null es el destructor porque en java no esxiste destructor*/
            this.con = null;
            result = 1;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("ERROR: " + e.getClass().getName() + "***" + e.getMessage());
            this.error = e;
        } finally {
            return result;
        }
    }

    public Byte EjecutarSQL(String SQL) {
        Byte result = 0;
        try {
            Statement smt = this.getCon().createStatement();
            this.rs = smt.executeQuery(SQL);
            result = 1;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("ERROR: " + e.getClass().getName() + " *** " + e.getMessage());

            this.error = e;
        } finally {
            return result;
        }
    }

    /*itra forma de utilizar los sql */
    public Byte EjecutarUpdate(String SQL) {
        Byte result = 0;
        try {
            PreparedStatement smt = this.getCon().prepareStatement(SQL);
            smt.executeUpdate();
            this.rs = smt.executeQuery(SQL);
            result = 1;
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getClass().getName() + " *** " + e.getMessage());
            this.error = e;
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }
}
