/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.dominio;

import estructuras.ListaDoble;

/**
 *
 * @author Miguel
 */
public class Categoria {
    private int codigo;
    private String descripcion;
    private ListaDoble listaProductos;

    public Categoria(int codigo, String descripcion, ListaDoble listaProductos) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.listaProductos = listaProductos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ListaDoble getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ListaDoble listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    
    
}
