/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.dominio;

import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import java.sql.Date;

/**
 *
 * @author Miguel
 */
public class Registro {

    private String codigo;
    private Date fecha;
    private String ususario;
    private String agente;
    private ListaDoble<DetalleRegistro> listaDetalleRegistro;
    private String observaciones;

    private float subTotal;// Sub total es el monto sin considerar impuestos
    private float impuestos;
    private float total;

    public Registro(String codigo, Date fecha, String usuario, String agente, ListaDoble<DetalleRegistro> listaDetalleRegistro, String observaciones, float subTotal, float impuestos, float total) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.ususario = usuario;
        this.agente = agente;
        this.listaDetalleRegistro = listaDetalleRegistro;
        this.observaciones = observaciones;
        this.subTotal = subTotal;
        this.impuestos = impuestos;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String folio) {
        this.codigo = folio;
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

    public ListaDoble<DetalleRegistro> getDetalleRegistro() {
        return listaDetalleRegistro;
    }

    public void setDetalleRegistros(ListaDoble<DetalleRegistro> listaProductos) {
        this.listaDetalleRegistro = listaProductos;
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

    public String getAgente() {
        return agente;
    }

    public void setAgente(String cliente) {
        this.agente = cliente;
    }

    @Override
    public String toString() {
        return "Registro{" + "codigo=" + codigo + ", fecha=" + fecha + ", ususario=" + ususario + ", agente=" + agente + ", listaDetalleRegistro=" + listaDetalleRegistro + ", observaciones=" + observaciones + ", subTotal=" + subTotal + ", impuestos=" + impuestos + ", total=" + total + '}';
    }
    
    

}
