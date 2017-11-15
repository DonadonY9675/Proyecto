/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.service.impl;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import pe.unmsm.sistemaalmacen.dao.impl.ProductoDAOImpl;
import pe.unmsm.sistemaalmacen.daou.ProductoDAO;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.service.ProductoService;

/**
 * En esta clase se implementa la logica de negocio (validaciones) para cada funcion
 */
public class ProductoServiceImpl implements ProductoService{

    ProductoDAO productoDAO = new ProductoDAOImpl();
            
    @Override
    public ListaDoble<Producto> consultarProductosPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto consultarProductoPorCodigo(int cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrar(Producto e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Producto e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaDoble<Producto> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public ListaDoble<Producto> buscarConCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



   
    
}
