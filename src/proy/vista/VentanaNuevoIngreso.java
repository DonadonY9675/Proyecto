/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.vista;

import estructuras.ListaDoble;
import java.awt.Frame;
import proy.dominio.Producto;

/**
 *
 * @author Miguel
 */
public class VentanaNuevoIngreso extends VPadreNuevoIngresoSalida {
public ListaDoble<Producto> miListaProductos;
    public VentanaNuevoIngreso(Frame parent, boolean modal) {
        super(parent, modal);
        lblTitulo.setText("Nuevo Ingreso");
        lblProveedor.setText("Proveedor");
    }

}
