/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackagedao;

import pe.unmsm.sistemaalmacen.dao.impl.CategoriaDAOImpl;
import pe.unmsm.sistemaalmacen.dao.impl.ProductoDAOImpl;
import pe.unmsm.sistemaalmacen.dao.impl.UsuarioDAOImpl;
import pe.unmsm.sistemaalmacen.dominio.Categoria;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.dominio.Usuario;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;

/**
 *
 * @author Josecarlos
 */
public class IntroducirDatosEnBD {
    static void introducirUsuarios(){
        Usuario usuario1 = new Usuario("admin", "admin", true);
        Usuario usuario2 = new Usuario("empleado01", "000", false);
        
        UsuarioDAOImpl dao = new UsuarioDAOImpl();
        dao.registrar(usuario1);
        dao.registrar(usuario2);
    }
    
    static void introducirProductos(){
        ListaDoble<Producto> miLista = new ListaDoble();
        miLista.insertarAlInicio(new Producto(1,"Televisor LG 55º","LG","HG002",
                "Unidades","ESTAND 01",1,0,730));
        miLista.insertarAlInicio(new Producto(2,"Lavadora","LG","LV002",
                "Unidades","ESTAND 02",1,5,650));
         miLista.insertarAlInicio(new Producto(3,"Laptop","Razer","RZ002",
                "Unidades","ESTAND 01",1,0,3000));
        miLista.insertarAlInicio(new Producto(4,"Iphone 8","Apple","SC0001",
                "Unidades","ESTAND 03",1,5,3600));
        miLista.insertarAlInicio(new Producto(5,"Comida para perros","Ricocan","N/A",
                "Kg","ESTAND 01",3,5.5f,4.5f));
        miLista.insertarAlInicio(new Producto(6,"Cereal","Angel","N/A",
                "Bolsas de 50g c/u","ESTAND 02",5,25,4));
         miLista.insertarAlInicio(new Producto(7,"Televisor Samsung 30º","Samsung","KI000",
                "Unidades","ESTAND 01",1,0,3000));
        miLista.insertarAlInicio(new Producto(8,"Celular","Sony","SG001",
                "Unidades","ESTAND 03",5,25,200));
        
        ProductoDAOImpl dao = new ProductoDAOImpl();
        miLista.paraCada(dao::registrar);
    }
    
    static void introducirCategorias(){
        Categoria cat1 = new Categoria(0,"Esta es una categoria por defecto");
        Categoria cat2 = new Categoria(1, "Esta es otra categoria");
        
        CategoriaDAOImpl dao = new CategoriaDAOImpl();
        dao.registrar(cat1);
        dao.registrar(cat2);
    }
    
    public static void main(String[] args) {
        introducirUsuarios();
        introducirCategorias();
        introducirProductos();
    }
}
