/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.dao.impl;

import proy.dominio.Categoria;
import estructuras.ListaDoble;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static proy.dao.AbstractDAO.PASSWORD;
import static proy.dao.AbstractDAO.URL_BASEDEDATOS;
import static proy.dao.AbstractDAO.USUARIO;
import proy.dao.CategoriaDAO;

/**
 *
 * @author Miguel
 */
public class CategoriaDAOImpl implements CategoriaDAO{
    
    // Nombre de la tabla y sus campos en la base de datos
    private final String nombreTabla="categoria";
    private final String campoCodCategoria="codigoCategoria";
    private final String campoDescrip="descripcion";
    
    //implmeentacion, solo consultas registros en la Base de datos, 
    //aqui NO SE HACEN VALIDACIONES
    @Override
    public boolean registrar(Categoria nuevaCat) {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            /* Preparamos la conexion hacia la base de datos */
            conn = DriverManager.getConnection(URL_BASEDEDATOS, USUARIO, PASSWORD);

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "INSERT INTO "+nombreTabla+" ("+campoDescrip+") "
                    + "VALUES (?);";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nuevaCat.getDescripcion());

            pstmt.executeUpdate();

            //Devuelve true si las sentencias se han ejecutado correctamente
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    @Override
    public boolean modificar(Categoria e) {
        return true;
    }

    @Override
    public Categoria get(Integer id) {
        return null;
    }

    @Override
    public ListaDoble<Categoria> getAll() {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;
            ListaDoble<Categoria> listaCategorias = new ListaDoble<>();
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            /* Preparamos la conexion hacia la base de datos */
            conn = DriverManager.getConnection(URL_BASEDEDATOS, USUARIO, PASSWORD);

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "SELECT "+campoCodCategoria+","+campoDescrip+" FROM "
                    +nombreTabla;
            
            pstmt = conn.prepareStatement(query);
            
            /* Ejecutamos la sentencias SQL */
            rs = pstmt.executeQuery();

            /* Obtenemos los datos seleccionados */
            while (rs.next()) {
                int id = rs.getInt(campoCodCategoria);
                String descrip = rs.getString(campoDescrip);
                
                listaCategorias.insertarAlInicio(new Categoria(id, descrip));
            }
            return listaCategorias;
        } catch (Exception e) {
            System.out.println(e);
        }

        /* Si no encontro ningun dato, retornamos null */
        return null;
    }

    @Override
    public boolean eliminar(Integer id) {
        return false;
    }

 
    
}
