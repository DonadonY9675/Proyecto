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

import pe.unmsm.sistemaalmacen.dao.impl.UsuarioDAOImpl;
import pe.unmsm.sistemaalmacen.dao.RegistroDAO;
import pe.unmsm.sistemaalmacen.dao.impl.DetalleRegistroDAOImpl;
import pe.unmsm.sistemaalmacen.dominio.Categoria;
import pe.unmsm.sistemaalmacen.dominio.DetalleRegistro;
import pe.unmsm.sistemaalmacen.dominio.EntradaSalida;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.dominio.Registro;
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
        Categoria cat3 = new Categoria(3,"");
        Categoria cat4 = new Categoria(4, "");
        Categoria cat5 = new Categoria(5,"");
        
        miLista.insertarAlInicio(new Producto(1,"Televisor LG 55º","LG","HG002",
                cat3,"Unidades","ESTAND 01",1,0,730));
        miLista.insertarAlInicio(new Producto(2,"Lavadora","LG","LV002",
                cat4,"Unidades","ESTAND 02",1,5,650));
         miLista.insertarAlInicio(new Producto(3,"Laptop","Razer","RZ002",
                cat3,"Unidades","ESTAND 01",1,0,3000));
        miLista.insertarAlInicio(new Producto(4,"Iphone 8","Apple","SC0001",
                cat3,"Unidades","ESTAND 03",1,5,3600));
        miLista.insertarAlInicio(new Producto(5,"Comida para perros","Ricocan","N/A",
                cat5,"Kg","ESTAND 01",3,5.5f,4.5f));
        miLista.insertarAlInicio(new Producto(6,"Cereal","Angel","N/A",
                cat2,"Bolsas de 50g c/u","ESTAND 02",5,25,4));
         miLista.insertarAlInicio(new Producto(7,"TV Samsung 30º","Samsung","KI000",
                cat3,"Unidades","ESTAND 01",1,0,3000));
        miLista.insertarAlInicio(new Producto(8,"Celular","Sony","SG001",
                cat3,"Unidades","ESTAND 03",5,25,200));
        miLista.insertarAlInicio(new Producto(9,"Arroz","Tarmenito","N/A",
                cat5,"Bolsas de 10kg c/u","ESTAND 05",10,55,6));
         miLista.insertarAlInicio(new Producto(10,"Leche","Gloria","N/A",
                cat5,"Tarro 300mL","ESTAND 05",20,35,3));
        miLista.insertarAlInicio(new Producto(11,"Impresora","Canon","SS02",
                cat3,"Unidades","ESTAND 02",5,25,200));
        miLista.insertarAlInicio(new Producto(12,"Detergente","Spolio","N/A",
                cat3,"Bolsas 30gr","ESTAND 06",5,25,5));
        
        
        ProductoDAOImpl dao = new ProductoDAOImpl();
        miLista.stream().forEach(dao::registrar);
    }
    
    static void introducirCategorias(){
        CategoriaDAOImpl dao = new CategoriaDAOImpl();
        ListaDoble<Categoria> listaCategorias = new ListaDoble<>();
        listaCategorias.insertarAlFinal(new Categoria(1, "Productos del hogar"));
        listaCategorias.insertarAlFinal(new Categoria(2, "Limpieza"));
        listaCategorias.insertarAlFinal(new Categoria(3, "Tecnologia"));
        listaCategorias.insertarAlFinal(new Categoria(4, "Electrodomesticos"));
        listaCategorias.insertarAlFinal(new Categoria(5, "Abarrotes"));
        listaCategorias.stream().forEach(dao::registrar);
    }
    
    static void introducirDetalleRegistros(){
        
        DetalleRegistroDAOImpl dao = new DetalleRegistroDAOImpl();
        
        ListaDoble<DetalleRegistro> listaDetalleRegistro = new ListaDoble<>();
        
        listaDetalleRegistro.insertarAlFinal(new DetalleRegistro("RE0001",new Producto(1),32.0,2));
        listaDetalleRegistro.insertarAlFinal(new DetalleRegistro("RE0001",new Producto(2),132.0,3));
        
        listaDetalleRegistro.insertarAlFinal(new DetalleRegistro("RS0001",new Producto(4),31.0,4));
        listaDetalleRegistro.insertarAlFinal(new DetalleRegistro("RS0001",new Producto(5),54.0,1));
        listaDetalleRegistro.insertarAlFinal(new DetalleRegistro("RS0001",new Producto(1),515.0,2));
        listaDetalleRegistro.insertarAlFinal(new DetalleRegistro("RS0001",new Producto(2),512.0,4));
        listaDetalleRegistro.insertarAlFinal(new DetalleRegistro("RE0002",new Producto(4),2323.0,4));
        listaDetalleRegistro.insertarAlFinal(new DetalleRegistro("RE0002",new Producto(3),53.0,2));
        listaDetalleRegistro.insertarAlFinal(new DetalleRegistro("RE0002",new Producto(6),2345.0,4));
        listaDetalleRegistro.insertarAlFinal(new DetalleRegistro("RE0003",new Producto(1),23.0,2));
        listaDetalleRegistro.insertarAlFinal(new DetalleRegistro("RE0003",new Producto(2),2543.0,1));
        
        listaDetalleRegistro.stream().forEach(dao::registrar);

    }
    
    static void introducirRegistros(){
        
        RegistroDAOImpl dao = new RegistroDAOImpl();
        ListaDoble<Registro> listaRegistros = new ListaDoble<>();
        listaRegistros.insertarAlFinal(new Registro("RE0001", new Date(1,2,3), "admin", "ProveedorPrueba1", null, "Observacion 1", 1234f, 12312.0f,123123.0f));
                                                
        listaRegistros.insertarAlFinal(new Registro("RS0001", new Date(4,5,6), "admin", "ProveedorPrueba2", null, "Observacion 2", 132, 323.0f,123123.0f));
        listaRegistros.insertarAlFinal(new Registro("RE0002", new Date(7,8,9), "admin", "ProveedorPrueba1", null, "Observacion 3", 123, 2313.0f,3123132.0f));
        listaRegistros.insertarAlFinal(new Registro("RE0003", new Date(10,11,12), "admin", "ProveedorPrueba3", null, "Observacion 4", 132, 321.0f,132123.0f));
        
        listaRegistros.stream().forEach(dao::registrar);
    }
        
    
    public static void main(String[] args) {
        
        introducirUsuarios();
        introducirCategorias();
        introducirProductos();
        introducirRegistros();
        introducirDetalleRegistros();

    }
}
