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
        
        return null;
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
