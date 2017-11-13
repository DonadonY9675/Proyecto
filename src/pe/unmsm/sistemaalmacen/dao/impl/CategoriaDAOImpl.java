package pe.unmsm.sistemaalmacen.dao.impl;

import pe.unmsm.sistemaalmacen.dominio.Categoria;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.unmsm.sistemaalmacen.daou.AccesoDB;
import pe.unmsm.sistemaalmacen.daou.CategoriaDAO;

/**
 *
 * @author Miguel
 */
public class CategoriaDAOImpl implements CategoriaDAO{
    
    private final AccesoDB accesoDB= new AccesoDB();
    
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

            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "INSERT INTO "+nombreTabla+" ("+campoCodCategoria+","
                    +campoDescrip+") "+ "VALUES (?,?);";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, nuevaCat.getCodigo());
            pstmt.setString(2, nuevaCat.getDescripcion());

            pstmt.executeUpdate();

            accesoDB.cerrarConexion(conn, pstmt);
            //Devuelve true si las sentencias se han ejecutado correctamente
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean modificar(Categoria elem) {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "UPDATE "+nombreTabla+" SET ("+campoCodCategoria
                    +"= ?,"+campoDescrip+"= ? WHERE "+campoCodCategoria+" = ?;";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, elem.getCodigo());
            pstmt.setString(2, elem.getDescripcion());

            pstmt.executeUpdate();
            
            accesoDB.cerrarConexion(conn, pstmt);
            //Devuelve true si las sentencias se han ejecutado correctamente
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Categoria get(Integer id) {try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;
            Categoria categoria = null;
            
            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "SELECT "+campoCodCategoria+","+campoDescrip+" FROM "
                    +nombreTabla+" WHERE "+campoCodCategoria+" = "+id.toString();
            
            pstmt = conn.prepareStatement(query);
            
            /* Ejecutamos la sentencias SQL */
            rs = pstmt.executeQuery();

            /* Obtenemos los datos seleccionados */
            if (rs.next()) {
                String descrip = rs.getString(campoDescrip);
                
                categoria = new Categoria(id, descrip);
            }
            
            accesoDB.cerrarConexion(conn, pstmt);
            
            return categoria;
        } catch (Exception e) {
            System.out.println(e);
        }

        /* Si no encontro ningun dato, retornamos null */
        return null;
    }

    @Override
    public ListaDoble<Categoria> getAll() {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;
            ListaDoble<Categoria> listaCategorias = new ListaDoble<>();
            
            conn = accesoDB.getConexion();

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
            
            accesoDB.cerrarConexion(conn, pstmt);
            
            return listaCategorias;
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Si no encontro ningun dato, retornamos null */
        return null;
    }

    @Override
    public boolean eliminar(Integer id) {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "DELETE FROM "+nombreTabla+" WHERE "
                    +campoCodCategoria+" = ?;";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            accesoDB.cerrarConexion(conn, pstmt);
            
            //Devuelve true si las sentencias se han ejecutado correctamente
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

 
    
}
