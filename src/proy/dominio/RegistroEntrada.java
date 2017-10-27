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
public class RegistroEntrada {

    private int Folio;
    private Date Fecha;
    private String Ususario;
    private String Proveedor;
    // Sub total es el monto sin considerar impuestos
    private String SubTotal;
    private ListaDoble<EntradaSalida> listaProductos;
    private Float Impuestos;
    private Float Total;

    public RegistroEntrada(int Folio, Date Fecha, String Ususario, String Proveedor, String SubTotal, ListaDoble<EntradaSalida> listaProductos, Float Impuestos, Float Total) {
        this.Folio = Folio;
        this.Fecha = Fecha;
        this.Ususario = Ususario;
        this.Proveedor = Proveedor;
        this.SubTotal = SubTotal;
        this.listaProductos = listaProductos;
        this.Impuestos = Impuestos;
        this.Total = Total;
    }

    public int getFolio() {
        return Folio;
    }

    public void setFolio(int Folio) {
        this.Folio = Folio;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getUsusario() {
        return Ususario;
    }

    public void setUsusario(String Ususario) {
        this.Ususario = Ususario;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(String SubTotal) {
        this.SubTotal = SubTotal;
    }

    public ListaDoble<EntradaSalida> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ListaDoble<EntradaSalida> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Float getImpuestos() {
        return Impuestos;
    }

    public void setImpuestos(Float Impuestos) {
        this.Impuestos = Impuestos;
    }

    public Float getTotal() {
        return Total;
    }

    public void setTotal(Float Total) {
        this.Total = Total;
    }

    

    

}
