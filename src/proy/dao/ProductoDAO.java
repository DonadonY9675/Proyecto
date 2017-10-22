/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.dao;

import estructuras.ListaDoble;
import proy.dominio.Producto;

/**
 *
 * @author Miguel
 */
public interface ProductoDAO extends AbstractDAO<Producto,Integer> {

   //aqui van los prototipoa de los metodos propios de productoDAO
    public ListaDoble<Producto> consultarProductosPorNombre(String nombre);
    public Producto consultarProductoPorCodigo(int cod);
    
    
}
