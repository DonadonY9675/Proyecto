/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.dominio;

import estructuras.ListaDoble;
import java.util.Date;

/**
 *
 * @author Miguel
 */
public abstract class Registro {

    private int folio;
    private Date fecha;
    private String ususario;

    private ListaDoble<EntradaSalida> listaProductos;
    private String observaciones;

    private float subTotal;// Sub total es el monto sin considerar impuestos
    private float impuestos;
    private float total;

    public Registro(int folio, Date fecha, String ususario, ListaDoble<EntradaSalida> listaProductos, String observaciones, float subTotal, float impuestos, float total) {
        this.folio = folio;
        this.fecha = fecha;
        this.ususario = ususario;
        this.listaProductos = listaProductos;
        this.observaciones = observaciones;
        this.subTotal = subTotal;
        this.impuestos = impuestos;
        this.total = total;
    }

    

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsusario() {
        return ususario;
    }

    public void setUsusario(String ususario) {
        this.ususario = ususario;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public ListaDoble<EntradaSalida> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ListaDoble<EntradaSalida> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public float getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(float impuestos) {
        this.impuestos = impuestos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
