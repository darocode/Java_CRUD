/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVeo.UsuarioVeo;
import Util.ConexionBd;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sena
 */
public class UsuarioDao extends ConexionBd {
    //Connection
    //Preparedstatement (PUENTE){Peticiones SQL  "INSERT, UPDATE, DELETE"}
    //ResultSET(Mensajero){Peticiones de consulta SQL "SELECT"}

    //1. Declarar Variables u Objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String usuId = "", usuLogin = "", usuPassword = "";

    //2. Metodo Principal para recibir datos del VO
    public UsuarioDao(UsuarioVeo usuveo) {
        super();
        //2.1 Conectarse a BD
        try {
            conexion = this.obtenerConexion();

            //2.2 Traer los datos del VO
            usuId = usuveo.getUsuId();
            usuLogin = usuveo.getUsuLogin();
            usuPassword = usuveo.getUsuPassword();

        } catch (Exception e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null,e);
        }
    }

}
