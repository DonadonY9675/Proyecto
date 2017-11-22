/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.service.impl;

import pe.unmsm.sistemaalmacen.dao.impl.DetalleRegistroDAOImpl;
import pe.unmsm.sistemaalmacen.dominio.DetalleRegistro;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.service.DetalleRegistroService;

/**
 *
 * @author Miguel
 */
public class DetalleRegistroServiceImpl implements DetalleRegistroService{

    
    DetalleRegistroDAOImpl dao = new DetalleRegistroDAOImpl();
    
    @Override
    public boolean registrar(DetalleRegistro e) {
        dao.registrar(e);
        return true;
    }

    @Override
    public boolean modificar(DetalleRegistro e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleRegistro get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaDoble<DetalleRegistro> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(String id) {
        dao.eliminar(id);
        return true;
    }
    
}
