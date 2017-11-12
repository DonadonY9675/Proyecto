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
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.daou.ProductoDAO;
import pe.unmsm.sistemaalmacen.dominio.Usuario;

/**
 * 
 */
public class ProductoDAOImpl implements ProductoDAO{
    private final AccesoDB accesoDB = new AccesoDB();
    
    // Nombre de la tabla y sus campos en la base de datos
    private final String nombreTabla="producto";
    
    private final String campoCodigo="codigoProducto";
    private final String campoNombre="nombre";
    private final String campoMarca="marca";
    private final String campoModelo="modelo";
    private final String campoUniMed="unidadDeMedida";
    private final String campoUbic="ubicacion";
    private final String campoCantMin="cantidadMinima";
    private final String campoExsist="existencias";
    private final String campoPrecUnit="precioUnitario";
    private final String campoCodCat="codigoCategoria";
    
    @Override
    public boolean registrar(Producto elem) {
         try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "INSERT INTO "+nombreTabla+" ("+campoCodigo+","
                    +campoNombre+","+campoMarca+","+campoModelo+","+campoUniMed+
                    ","+campoUbic+","+campoCantMin+","+campoExsist+","
                    +campoPrecUnit+")VALUES(?,?,?,?,?,?,?,?,?);";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, elem.getCodigo());
            pstmt.setString(2, elem.getNombre());
            pstmt.setString(3, elem.getMarca());
            pstmt.setString(4, elem.getModelo());
            pstmt.setString(5, elem.getUnidadDeMedida());
            pstmt.setString(6, elem.getUbicacion());
            pstmt.setFloat(7, elem.getCantidadMinima());
            pstmt.setFloat(8, elem.getExistencia());
            pstmt.setFloat(9, elem.getPrecioUnitario());
            //pstmt.setString(10, elem.());

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
    public ListaDoble<Producto> getAll() {
        //Logica para buscar todos
        //SELECT
//        try {
//
//            ResultSet rs = null;
//            Connection conn = null;
//            PreparedStatement pstmt = null;
//            ListaDoble<Producto> listaProductos = new ListaDoble<>();
//            
//            /* Preparamos la conexion hacia la base de datos */
//            conn = accesoDB.getConexion();
//
//            /* Preparamos la sentencia SQL a ejecutar */
//            String query = "SELECT "+campoCodigo+","+campoNombre+","+
//                    campoMarca+","+campoModelo+","+campoUniMed+
//                    ","+campoUbic+","+campoCantMin+","+campoExsist+","
//                    +campoPrecUnit+" FROM "
//                    +nombreTabla;
//            
//            pstmt = conn.prepareStatement(query);
//            
//            /* Ejecutamos la sentencias SQL */
//            rs = pstmt.executeQuery();
//
//            /* Obtenemos los datos seleccionados */
//            while (rs.next()) {
//                int codigo  = rs.getInt(campoCodigo);
//                String nombre = rs.getString(campoNombre);
//                String marca = rs.getString(campoMarca);
//                String modelo = rs.getString(campoModelo);
//                String unidadMedida = rs.getString(campoUniMed);
//                String ubicacion = rs.getString(campoUbic);
//                float cantidadMin = rs.getFloat(campoCantMin);
//                float existencias = rs.getFloat(campoExsist);
//                float precioUni = rs.getFloat(campoPrecUnit);
//                
//                listaProductos.insertarAlInicio(new Producto(codigo, nombre,
//                        marca, modelo, unidadMedida, ubicacion, cantidadMin,
//                        existencias, precioUni));
//            }
//            
//            accesoDB.cerrarConexion(conn, pstmt);
//            
//            return listaProductos;
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        /* Si no encontro ningun dato, retornamos null */
//        return null;
    
        //prueba
        ListaDoble<Producto> miLista = new ListaDoble();
        miLista.insertarAlInicio(new Producto(1,"Televisor LG 55º pulgadas","LG","HG002",
                "Unidades","ESTAND 01",1,0,730));
        miLista.insertarAlInicio(new Producto(2,"Lavadora","LG","LV002",
                "Unidades","ESTAND 02",1,5,650));
         miLista.insertarAlInicio(new Producto(3,"Laptop","Razer","RZ002",
                "Unidades","ESTAND 01",1,0,3000));
        miLista.insertarAlInicio(new Producto(4,"Iphone 8","Apple","SC0001",
                "Unidades","ESTAND 03",1,5,3600));
        miLista.insertarAlInicio(new Producto(5,"Comida para perros","Ricocan","N/A",
                "Kg","ESTAND 01",3,5.5f,4.5f));
        miLista.insertarAlInicio(new Producto(6,"Cereal","Angel","N/A",
                "Bolsas de 50g c/u","ESTAND 02",5,25,4));
         miLista.insertarAlInicio(new Producto(7,"Televisor Samsung 30º pulgadas","Samsung","KI000",
                "Unidades","ESTAND 01",1,0,3000));
        miLista.insertarAlInicio(new Producto(8,"Celular","Sony","SG001",
                "Unidades","ESTAND 03",5,25,200));
        
        
        return miLista;
        
    }

