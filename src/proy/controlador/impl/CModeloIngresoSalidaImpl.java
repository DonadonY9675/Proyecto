/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador.impl;

import estructuras.ListaDoble;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import proy.vista.ModeloNuevoIngresoSalida;
import proy.controlador.CModeloNuevoIngresoSalida;
import proy.dao.impl.ProductoDAOImpl;
import proy.dominio.Producto;
import proy.vista.VentanaNuevaSalida;
import proy.vista.VentanaNuevoIngreso;
import proy.vista.VentanaProductos;

/**
 *
 */
public abstract class CModeloIngresoSalidaImpl implements CModeloNuevoIngresoSalida {

    ModeloNuevoIngresoSalida miModeloIngSal;

    public void setMiModeloNuevoIngresoSalida(ModeloNuevoIngresoSalida miModeloIngSal) {
        this.miModeloIngSal = miModeloIngSal;

        miModeloIngSal.btnProductos.addActionListener(this::clickBtnProductos);
        miModeloIngSal.btnEliminar.addActionListener(this::clickBtnEliminar);

        miModeloIngSal.btnIncluirImpuesto.addActionListener(this::clickBtnIncluirImpuesto);
        miModeloIngSal.btnGuardar.addActionListener(this::clickBtnGuardar);
        miModeloIngSal.btnCancelar.addActionListener(this::clickBtnCancelar);
    }

    @Override
    public void clickBtnProductos(ActionEvent evt) {
        VentanaProductos ventanaProductos;
        ListaDoble<Producto> listaProductos = (new ProductoDAOImpl()).getAll();

        if (miModeloIngSal instanceof VentanaNuevaSalida) {
            int cont = 0;
            for (Producto p : listaProductos) {
                if (p.getExistencia() == 0) {
                    listaProductos.eliminar(cont);
                } else {
                    cont++;
                }
            }
        }

        ventanaProductos = new VentanaProductos(null, true, listaProductos);
        CProductoImpl coordinadorProdutos = new CProductoImpl(ventanaProductos);
        ventanaProductos.setLocationRelativeTo(null);
        ventanaProductos.setVisible(true);

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
        miModeloIngSal.dispose();
    }

}
