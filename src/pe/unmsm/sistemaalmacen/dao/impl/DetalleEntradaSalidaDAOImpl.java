/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.unmsm.sistemaalmacen.dao.AccesoDB;
import pe.unmsm.sistemaalmacen.dominio.EntradaSalida;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.dao.DetalleEntradaSalidaDAO;
import pe.unmsm.sistemaalmacen.dao.ProductoDAO;
import pe.unmsm.sistemaalmacen.dominio.Producto;

/**
 *
 * @author Josecarlos
 */
public abstract class DetalleEntradaSalidaDAOImpl implements DetalleEntradaSalidaDAO{
    private final AccesoDB accesoDB = new AccesoDB();
    
    private String nombreTabla = "---";
    
    private final String campoCodProducto = "Producto_codigoProducto";
    private final String campoFolio = "RegistroEntrada_folio";
    private final String campoMonto = "monto";
    private final String campoCantidad = "cantidad";

    private final int folio;
    
    public DetalleEntradaSalidaDAOImpl(String nombreTabla,int folio) {
        this.nombreTabla = nombreTabla;
        this.folio = folio;
    }
    
    
    @Override
    public boolean registrar(EntradaSalida elem) {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "INSERT INTO "+nombreTabla+" ("+campoCodProducto+","
                    +campoFolio+","+campoMonto+","+campoCantidad+") "+
                    "VALUES (?,?,?,?);";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, elem.getProducto().getCodigo());
            pstmt.setInt(2, folio);
            pstmt.setFloat(3, (float)elem.getTotal());
            pstmt.setFloat(4, elem.getCantidad());

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
    public boolean modificar(EntradaSalida e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntradaSalida get(Integer folio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    Devuelve todos los detalles entrada salida de un folio
    */
    @Override
    public ListaDoble<EntradaSalida> getAll() {
        try {
            System.out.println("llamada para folio "+folio);
            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;
            ListaDoble<EntradaSalida> listaEntradaSalida = new ListaDoble<>();
            
            ProductoDAO productoDAO = new ProductoDAOImpl();
            
            /* Preparamos la conexion hacia la base de datos */
            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "SELECT "+campoCodProducto+","+campoCantidad+","
                    +campoMonto+" FROM "+nombreTabla+" WHERE "+campoFolio
                    +" = ?;";
            
            pstmt = conn.prepareStatement(query);
            
            pstmt.setInt(1, folio);
            System.out.println(query);
            /* Ejecutamos la sentencias SQL */
            rs = pstmt.executeQuery();

            /* Obtenemos los datos seleccionados */
            while (rs.next()) {
                System.out.println("existe");
                int codigoProducto = rs.getInt(campoCodProducto);
                int cantidad = (int) rs.getFloat(campoCantidad);
                float monto = rs.getFloat(campoMonto);
                Producto producto = productoDAO.get(codigoProducto);
                
                listaEntradaSalida.insertarAlInicio(new EntradaSalida(producto, cantidad, monto));
            }
            
            accesoDB.cerrarConexion(conn, pstmt);
            
            return listaEntradaSalida;
        } catch (Exception e) {
            System.out.println(e);
        }

        /* Si no encontro ningun dato, retornamos null */
        return null;
    }

    @Override
    public boolean eliminar(Integer folio) {
    try {
            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "DELETE FROM "+nombreTabla+" WHERE "
                    +campoFolio+" = ?;";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, folio);

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
