/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.service.impl;

import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.dao.impl.RegistroEntradaDAOImpl;
import pe.unmsm.sistemaalmacen.dominio.Registro;
import pe.unmsm.sistemaalmacen.dominio.RegistroEntrada;
import pe.unmsm.sistemaalmacen.service.RegistroEntradaService;

/**
 *
 * @author Miguel
 */
public class RegistroEntradaServiceImpl implements RegistroEntradaService{

    RegistroEntradaDAOImpl registroEntradaDAO  = new RegistroEntradaDAOImpl();
    
    @Override
    public boolean registrar(Registro e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        /**
         * validacion de todos los datos
         */
        return registroEntradaDAO.getAll();
    }

    @Override
    public boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
