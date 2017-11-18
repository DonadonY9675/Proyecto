/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.service.impl;

import pe.unmsm.sistemaalmacen.dao.CategoriaDAO;
import pe.unmsm.sistemaalmacen.dao.impl.CategoriaDAOImpl;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.dominio.Categoria;
import pe.unmsm.sistemaalmacen.service.CategoriaService;

/**
 * En esta clase se implementa la logica de negocio (validaciones) para cada funcion
 */
public class CategoriaServiceImpl implements CategoriaService{

    CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
    
    @Override
    public boolean registrar(Categoria e) {
        return categoriaDAO.registrar(e);
    }

    @Override
    public boolean modificar(Categoria e) {
        return categoriaDAO.modificar(e);
    }

    @Override
    public Categoria get(Integer id) {
        return categoriaDAO.get(id);
    }

    @Override
    public ListaDoble<Categoria> getAll() {
        return categoriaDAO.getAll();
    }

    @Override
    public boolean eliminar(Integer id) {
        return categoriaDAO.eliminar(id);
    }
    
}
