package pe.unmsm.sistemaalmacen.dao.impl;

import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.unmsm.sistemaalmacen.daou.AccesoDB;
import pe.unmsm.sistemaalmacen.daou.UsuarioDAO;
import pe.unmsm.sistemaalmacen.dominio.Usuario;
/**
 *
 * @author Josecarlos
 */
public class UsuarioDAOImpl implements UsuarioDAO{

    private final AccesoDB accesoDB = new AccesoDB();
    
    private final String nombreTabla="usuario";
    private final String campoNombre="nombreUsuario";
    private final String campoContrasenia="contrasenia";
    private final String campoEsAdmin="esAdmin";
    
    @Override
    public boolean registrar(Usuario nuevoUsuario) {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "INSERT INTO "+nombreTabla+" ("+campoNombre
                    +","+campoContrasenia+","+campoEsAdmin+") VALUES (?,?,?);";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nuevoUsuario.getNombre());
            pstmt.setString(2, nuevoUsuario.getContrasenia());
            pstmt.setBoolean(3, nuevoUsuario.isEsAdmin());

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
    public boolean modificar(Usuario usuario) {
    try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "INSERT INTO "+nombreTabla+" ("+campoNombre
                    +","+campoContrasenia+","+campoEsAdmin+") VALUES (?,?,?);";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getContrasenia());
            pstmt.setBoolean(3, usuario.isEsAdmin());

            pstmt.executeUpdate();
            
            accesoDB.cerrarConexion(conn, pstmt);
            //Devuelve true si las sentencias se han ejecutado correctamente
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    @Override
    public Usuario get(String id) {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            /* Preparamos la conexion hacia la base de datos */
            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "SELECT "+campoContrasenia+","+campoEsAdmin+" FROM "
                    +nombreTabla+" WHERE "+campoNombre+" = ?";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);

            /* Ejecutamos la sentencias SQL */
            rs = pstmt.executeQuery();

            /* Obtenemos los datos seleccionados */
            if (rs.next()) {

                String contrasenia = rs.getString(campoContrasenia);
                boolean esAdmin = rs.getBoolean(campoEsAdmin);
                
                return new Usuario(id, contrasenia, esAdmin);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        return null;
    }

    @Override
    public ListaDoble<Usuario> getAll() {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;
            ListaDoble<Usuario> listaUsuarios = new ListaDoble<>();
            
            /* Preparamos la conexion hacia la base de datos */
            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "SELECT "+campoNombre+","+campoContrasenia+","+campoEsAdmin+" FROM "
                    +nombreTabla;
            
            pstmt = conn.prepareStatement(query);
            
            /* Ejecutamos la sentencias SQL */
            rs = pstmt.executeQuery();

            /* Obtenemos los datos seleccionados */
            while (rs.next()) {
                String nombre = rs.getString(campoNombre);
                String contrasenia = rs.getString(campoContrasenia);
                boolean esAdmin = rs.getBoolean(campoEsAdmin);
                
                listaUsuarios.insertarAlInicio(new Usuario(nombre, contrasenia,
                        esAdmin));
            }
            
            accesoDB.cerrarConexion(conn, pstmt);
            
            return listaUsuarios;
        } catch (Exception e) {
            System.out.println(e);
        }

        /* Si no encontro ningun dato, retornamos null */
        return null;
    }

    @Override
    public boolean eliminar(String id) {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "DELETE FROM "+nombreTabla+" WHERE "
                    +campoNombre+" = ?;";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);

            pstmt.executeUpdate();

            accesoDB.cerrarConexion(conn, pstmt);
            
            //Devuelve true si las sentencias se han ejecutado correctamente
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
}
