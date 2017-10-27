/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.dao;

import estructuras.ListaDoble;

/**
 * E: tipo de dato Producto,Categoria
 * K: tipo de dato de valor buscados
 */
public interface AbstractDAO<E, K> {
    final String URL_BASEDEDATOS = "jdbc:mysql://localhost:3306/almacen";
    final String USUARIO = "root";
    final String PASSWORD = "root";
    
    boolean registrar(E e);
    boolean modificar(E e);
    E get(K id);
    ListaDoble<E> getAll();
    boolean eliminar(K id);

}
