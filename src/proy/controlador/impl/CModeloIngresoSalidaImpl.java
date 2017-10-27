/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador.impl;

import estructuras.ListaDoble;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import proy.vista.VPadreNuevoIngresoSalida;
import proy.controlador.CModeloNuevoIngresoSalida;
import proy.dao.impl.ProductoDAOImpl;
import proy.dominio.Producto;
import proy.vista.VentanaNuevaSalida;
import proy.vista.VentanaProductos;

/**
 *
 */
public abstract class CModeloIngresoSalidaImpl extends CoordinadorDeCoordinadores implements CModeloNuevoIngresoSalida {

    VPadreNuevoIngresoSalida miVentanaIngSal;

    ListaDoble<Producto> listaProductosTabla = new ListaDoble<>();

    public void setMiModeloNuevoIngresoSalida(VPadreNuevoIngresoSalida miModeloIngSal) {
        miVentanaIngSal = miModeloIngSal; // miVentanaIngSal se encuentra el el padre

        miModeloIngSal.btnProductos.addActionListener(this::clickBtnProductos);
        miModeloIngSal.btnEliminar.addActionListener(this::clickBtnEliminar);

        miModeloIngSal.btnIncluirImpuesto.addActionListener(this::clickBtnIncluirImpuesto);
        miModeloIngSal.btnGuardar.addActionListener(this::clickBtnGuardar);
        miModeloIngSal.btnCancelar.addActionListener(this::clickBtnCancelar);
    }

    @Override
    public void clickBtnProductos(ActionEvent evt) {
        ListaDoble<Producto> listaProductos = (new ProductoDAOImpl()).getAll();
        VentanaProductos miVentanaProducto;

        if (miVentanaIngSal instanceof VentanaNuevaSalida) {
            int cont = 0;
            for (Producto p : listaProductos) {
                if (p.getExistencia() == 0) {
                    listaProductos.eliminar(cont);
                } else {
                    cont++;
                }
            }
        }

        miVentanaProducto = new VentanaProductos(null, true, listaProductos);

        CProductoImpl coordinadorProdutos = new CProductoImpl(miVentanaProducto);
        coordinadorProdutos.setvIngSal(miVentanaIngSal);
        miVentanaProducto.setLocationRelativeTo(null);
        miVentanaProducto.setVisible(true);

    }

    @Override
    public void clickBtnEliminar(ActionEvent evt) {
        System.out.println("clickBtnEliminar");
    }

    @Override
    public void clickBtnIncluirImpuesto(ActionEvent evt) {
        System.out.println("clickBtnIncluirImpuesto");
    }

    @Override
    public abstract void clickBtnGuardar(ActionEvent evt);

    @Override
    public void clickBtnCancelar(ActionEvent evt) {
        miVentanaIngSal.dispose();
    }

    public void llenarTabla(ListaDoble<Producto> listaProductos) {

        String Titulo[] = {"Titulo1", "Titulo2"};
        String registro[] = new String[2];
        DefaultTableModel modelo = new DefaultTableModel(null, Titulo);

        for (Producto p : listaProductos) {
            registro[0] = p.getNombre();
            registro[1] = p.getModelo();
            modelo.addRow(registro);
        }
//        nombreTabla.setModel(modelo);
//        miVentanaIngSal.jTable.setModel(dataModel);
    }

}
