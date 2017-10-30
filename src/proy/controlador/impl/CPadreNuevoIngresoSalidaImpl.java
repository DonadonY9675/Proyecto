/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador.impl;

import estructuras.ListaDoble;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import proy.vista.VPadreNuevoIngresoSalida;
import proy.controlador.CModeloNuevoIngresoSalida;
import proy.dao.impl.ProductoDAOImpl;
import proy.dominio.Producto;
import proy.vista.VentanaNuevaSalida;
import proy.vista.VentanaProductos;

/**
 *
 */
public abstract class CPadreNuevoIngresoSalidaImpl extends CoordinadorDeCoordinadores implements CModeloNuevoIngresoSalida {

    VPadreNuevoIngresoSalida vIngSal;

    ListaDoble<Producto> listaProductosTabla = new ListaDoble<>();

    public void setMiModeloNuevoIngresoSalida(VPadreNuevoIngresoSalida miModeloIngSal) {
        vIngSal = miModeloIngSal; // vIngSal se encuentra el el padre

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

        if (vIngSal instanceof VentanaNuevaSalida) {
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
        coordinadorProdutos.setvIngSal(vIngSal);
        miVentanaProducto.setLocationRelativeTo(null);
        miVentanaProducto.setVisible(true);

    }

    @Override
    public void clickBtnEliminar(ActionEvent evt) {

        int seleccion = vIngSal.jTable.getSelectedRow();
        if (seleccion != -1) {
            vIngSal.miListaProductos.eliminar(seleccion);
            vIngSal.actualizarDatos();
        }

    }

    @Override
    public void clickBtnIncluirImpuesto(ActionEvent evt) {
        vIngSal.calcularTotalyLlenar();
        if (vIngSal.btnIncluirImpuesto.isSelected()) {
            vIngSal.btnIncluirImpuesto.setText("Excluir impuestos");
        } else {
            vIngSal.btnIncluirImpuesto.setText("Incluir impuestos");
        }
    }

    @Override
    public abstract void clickBtnGuardar(ActionEvent evt);

    @Override
    public void clickBtnCancelar(ActionEvent evt) {

        int opc = JOptionPane.showConfirmDialog(vIngSal,
                "Desea salir sin guardar los cambios", "Cancelar Registro",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opc == 0) {
            vIngSal.dispose();
        }
    }

}
