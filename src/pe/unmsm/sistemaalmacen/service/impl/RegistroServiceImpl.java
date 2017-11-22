/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.unmsm.sistemaalmacen.dao.RegistroDAO;
import pe.unmsm.sistemaalmacen.dao.impl.RegistroDAOImpl;
import pe.unmsm.sistemaalmacen.dominio.Registro;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.service.RegistroService;

/**
 *
 * @author Miguel
 */
public class RegistroServiceImpl implements RegistroService{

    RegistroDAO registroDao = new RegistroDAOImpl();
    
    @Override
    public boolean registrar(Registro e) {
        registroDao.registrar(e);
        return true;
    }

    @Override
    public boolean modificar(Registro e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Registro get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaDoble<Registro> getAll() {
        
        
        return  new RegistroDAOImpl().getAll();
    }

    @Override
    public boolean eliminar(String id) {
        
        //eliminando los detalles de registro
        
        new DetalleRegistroServiceImpl().eliminar(id);
        
        registroDao.eliminar(id);
        return true;
    }
    
}
