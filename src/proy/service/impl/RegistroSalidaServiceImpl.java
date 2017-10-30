/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.service.impl;

import estructuras.ListaDoble;
import proy.dao.impl.RegistroSalidaDAOImpl;
import proy.dominio.Registro;
import proy.dominio.RegistroSalida;
import proy.service.RegistroSalidaService;

/**
 *
 * @author Miguel
 */
public class RegistroSalidaServiceImpl implements RegistroSalidaService{

    RegistroSalidaDAOImpl registroSalidaDAO = new RegistroSalidaDAOImpl();
            
    @Override
    public boolean registrar(Registro e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Registro e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Registro get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaDoble<Registro> getAll() {
        /**
         * validaciones
         * 
         */
        return registroSalidaDAO.getAll();
    }

    @Override
    public boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
