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
import pe.unmsm.sistemaalmacen.dao.DetalleEntradaSalidaDAO;
import pe.unmsm.sistemaalmacen.dao.RegistroDAO;
import pe.unmsm.sistemaalmacen.dominio.EntradaSalida;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.dominio.Registro;
import pe.unmsm.sistemaalmacen.dominio.RegistroEntrada;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;

/**
 *
 * @author Josecarlos
 */
public abstract class RegistroDAOImpl implements RegistroDAO{
    private AccesoDB accesoDB = new AccesoDB();
    
    private String nombreTabla = "---";
    
    private String campoFolio = "folio";
    private String campoUsuario = "usuario";
    private String campoFecha = "fecha";
    
    protected String campoAgente = "---";
    
    private String campoSubTotal = "subTotal";
    private String campoImpuestos = "impuestos";
    private String campoTotal = "total";
    private String campoObserv = "observaciones";

    public RegistroDAOImpl(String nombreTabla, String campoAgente) {
        this.nombreTabla = nombreTabla;
        this.campoAgente = campoAgente;
    }
    
    @Override
    public boolean registrar(Registro elem) {
    try {

            ResultSet rs = null;
            Connection conn = null;
            PreparedStatement pstmt = null;

            conn = accesoDB.getConexion();

            /* Preparamos la sentencia SQL a ejecutar */
            String query = "INSERT INTO "+nombreTabla+" ("+campoFolio+","
                    +campoUsuario+","+campoFecha+","+campoAgente+","
                    +campoSubTotal+","+campoImpuestos+","+campoTotal+","
                    +campoObserv+") VALUES (?,?,?,?,?,?,?,?);";
            
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, elem.getFolio());
            pstmt.setString(2, elem.getUsusario());
            pstmt.setDate(3, elem.getFecha());
            pstmt.setString(4,"");
//            pstmt.setString(4, elem.getProveedor());
            pstmt.setFloat(5, elem.getSubTotal());
            pstmt.setFloat(6, elem.getImpuestos());
            pstmt.setFloat(7, elem.getTotal());
            pstmt.setString(8, elem.getObservaciones());

            pstmt.executeUpdate();
            
            DetalleEntradaSalidaDAO detalleDAO = obtenerTipoDetalleDAO(elem.getFolio());
  
            //Registra cada detalle entrada salida en la base de datos
            elem.getListaEntradaSalida().stream().forEach(detalleDAO::registrar);
            
            accesoDB.cerrarConexion(conn, pstmt);
            //Devuelve true si las sentencias se han ejecutado correctamente
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean modificar(Registro e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RegistroEntrada get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaDoble<Registro> getAll() {
//try     {

//            DetalleEntradaSalidaDAO detalleDAO = null;
//            
//            ResultSet rs = null;
//            Connection conn = null;
//            PreparedStatement pstmt = null;
//            ListaDoble<Registro> listaRegistro = new ListaDoble<>();
//            
//            /* Preparamos la conexion hacia la base de datos */
//            conn = accesoDB.getConexion();
//
//            /* Preparamos la sentencia SQL a ejecutar */
//            String query = "SELECT "+campoFolio+","+campoUsuario+","+campoFecha
//                    +","+campoObserv+","+campoAgente+","+campoSubTotal+","
//                    +campoImpuestos+","+campoTotal+" FROM "+nombreTabla;
//            
//            pstmt = conn.prepareStatement(query);
//            
//            /* Ejecutamos la sentencias SQL */
//            rs = pstmt.executeQuery();
//
//            /* Obtenemos los datos seleccionados */
//            while (rs.next()) {
//                int folio = rs.getInt(campoFolio);
//                String usuario = rs.getString(campoUsuario);
//                Date fecha = rs.getDate(campoFecha);
//                String proveedor = rs.getString(campoAgente);
//                String observaciones = rs.getString(campoObserv);
//                float subTotal = rs.getFloat(campoSubTotal);
//                float impuestos = rs.getFloat(campoImpuestos);
//                float total = rs.getFloat(campoTotal);
//                
//                detalleDAO = new DetalleEntradaDAOImpl(folio);
//                
//                ListaDoble<EntradaSalida> listaDetalle = detalleDAO.getAll();
//                
//                listaRegistro.insertarAlInicio(new Registro(folio, fecha,
//                        usuario, listaDetalle, observaciones, subTotal,
//                        impuestos, total) {
//                });
//            }
//            
//            accesoDB.cerrarConexion(conn, pstmt);
//            
//            return listaRegistro;
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        /* Si no encontro ningun dato, retornamos null */
//        return null;
        //PRUEBA DE RETURN
        ListaDoble<Registro> listaRegistroEntrada = new ListaDoble();
        ListaDoble<EntradaSalida> listaIngreso1 = new ListaDoble();
        ListaDoble<EntradaSalida> listaIngreso2 = new ListaDoble();
        ListaDoble<Producto> miLista = new ListaDoble();
        Producto prod1 = new Producto(1, "TelevisorEntrada", "LG", "HG002",
                "Unidades", "ESTAND 01", 1, 0, 730);
        Producto prod2 = new Producto(2, "LavadoraEntrada", "LG", "LV002",
                "Unidades", "ESTAND 02", 1, 5, 650);
        Producto prod3 = new Producto(3, "LaptopEntrada", "Razer", "RZ002",
                "Unidades", "ESTAND 01", 1, 0, 3000);
        Producto prod4 = new Producto(4, "Iphone 8Entrada", "Apple", "SC0001",
                "Unidades", "ESTAND 03", 1, 5, 3600);

        listaIngreso1.insertarAlFinal(new EntradaSalida(prod1, 32, 12331));
        listaIngreso1.insertarAlFinal(new EntradaSalida(prod2, 3, 3245));
        

        listaRegistroEntrada.insertarAlFinal(new RegistroEntrada(1, new Date(7,8,9), "Usuario1", "Proveedor1",  listaIngreso1,"Observacion 1",1234f, 12312.0f,123123.0f));
        
        listaIngreso2.insertarAlFinal(new EntradaSalida(prod3, 2, 5477));
        listaIngreso2.insertarAlFinal(new EntradaSalida(prod4, 13, 1331));
        listaIngreso2.insertarAlFinal(new EntradaSalida(prod1, 23, 321));
        
        listaRegistroEntrada.insertarAlFinal(new RegistroEntrada(2, new Date(10,11,12), "Administrador2", "Proveedor2",  listaIngreso2,"Observacion 2",21234f, 123.0f,3123.0f));

        return listaRegistroEntrada;

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
                    +campoFolio+" = ?;";
           
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
