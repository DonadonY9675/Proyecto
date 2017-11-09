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
public class RegistroSalida extends Registro {

    private String cliente;

    public RegistroSalida( int folio, Date fecha, String ususario,String cliente, ListaDoble<EntradaSalida> listaProductos, String observaciones, float subTotal, float impuestos, float total) {
        super(folio, fecha, ususario, listaProductos, observaciones, subTotal, impuestos, total);
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

}
