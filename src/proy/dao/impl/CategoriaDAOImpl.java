/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.dao.impl;

import proy.dominio.Categoria;
import estructuras.ListaDoble;
import proy.dao.CategoriaDAO;

/**
 *
 * @author Miguel
 */
public class CategoriaDAOImpl implements CategoriaDAO{

    //implmeentacion, solo consultas registros en la Base de datos, 
    //aqui NO SE HACEN VALIDACIONES
    
    @Override
    public boolean registrar(Categoria e) {
        return true;
    }

    @Override
    public boolean modificar(Categoria e) {
        return true;
    }

    @Override
    public Categoria get(Integer id) {
        return null;
    }

    @Override
    public ListaDoble<Categoria> getAll() {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) {
        return true;
    }

 
    
}
