/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.dao.impl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.unmsm.sistemaalmacen.dao.AccesoDB;
import pe.unmsm.sistemaalmacen.dao.CategoriaDAO;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.dao.ProductoDAO;
import pe.unmsm.sistemaalmacen.dominio.Categoria;
import pe.unmsm.sistemaalmacen.dominio.Usuario;

/**
 * 
 */
public class ProductoDAOImpl implements ProductoDAO{
    private final AccesoDB ACCESO_DB = new AccesoDB();
    
    // Nombre de la tabla y sus campos en la base de datos
    private final String NOMBRE_TABLA="producto";
    
    private static  final String CAMPO_CODIGO="codigoProducto";
    private static final String CAMPO_NOMBRE="nombre";
    private static final String CAMPO_MARCA="marca";
    private static final String CAMPO_MODELO="modelo";
    private static final String CAMPO_UIND_MED="unidadDeMedida";
    private static final String CAMPO_UBIC="ubicacion";
    private static final String CAMPO_CANT_MIN="cantidadMinima";
    private static final String CAMPO_EXIST="existencias";
    private static final String CAMPO_PREC_UNI="precioUnitario";
    private static final String CAMPO_COD_CAT="codigoCategoria";
    private static final String CAMPO_IMAGEN="imagen";
    
    @Override
    public boolean registrar(Producto elem) {
         try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            conn = ACCESO_DB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "INSERT INTO "+NOMBRE_TABLA+" ("+CAMPO_CODIGO+","
                    +CAMPO_NOMBRE+","+CAMPO_MARCA+","+CAMPO_MODELO+","+CAMPO_UIND_MED+
                    ","+CAMPO_UBIC+","+CAMPO_CANT_MIN+","+CAMPO_EXIST+","
                    +CAMPO_PREC_UNI+","+CAMPO_IMAGEN+","+CAMPO_COD_CAT+")VALUES(?,?,?,?,?,?,?,?,?,?,?);";
            
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
            pstmt.setBlob(10, elem.getImagen());
            pstmt.setInt(11,elem.getCat()==null? null :elem.getCat().getCodigo());

            pstmt.executeUpdate();
            
            ACCESO_DB.cerrarConexion(conn, pstmt);
            //Devuelve true si las sentencias se han ejecutado correctamente
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public ListaDoble<Producto> getAll() {
        //Logica para buscar todos
        //SELECT
        try {

            CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
            
            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;
            ListaDoble<Producto> listaProductos = new ListaDoble<>();
            
            /* Preparamos la conexion hacia la base de datos */
            conn = ACCESO_DB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "SELECT "+CAMPO_CODIGO+","+CAMPO_NOMBRE+","+
                    CAMPO_MARCA+","+CAMPO_MODELO+","+CAMPO_UIND_MED+
                    ","+CAMPO_UBIC+","+CAMPO_CANT_MIN+","+CAMPO_EXIST+","
                    +CAMPO_PREC_UNI+","+CAMPO_IMAGEN+","+CAMPO_COD_CAT+" FROM "
                    +NOMBRE_TABLA;
            
            pstmt = conn.prepareStatement(query);
            
            /* Ejecutamos la sentencias SQL */
            rs = pstmt.executeQuery();

            /* Obtenemos los datos seleccionados */
            while (rs.next()) {
                int codigo  = rs.getInt(CAMPO_CODIGO);
                String nombre = rs.getString(CAMPO_NOMBRE);
                String marca = rs.getString(CAMPO_MARCA);
                String modelo = rs.getString(CAMPO_MODELO);
                String unidadMedida = rs.getString(CAMPO_UIND_MED);
                String ubicacion = rs.getString(CAMPO_UBIC);
                float cantidadMin = rs.getFloat(CAMPO_CANT_MIN);
                float existencias = rs.getFloat(CAMPO_EXIST);
                float precioUni = rs.getFloat(CAMPO_PREC_UNI);
                Blob imagen = rs.getBlob(CAMPO_IMAGEN);
                int codigoCategoria = rs.getInt(CAMPO_COD_CAT);
                
                Categoria categoria = categoriaDAO.get(codigoCategoria);
                
                listaProductos.insertarAlInicio(new Producto(codigo, nombre,
                        marca, modelo, categoria, unidadMedida, ubicacion,
                        cantidadMin, existencias, precioUni,imagen));
            }
            
            ACCESO_DB.cerrarConexion(conn, pstmt);
            
            return listaProductos;
        } catch (Exception e) {
            System.out.println(e);
        }

        /* Si no encontro ningun dato, retornamos null */
        return null;
    
        //prueba
//        ListaDoble<Producto> miLista = new ListaDoble();
//        Categoria categoria1 = new Categoria(1, "Productos del hogar");
//        Categoria categoria2 = new Categoria(2, "Limpieza");
//        Categoria categoria3 = new Categoria(3, "Tecnologia");
//        Categoria categoria4 = new Categoria(4, "Electrodomesticos");
//        
//        miLista.insertarAlInicio(new Producto(1,"Televisor LG 55º pulgadas","LG","HG002",
//                categoria3,"Unidades","ESTAND 01",1,0,730));
//        miLista.insertarAlInicio(new Producto(2,"Lavadora","LG","LV002",
//                categoria4,"Unidades","ESTAND 02",1,5,650));
//         miLista.insertarAlInicio(new Producto(3,"Laptop","Razer","RZ002",
//                categoria3,"Unidades","ESTAND 01",1,0,3000));
//        miLista.insertarAlInicio(new Producto(4,"Iphone 8","Apple","SC0001",
//                categoria3,"Unidades","ESTAND 03",1,5,3600));
//        miLista.insertarAlInicio(new Producto(5,"Comida para perros","Ricocan","N/A",
//                categoria1,"Kg","ESTAND 01",3,5.5f,4.5f));
//        miLista.insertarAlInicio(new Producto(6,"Cereal","Angel","N/A",
//                "Bolsas de 50g c/u","ESTAND 02",5,25,4));
//         miLista.insertarAlInicio(new Producto(7,"Televisor Samsung 30º pulgadas","Samsung","KI000",
//                categoria3,"Unidades","ESTAND 01",1,0,3000));
//        miLista.insertarAlInicio(new Producto(8,"Celular","Sony","SG001",
//                categoria3,"Unidades","ESTAND 03",5,25,200));
//        
//        
//        return miLista;
        
    }

    @Override
    public Producto get(Integer ID) {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;
            Producto producto = null;
            
            CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
            
            /* Preparamos la conexion hacia la base de datos */
            conn = ACCESO_DB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "SELECT "+CAMPO_CODIGO+","+CAMPO_NOMBRE+","+
                    CAMPO_MARCA+","+CAMPO_MODELO+","+CAMPO_COD_CAT+","+CAMPO_UIND_MED+
                    ","+CAMPO_UBIC+","+CAMPO_CANT_MIN+","+CAMPO_EXIST+","
                    +CAMPO_PREC_UNI+","+CAMPO_IMAGEN+" FROM " +NOMBRE_TABLA+ " WHERE "
                    +CAMPO_CODIGO+ " = ?";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, ID);
            
            /* Ejecutamos la sentencias SQL */
            rs = pstmt.executeQuery();

            /* Obtenemos los datos seleccionados */
            if (rs.next()) {
                int codigo  = rs.getInt(CAMPO_CODIGO);
                String nombre = rs.getString(CAMPO_NOMBRE);
                String marca = rs.getString(CAMPO_MARCA);
                String modelo = rs.getString(CAMPO_MODELO);
                int codigoCategoria = rs.getInt(CAMPO_COD_CAT);
                String unidadMedida = rs.getString(CAMPO_UIND_MED);
                String ubicacion = rs.getString(CAMPO_UBIC);
                float cantidadMin = rs.getFloat(CAMPO_CANT_MIN);
                float existencias = rs.getFloat(CAMPO_EXIST);
                float precioUni = rs.getFloat(CAMPO_PREC_UNI);
                Blob imagen = rs.getBlob(CAMPO_IMAGEN);
                
                Categoria categoria = categoriaDAO.get(codigoCategoria);
                
                producto = new Producto(codigo, nombre,
                        marca, modelo,categoria, unidadMedida, ubicacion, cantidadMin,
                        existencias, precioUni,imagen);
            }
            
            ACCESO_DB.cerrarConexion(conn, pstmt);
            
            return producto;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }

