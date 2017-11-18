/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.unmsm.sistemaalmacen.dao.AccesoDB;
import pe.unmsm.sistemaalmacen.dominio.DetalleRegistro;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.dominio.Registro;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;

/**
 *
 * @author Miguel
 */
public class DetalleRegistroDAOImpl {

    private static final AccesoDB accesoDB = new AccesoDB();

    private static final String nombreTabla = "DetalleRegistro";

    private static final String CAMPO_CODIGO_REGISTRO = "Registro_codigoRegistro";
    private static final String CAMPO_CODIGO_PRODUCTO = "Producto_codigoProducto";
    private static final String CAMPO_MONTO = "monto";
    private static final String CAMPO_CANTIDAD = "cantidad";

    public boolean registrar(DetalleRegistro elem) {

        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "INSERT INTO " + nombreTabla + " (" + CAMPO_CODIGO_REGISTRO + ","
                    + CAMPO_CODIGO_PRODUCTO + "," + CAMPO_MONTO + "," + CAMPO_CANTIDAD + ") "
                    + "VALUES (?,?,?,?);";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, elem.getCodigo());
            pstmt.setInt(2, elem.getProducto().getCodigo());
            pstmt.setFloat(3, (float) elem.getMonto());
            pstmt.setFloat(4, (float) elem.getCantidad());

            pstmt.executeUpdate();

            accesoDB.cerrarConexion(conn, pstmt);

            //Devuelve true si las sentencias se han ejecutado correctamente
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean modificar(DetalleRegistro e) {
        return true;
    }

    public DetalleRegistro get(String id) {
        return null;
    }

    public ListaDoble<DetalleRegistro> getAll() {
        
        try {
 
            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;
            ListaDoble<DetalleRegistro> listaRegistro = new ListaDoble<>();

            /* Preparamos la conexion hacia la base de datos */
            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "SELECT " + CAMPO_CODIGO_REGISTRO + ","
                    + CAMPO_CODIGO_PRODUCTO + "," + CAMPO_MONTO + "," + CAMPO_CANTIDAD
                    + " FROM " + nombreTabla;
           

            pstmt = conn.prepareStatement(query);

            /* Ejecutamos la sentencias SQL */
            rs = pstmt.executeQuery();

            /* Obtenemos los datos seleccionados */
            
            while (rs.next()) {
                String codigoDetalle = rs.getString(CAMPO_CODIGO_REGISTRO);
                int codigoProducto = rs.getInt(CAMPO_CODIGO_PRODUCTO);
                float monto = rs.getFloat(CAMPO_MONTO);
                float agente = rs.getFloat(CAMPO_CANTIDAD);

                Producto producto = new ProductoDAOImpl().get(codigoProducto);

                listaRegistro.insertarAlFinal(new DetalleRegistro(codigoDetalle, producto, monto, agente));
            }

            accesoDB.cerrarConexion(conn, pstmt);
            
            return listaRegistro;
        } catch (Exception e) {
            System.out.println(e);
        }

        /* Si no encontro ningun dato, retornamos null */
        return null;
    }//fin

    public boolean eliminar(String id) {
        return true;
    }
}
