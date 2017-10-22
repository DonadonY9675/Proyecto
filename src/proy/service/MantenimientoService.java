/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.service;

import estructuras.ListaDoble;

/**
 *
 * @author Miguel
 */
public interface MantenimientoService<E,K> {
    boolean registrar(E e);
    boolean modificar(E e);
    E get(K id);
    ListaDoble<E> getAll();
    boolean eliminar(K id);
}