    @Override
    public Producto get(Integer ID) {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;
            Producto producto = null;
            
            /* Preparamos la conexion hacia la base de datos */
            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "SELECT "+campoCodigo+","+campoNombre+","+
                    campoMarca+","+campoModelo+","+campoUniMed+
                    ","+campoUbic+","+campoCantMin+","+campoExsist+","
                    +campoPrecUnit+" FROM "
                    +nombreTabla+ " WHERE "+campoCodigo+ " = ?";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, ID);
            
            /* Ejecutamos la sentencias SQL */
            rs = pstmt.executeQuery();

            /* Obtenemos los datos seleccionados */
            if (rs.next()) {
                int codigo  = rs.getInt(campoCodigo);
                String nombre = rs.getString(campoNombre);
                String marca = rs.getString(campoMarca);
                String modelo = rs.getString(campoModelo);
                String unidadMedida = rs.getString(campoUniMed);
                String ubicacion = rs.getString(campoUbic);
                float cantidadMin = rs.getFloat(campoCantMin);
                float existencias = rs.getFloat(campoExsist);
                float precioUni = rs.getFloat(campoPrecUnit);
                
                producto = new Producto(codigo, nombre,
                        marca, modelo, unidadMedida, ubicacion, cantidadMin,
                        existencias, precioUni);
            }
            
            accesoDB.cerrarConexion(conn, pstmt);
            
            return producto;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }

    @Override
    public boolean modificar(Producto elem) {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;
            Producto producto = null;
            
            /* Preparamos la conexion hacia la base de datos */
            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "UPDATE "+nombreTabla+" SET "+campoCodigo+"= ?,"+
                    campoNombre+" = ?,"+campoMarca+" = ?,"+campoModelo+" = ?,"+
                    campoUniMed+" = ?,"+campoUbic+" = ?,"+campoCantMin+" = ?,"+
                    campoExsist+" = ?,"+campoPrecUnit+" = ? WHERE "+campoCodigo+
                    " = ?;";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, elem.getCodigo());
            pstmt.setString(2,elem.getNombre());
            pstmt.setString(3,elem.getMarca());
            pstmt.setString(4,elem.getModelo());
            pstmt.setString(5,elem.getUnidadDeMedida());
            pstmt.setString(6,elem.getUbicacion());
            pstmt.setFloat(7, elem.getCantidadMinima());
            pstmt.setFloat(8, elem.getExistencia());
            pstmt.setFloat(9, elem.getPrecioUnitario());
                
            /* Ejecutamos la sentencias SQL */
            rs = pstmt.executeQuery();
            
            accesoDB.cerrarConexion(conn, pstmt);
            
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
        
    }

    @Override
    public boolean eliminar(Integer ID) {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "DELETE FROM "+nombreTabla+" WHERE "
                    +campoCodigo+" = ?;";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, ID);

            pstmt.executeUpdate();

            accesoDB.cerrarConexion(conn, pstmt);
            
            //Devuelve true si las sentencias se han ejecutado correctamente
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }



//    @Override
//    public List<Producto> buscarPorCategoria(Integer codigoCategoria) {
//        //Logica de buscar por NOMBRE
//        //SELECT
//        //WHERE codigoCategoria = codigoCategoria
//        List<Producto> lsProducto = new ArrayList<>();
//        return lsProducto;    
//    }
//    
//    @Override
//    public List<Producto> buscarConCategoria() {
//        //Logica de buscar por NOMBRE
//        //SELECT 
//        //JOIN p.codigoCategoria = c.codigoCategoria
//        List<Producto> lsProducto = new ArrayList<>();
//        return lsProducto;    
//    }
     
    /**
     * Realiza una consulta de productos por nombre
     * nombre: Nombre de producto a buscar en la base de datos
     * return: Lista de productos que contienen el nombre buscado
     */
    public ListaDoble<Producto> consultarProductosPorNombre(String nombre){
        //Logica de buscar por NOMBRE
        //SELECT
        //WHERE nombre = nombre
        
        return null;
    }
    
    /**
     * Realiza una buqueda de un producto por codigo en la base de datos,
     * devuelve solo el producto con dicho codigo (no existe duplicado de codigos)
     * @param cod: codigo a buscar
     * @return : Producto con codigo = cod
     */
    public Producto consultarProductoPorCodigo(int cod) {
        return null;
    }
    
}