    @Override
    public boolean modificar(Producto elem) {
        try {

            Connection conn = null;
            PreparedStatement pstmt = null;
            
            /* Preparamos la conexion hacia la base de datos */
            conn = ACCESO_DB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "UPDATE "+NOMBRE_TABLA+" SET "+CAMPO_CODIGO+"= ?,"+
                    CAMPO_NOMBRE+" = ?,"+CAMPO_MARCA+" = ?,"+CAMPO_MODELO+" = ?,"+
                    CAMPO_UIND_MED+" = ?,"+CAMPO_UBIC+" = ?,"+CAMPO_CANT_MIN+" = ?,"+
                    CAMPO_EXIST+" = ?,"+CAMPO_PREC_UNI+" = ?,"+CAMPO_COD_CAT+" = ? WHERE "+CAMPO_CODIGO+
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

            System.out.println(elem.getCat().getDescripcion());
            pstmt.setInt(10,elem.getCat()==null? null : elem.getCat().getCodigo());
            
            pstmt.setInt(11,elem.getCodigo());
                
            /* Ejecutamos la sentencias SQL */
            pstmt.executeUpdate();
            
            ACCESO_DB.cerrarConexion(conn, pstmt);
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
        
    }

    @Override
    public boolean eliminar(Integer ID) {
        try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            conn = ACCESO_DB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "DELETE FROM "+NOMBRE_TABLA+" WHERE "
                    +CAMPO_CODIGO+" = ?;";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, ID);

            pstmt.executeUpdate();

            ACCESO_DB.cerrarConexion(conn, pstmt);
            
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
     
}
