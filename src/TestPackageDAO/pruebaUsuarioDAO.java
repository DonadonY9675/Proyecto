/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackageDAO;

import estructuras.ListaDoble;
import proy.dao.UsuarioDao;
import proy.dao.impl.UsuarioDAOImpl;
import proy.dominio.Usuario;

/**
 *
 * @author Josecarlos miu
 */
public class pruebaUsuarioDAO {
    public static void main(String[] args) {
//        Usuario us = new Usuario("us003", "022", true);
        UsuarioDao dao = new UsuarioDAOImpl();
//        
//        dao.registrar(us);
//        dao.eliminar("segundoUs03");
//        Usuario p = dao.get("admin01");
        
        ListaDoble<Usuario> lista = dao.getAll();
        System.out.println(lista);
    }
    
}
