/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.daou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lab02-Pc11
 */
public class AccesoDB {
   
    private static final String USUARIO = "root";
    private static final String PASWORD = "root";
    private static final String HOST = "localhost:3306";
    private static final String BD = "almacen";
    Connection conexion;
    
    public Connection getConexion(){
        try {
            //Carga el Driver de Mysql
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Obtener un conexion con los permisos respectivos
            //desde el SGBD.
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://" + HOST + "/" + BD, USUARIO, PASWORD);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return conexion;
    }
    
    public void cerrarConexion(Connection con, PreparedStatement ps){
        try {
            con.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error de cerrado de conexion");
        }
    }
}
