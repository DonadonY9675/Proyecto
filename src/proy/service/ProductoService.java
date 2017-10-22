/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.service;

import estructuras.ListaDoble;
import java.util.List;
import proy.dominio.Producto;

/**
 *
 * @author Miguel
 */
public interface ProductoService extends MantenimientoService<Producto, Integer>{
    //aqui van los prototipoa de los metodos de ProductoServiceImpl
    public ListaDoble<Producto> consultarProductosPorNombre(String nombre);
    public Producto consultarProductoPorCodigo(int cod);
         ListaDoble<Producto> buscarConCategoria();

}
