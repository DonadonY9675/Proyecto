/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackagedao;

import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.dao.impl.UsuarioDAOImpl;
import pe.unmsm.sistemaalmacen.dominio.Usuario;
import pe.unmsm.sistemaalmacen.daou.UsuarioDAO;

/**
 *
 * @author Josecarlos miu
 */
public class pruebaUsuarioDAO {
    public static void main(String[] args) {
        
        UsuarioDAO dao = new UsuarioDAOImpl();
        Usuario us = new Usuario("us003", "022", true);
        
//        dao.registrar(us);
        us.setNombre("gustavo");
        dao.modificar(us);
//        Usuario p = dao.get("admin01");
        
        ListaDoble<Usuario> lista = dao.getAll();
        System.out.println(lista);
    }
    
}
