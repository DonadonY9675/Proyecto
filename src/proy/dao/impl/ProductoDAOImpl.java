/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.dao.impl;

import proy.dominio.Producto;
import estructuras.ListaDoble;
import proy.dao.ProductoDAO;

/**
 * 
 */
public class ProductoDAOImpl implements ProductoDAO{
    
    // Nombre de la tabla y sus campos en la base de datos
    private final String nombreTabla="producto";
    private final String campoNombre="nombre";
    private final String campoMarca="marca";
    private final String campoModelo="modelo";
    private final String campoUniMed="unidadDeMedida";
    private final String campoUbic="ubicacion";
    private final String campoCantMin="cantidadMinima";
    private final String campoExsMin="existencias";
    private final String campoPrecUnit="precioUnitario";
    private final String campoCodCat="codigoCategoria";
    
    @Override
    public boolean registrar(Producto elem) {
        //Logica de registro en BD
        //INSERT
        return true;
    }

    @Override
    public ListaDoble<Producto> getAll() {
        //Logica para buscar todos
        //SELECT
        
        //prueba
        ListaDoble<Producto> miLista = new ListaDoble();
        miLista.insertarAlInicio(new Producto(1,"Televisor","LG","HG002",
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
         miLista.insertarAlInicio(new Producto(7,"Televisor","Samsung","KI000",
                "Unidades","ESTAND 01",1,0,3000));
        miLista.insertarAlInicio(new Producto(8,"Celular","Sony","SG001",
                "Unidades","ESTAND 03",5,25,200));
        
        
        return miLista;
        
    }

    @Override
    public Producto get(Integer ID) {
        //Logica de buscar por ID
        //SELECT
        //WHERE ID = ELEM
        return null;
    }

    @Override
    public boolean modificar(Producto elem) {
        //Logica de actualizacion en BD
        //UPDATE
        return true;

    }

    @Override
    public boolean eliminar(Integer elem) {
        //Logica de eliminacion en BD
        //DELETE
        return true;
    }



//    @Override
//    public List<Producto> buscarPorCategoria(Integer codigoCategoria) {
//        //Logica de buscar por NOMBRE
//        //SELECT
//        //WHERE codigoCategoria = codigoCategoria
//        List<Producto> lsProducto = new ArrayList<>();
//        return lsProducto;    
//    }
//    
//    @Override
//    public List<Producto> buscarConCategoria() {
//        //Logica de buscar por NOMBRE
//        //SELECT 
//        //JOIN p.codigoCategoria = c.codigoCategoria
//        List<Producto> lsProducto = new ArrayList<>();
//        return lsProducto;    
//    }
     
    /**
     * Realiza una consulta de productos por nombre
     * nombre: Nombre de producto a buscar en la base de datos
     * return: Lista de productos que contienen el nombre buscado
     */
    public ListaDoble<Producto> consultarProductosPorNombre(String nombre){
        //Logica de buscar por NOMBRE
        //SELECT
        //WHERE nombre = nombre
        
        return null;
    }
    
    /**
     * Realiza una buqueda de un producto por codigo en la base de datos,
     * devuelve solo el producto con dicho codigo (no existe duplicado de codigos)
     * @param cod: codigo a buscar
     * @return : Producto con codigo = cod
     */
    public Producto consultarProductoPorCodigo(int cod) {
        return null;
    }
    
}
