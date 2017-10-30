package proy.dao.impl;

import estructuras.ListaDoble;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import proy.dao.UsuarioDao;
import proy.dominio.Usuario;
/**
 *
 * @author Josecarlos
 */
public class UsuarioDAOImpl implements UsuarioDao{

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

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            /* Preparamos la conexion hacia la base de datos */
            conn = DriverManager.getConnection(URL_BASEDEDATOS, USUARIO, PASSWORD);

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "INSERT INTO "+nombreTabla+" ("+campoNombre
                    +","+campoContrasenia+","+campoEsAdmin+") VALUES (?,?,?);";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nuevoUsuario.getNombre());
            pstmt.setString(2, nuevoUsuario.getContrasenia());
            pstmt.setBoolean(3, nuevoUsuario.isEsAdmin());

            pstmt.executeUpdate();

            //Devuelve true si las sentencias se han ejecutado correctamente
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    @Override
    public boolean modificar(Usuario e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario get(String id) {
//        try {
//
//            ResultSet rs = null;
//            Connection conn = null;
//            PreparedStatement pstmt = null;
//
//            /* Preparamos la conexion hacia la base de datos */
//            conn = DriverManager.getConnection(URL_BASEDEDATOS, USUARIO, PASSWORD);
//
//            /* Preparamos la sentencia SQL a ejecutar */
//            String query = "SELECT "+campoContrasenia+","+campoEsAdmin+" FROM "
//                    +nombreTabla+" WHERE "+campoNombre+" = ?";
//            
//            pstmt = conn.prepareStatement(query);
//            pstmt.setString(1, id);
//
//            /* Ejecutamos la sentencias SQL */
//            rs = pstmt.executeQuery();
//
//            /* Obtenemos los datos seleccionados */
//            if (rs.next()) {
//
//                String contrasenia = rs.getString(campoContrasenia);
//                boolean esAdmin = rs.getBoolean(campoEsAdmin);
//                
//                return new Usuario(id, contrasenia, esAdmin);
//
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        return new Usuario("Pepito", "123", true);

    }

    @Override
    public ListaDoble<Usuario> getAll() {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;
            ListaDoble<Usuario> listaUsuarios = new ListaDoble<>();
            
            /* Preparamos la conexion hacia la base de datos */
            conn = DriverManager.getConnection(URL_BASEDEDATOS, USUARIO, PASSWORD);

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
                
                listaUsuarios.insertarAlInicio(new Usuario(nombre, contrasenia, esAdmin));
            }
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

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            /* Preparamos la conexion hacia la base de datos */
            conn = DriverManager.getConnection(URL_BASEDEDATOS, USUARIO, PASSWORD);

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "DELETE FROM "+nombreTabla+" WHERE "
                    +campoNombre+" = ?;";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);

            pstmt.executeUpdate();

            //Devuelve true si las sentencias se han ejecutado correctamente
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
}
