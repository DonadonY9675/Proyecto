/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.service.impl;


import pe.unmsm.sistemaalmacen.dao.impl.ProductoDAOImpl;
import pe.unmsm.sistemaalmacen.dao.ProductoDAO;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.service.ProductoService;

/**
 * En esta clase se implementa la logica de negocio (validaciones) para cada funcion
 */
public class ProductoServiceImpl implements ProductoService{

    ProductoDAO productoDAO = new ProductoDAOImpl();
    
    public boolean registrar(Producto e) {
        return productoDAO.registrar(e);
    }

    @Override
    public boolean modificar(Producto e) {
        return productoDAO.modificar(e);
    }

    @Override
    public Producto get(Integer id) {
        return productoDAO.get(id);
    }

    @Override
    public ListaDoble<Producto> getAll() {
        return productoDAO.getAll();
    }

    @Override
    public boolean eliminar(Integer id) {
        return productoDAO.eliminar(id);
    }
    
}
