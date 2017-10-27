/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackageDAO;

import estructuras.ListaDoble;
import proy.dao.impl.CategoriaDAOImpl;
import proy.dominio.Categoria;

/**
 *
 * @author Josecarlos
 */
public class pruebaCategoriaDAO {
    public static void main(String[] args) {
        Categoria cat1 = new Categoria(0,"Esta es una categoria por defecto");
        Categoria cat2 = new Categoria(2, "Esta es otra categoria");
        
        CategoriaDAOImpl dao = new CategoriaDAOImpl();
//        dao.registrar(cat1);
        dao.registrar(cat2);

        ListaDoble<Categoria> lista = dao.getAll();
        System.out.println(lista);
        
    }
}
