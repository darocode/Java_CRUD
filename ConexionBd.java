/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sena
 */
public class ConexionBd {
    //1.Declarar Variables y/u Objetos

    private String driver, user, password, dataBase, urlBd;

    //Connection,Stagtment,Prepare Stagment
    private Connection conexion;

    public ConexionBd() {
        //2.Asignar Valores

        driver = "com.mysql.cj.jdbc.Driver";
        user = "Daniel";
        password = "admin2005";
        dataBase = "consesionario";
        urlBd = "jdbc:mysql://localhost:3306/" + dataBase;

        //3.Conectarse a la BD
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection( urlBd, user, password);
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error de Conexion" + e.toString());
        }
    }

    public Connection obtenerConexion() {
        return conexion;
    }

    public Connection cerrarConexion() throws SQLException {
        conexion.close();
        conexion = null;

        return conexion;
    }
    
    public static void main(String[] args) {
        new ConexionBd();
    }
}
