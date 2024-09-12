/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVeo.UsuarioVeo;
import Util.ConexionBd;
import Util.Crud;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sena
 */
public class UsuarioDao extends ConexionBd implements Crud {
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
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {

        try {

            sql = "insert into usuario(usulogin, usupassword) values (?, ?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {

            sql = "update usuario set usulogin=?,usupassword=? where usuid=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.setString(3, usuId);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        try {

            sql = "DELETE FROM usuario WHERE usulogin = ? and usupassword = ? and usuid = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.setString(3, usuId);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    public boolean inicioSesion(String usuLogin, String usuPassword) {
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario where usulogin=? and usupassword=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                operacion = true;

            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

}
