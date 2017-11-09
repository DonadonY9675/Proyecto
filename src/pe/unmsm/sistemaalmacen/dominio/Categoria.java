/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.dominio;

import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;

/**
 *
 * @author Miguel
 */
public class Categoria {
    private int codigo;
    private String descripcion;
    
    public Categoria(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
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

    public String toString(){
        return "Codigo: "+codigo+" Descripcion: "+descripcion;
    }
}
