/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackagedao;

import java.sql.Date;
import pe.unmsm.sistemaalmacen.dao.impl.CategoriaDAOImpl;
import pe.unmsm.sistemaalmacen.dao.impl.ProductoDAOImpl;
import pe.unmsm.sistemaalmacen.dao.impl.RegistroDAOImpl;
import pe.unmsm.sistemaalmacen.dao.impl.RegistroEntradaDAOImpl;
import pe.unmsm.sistemaalmacen.dao.impl.UsuarioDAOImpl;
import pe.unmsm.sistemaalmacen.daou.RegistroDAO;
import pe.unmsm.sistemaalmacen.dominio.Categoria;
import pe.unmsm.sistemaalmacen.dominio.EntradaSalida;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.dominio.Registro;
import pe.unmsm.sistemaalmacen.dominio.RegistroEntrada;
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
        
        //AQUI SOLO QUIERO LOS CODIGOS DE CATEGORIA
        Categoria cat1 = new Categoria(1,"");
        Categoria cat2 = new Categoria(2, "");
        
        miLista.insertarAlInicio(new Producto(1,"Televisor LG 55º","LG","HG002",
                cat1,"Unidades","ESTAND 01",1,0,730));
        miLista.insertarAlInicio(new Producto(2,"Lavadora","LG","LV002",
                cat1,"Unidades","ESTAND 02",1,5,650));
         miLista.insertarAlInicio(new Producto(3,"Laptop","Razer","RZ002",
                cat2,"Unidades","ESTAND 01",1,0,3000));
        miLista.insertarAlInicio(new Producto(4,"Iphone 8","Apple","SC0001",
                cat1,"Unidades","ESTAND 03",1,5,3600));
        miLista.insertarAlInicio(new Producto(5,"Comida para perros","Ricocan","N/A",
                cat1,"Kg","ESTAND 01",3,5.5f,4.5f));
        miLista.insertarAlInicio(new Producto(6,"Cereal","Angel","N/A",
                cat2,"Bolsas de 50g c/u","ESTAND 02",5,25,4));
         miLista.insertarAlInicio(new Producto(7,"TV Samsung 30º","Samsung","KI000",
                cat1,"Unidades","ESTAND 01",1,0,3000));
        miLista.insertarAlInicio(new Producto(8,"Celular","Sony","SG001",
                cat2,"Unidades","ESTAND 03",5,25,200));
        miLista.insertarAlInicio(new Producto(9,"Arroz","Tarmenito","N/A",
                cat1,"Bolsas de 10kg c/u","ESTAND 05",10,55,6));
         miLista.insertarAlInicio(new Producto(10,"Leche","Gloria","N/A",
                cat1,"Tarro 300mL","ESTAND 05",20,35,3));
        miLista.insertarAlInicio(new Producto(11,"Impresora","Canon","SS02",
                cat1,"Unidades","ESTAND 02",5,25,200));
        
        
        ProductoDAOImpl dao = new ProductoDAOImpl();
        miLista.stream().forEach(dao::registrar);
    }
    
    static void introducirCategorias(){
        Categoria cat1 = new Categoria(1,"Esta es una categoria por defecto");
        Categoria cat2 = new Categoria(2, "Esta es otra categoria");
        
        CategoriaDAOImpl dao = new CategoriaDAOImpl();
        dao.registrar(cat1);
        dao.registrar(cat2);
    }
    
    static void introducirRegistrosEntrada(){
        RegistroDAO dao = new RegistroEntradaDAOImpl();
        
        ListaDoble<Registro> listaRegistroEntrada = new ListaDoble();
        ListaDoble<EntradaSalida> listaIngreso1 = new ListaDoble();
        
        ListaDoble<EntradaSalida> listaIngreso2 = new ListaDoble();
        ListaDoble<Producto> miLista = new ListaDoble();
        
        ListaDoble<EntradaSalida> listaIngreso3 = new ListaDoble();
        
        ListaDoble<EntradaSalida> listaIngreso4 = new ListaDoble();
        
        //AQUI SOLO IMPORTAN LOS CODIGOS DE LOS PRODUCTOS
        Producto prod1 = new Producto(1, "", "", "",
                "", "", 0, 0, 0);
        Producto prod2 = new Producto(2, "", "", "",
                "", "", 0, 0, 00);
        Producto prod3 = new Producto(3, "", "", "",
                "", "", 1, 0, 3000);
        Producto prod4 = new Producto(4, "", "", "",
                "", "", 1, 5, 3600);
        Producto prod5 = new Producto(5, "", "", "",
                "", "", 0, 0, 0);
        Producto prod6 = new Producto(6, "", "", "",
                "", "", 0, 0, 0);
        Producto prod7 = new Producto(7, "", "", "",
                "", "", 0, 0, 00);
        Producto prod8 = new Producto(8, "", "", "",
                "", "", 1, 0, 3000);
        Producto prod9 = new Producto(9, "", "", "",
                "", "", 1, 5, 3600);
        Producto prod510 = new Producto(10, "", "", "",
                "", "", 0, 0, 0);
        Producto prod511 = new Producto(11, "", "", "",
                "", "", 0, 0, 0);
                
        listaIngreso1.insertarAlFinal(new EntradaSalida(prod1, 32, 12331));
        listaIngreso1.insertarAlFinal(new EntradaSalida(prod2, 3, 3245));
        listaIngreso1.insertarAlFinal(new EntradaSalida(prod3, 32, 12231));
        listaIngreso1.insertarAlFinal(new EntradaSalida(prod4, 3, 3245));
        
        listaRegistroEntrada.insertarAlFinal(new RegistroEntrada(1, new Date(7,8,9), "admin", "Proveedor1",  listaIngreso1,"Observacion 1",1234f, 12312.0f,123123.0f));
        
        listaIngreso2.insertarAlFinal(new EntradaSalida(prod3, 2, 5477));
        listaIngreso2.insertarAlFinal(new EntradaSalida(prod4, 13, 1331));
        listaIngreso2.insertarAlFinal(new EntradaSalida(prod1, 23, 321));
        
        listaRegistroEntrada.insertarAlFinal(new RegistroEntrada(2, new Date(10,11,12), "empleado01", "Proveedor2",  listaIngreso2,"Observacion 2",21234f, 123.0f,3123.0f));

        listaIngreso3.insertarAlFinal(new EntradaSalida(prod5, 32, 12331));
        listaIngreso3.insertarAlFinal(new EntradaSalida(prod6, 3, 3245));
        listaIngreso3.insertarAlFinal(new EntradaSalida(prod2, 32, 12231));
        listaIngreso3.insertarAlFinal(new EntradaSalida(prod8, 34, 3245));
        
        listaRegistroEntrada.insertarAlFinal(new RegistroEntrada(3, new Date(10,11,12), "empleado01", "Proveedor2",  listaIngreso3,"Observacion 2",21234f, 123.0f,3123.0f));

        listaIngreso4.insertarAlFinal(new EntradaSalida(prod9, 32, 12331));
        listaIngreso4.insertarAlFinal(new EntradaSalida(prod2, 3, 3245));
        listaIngreso4.insertarAlFinal(new EntradaSalida(prod7, 32, 12231));
        listaIngreso4.insertarAlFinal(new EntradaSalida(prod1, 34, 3245));
        
        listaRegistroEntrada.insertarAlFinal(new RegistroEntrada(4, new Date(10,11,12), "empleado01", "Proveedor2",  listaIngreso4,"Observacion 2",21234f, 123.0f,3123.0f));

        listaRegistroEntrada.stream().forEach(dao::registrar);
    }
    
    public static void main(String[] args) {
        introducirUsuarios();
        introducirCategorias();
        introducirProductos();
        introducirRegistrosEntrada();
    }
}
