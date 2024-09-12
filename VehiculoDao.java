/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import ModeloVeo.VehiculoVo;
import Util.ConexionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alrod
 */
public class VehiculoDao extends ConexionBd{
    //Connection
    //Preparedstatement (PUENTE){Peticiones SQL  "INSERT, UPDATE, DELETE"}
    //ResultSET(Mensajero){Peticiones de consulta SQL "SELECT"}

    //1. Declarar Variables u Objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String vehPlaca = "", datId = "", catId = "", vehModelo = "", vehMarca = "", vehEstado = "", vehPrecio = "";
    
    
    public VehiculoDao(VehiculoVo vehvo){
        super();
        
        try {
            conexion = this.obtenerConexion();
            
            vehPlaca = vehvo.getVehPlaca();
            datId = vehvo.getDatId();
            catId = vehvo.getCatId();
            vehModelo = vehvo.getVehModelo();
            vehMarca = vehvo.getVehMarca();
            vehEstado = vehvo.getVehEstado();
            vehPrecio = vehvo.getVehPrecio();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null,e);
        }
    
    }
}
