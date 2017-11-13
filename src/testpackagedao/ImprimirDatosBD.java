/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackagedao;

import pe.unmsm.sistemaalmacen.dao.impl.CategoriaDAOImpl;
import pe.unmsm.sistemaalmacen.dao.impl.ProductoDAOImpl;
import pe.unmsm.sistemaalmacen.dao.impl.RegistroEntradaDAOImpl;
import pe.unmsm.sistemaalmacen.dao.impl.UsuarioDAOImpl;
import pe.unmsm.sistemaalmacen.dominio.Categoria;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.dominio.Registro;
import pe.unmsm.sistemaalmacen.dominio.Usuario;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;

/**
 *
 * @author Josecarlos
 */
public class ImprimirDatosBD {
    static void imprimirUsuarios(){
        ListaDoble<Usuario> miLista = null;
        
        UsuarioDAOImpl dao = new UsuarioDAOImpl();
        miLista = dao.getAll();
        
        System.out.println("LISTA DE USUARIOS");
        miLista.stream().forEach(System.out::println);
    }
    
    static void imprimirProductos(){
        ListaDoble<Producto> miLista = null;
        
        ProductoDAOImpl dao = new ProductoDAOImpl();
        miLista = dao.getAll();
        
        System.out.println("LISTA DE PRODUCTOS");
        miLista.stream().forEach(System.out::println);
    }
    
    static void imprimirCategorias(){
        ListaDoble<Categoria> miLista = null;
        
        CategoriaDAOImpl dao = new CategoriaDAOImpl();
        miLista = dao.getAll();
        
        System.out.println("LISTA DE CATEGORIAS");
        miLista.stream().forEach(System.out::println);
    }
    
    static void imprimirRegistrosDeEntrada(){
        ListaDoble<Registro> miLista = null;
        
        RegistroEntradaDAOImpl dao = new RegistroEntradaDAOImpl();
        miLista = dao.getAll();
        
        System.out.println("LISTA DE REGISTROS: "+miLista.stream().count());
        
        
        miLista.stream().forEach((r)->{System.out.println("\nFolio: "+r.getFolio()+" - "+r.getUsusario()
                +" - "+r.getFecha()); System.out.println("Lista de detalles entrada: "+r.getListaEntradaSalida().stream().count()); 
                r.getListaEntradaSalida().stream().forEach(System.out::println);});
    }
    
    public static void main(String[] args) {
        imprimirUsuarios();
        imprimirCategorias();
        imprimirProductos();
        imprimirRegistrosDeEntrada();
    }
}
