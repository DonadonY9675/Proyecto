/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.service.impl;

import pe.unmsm.sistemaalmacen.dao.impl.UsuarioDAOImpl;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.service.UsuarioService;
import pe.unmsm.sistemaalmacen.dao.UsuarioDAO;
import pe.unmsm.sistemaalmacen.dominio.Usuario;

/**
 *
 * @author Anthony
 */
public class UsuarioServiceImpl implements UsuarioService{
    
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    @Override
    public boolean registrar(Usuario e) {
        return usuarioDAO.registrar(e);
    }

    @Override
    public boolean modificar(Usuario e) {
        return usuarioDAO.modificar(e);
    }

    @Override
    public Usuario get(String id) {
        return usuarioDAO.get(id);
    }

    @Override
    public ListaDoble<Usuario> getAll() {
        return usuarioDAO.getAll();
    }

    @Override
    public boolean eliminar(String id) {
        return usuarioDAO.eliminar(id);
    }
    
}
