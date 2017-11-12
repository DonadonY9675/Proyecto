/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.unmsm.sistemaalmacen.daou.AccesoDB;
import pe.unmsm.sistemaalmacen.dominio.EntradaSalida;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.daou.DetalleEntradaSalidaDAO;

/**
 *
 * @author Josecarlos
 */
public class DetalleEntradaSalidaDAOImpl implements DetalleEntradaSalidaDAO{
    private final AccesoDB accesoDB = new AccesoDB();
    
    private final String nombreTabla = "DetalleEntrada";
    
    private final String campoCodProducto = "Producto_codigoProducto";
    private final String campoFolio = "RegistroEntrada_folio";
    private final String campoMonto = "monto";
    private final String campoCantidad = "cantidad";

    private final int folio;
    
    public DetalleEntradaSalidaDAOImpl(int folio) {
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
            System.out.println(e);
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

    @Override
    public ListaDoble<EntradaSalida> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Integer folio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
