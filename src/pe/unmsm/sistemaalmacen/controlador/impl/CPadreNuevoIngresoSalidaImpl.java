/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import pe.unmsm.sistemaalmacen.vista.VPadreNuevoIngresoSalida;
import pe.unmsm.sistemaalmacen.controlador.CModeloNuevoIngresoSalida;
import pe.unmsm.sistemaalmacen.dao.impl.ProductoDAOImpl;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.vista.VentanaNuevaSalida;
import pe.unmsm.sistemaalmacen.vista.VentanaProductos;

/**
 *
 */
public abstract class CPadreNuevoIngresoSalidaImpl implements CModeloNuevoIngresoSalida {

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
        
        if(vIngSal.miListaProductos.size()==0){
            vIngSal.btnGuardar.setEnabled(false);
            vIngSal.btnEliminar.setEnabled(false);
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

    
    public abstract void clickBtnGuardar(ActionEvent evt);

    @Override
    public void clickBtnCancelar(ActionEvent evt) {

        if (vIngSal.estaGuardado || vIngSal.miListaProductos.size() == 0) {
            vIngSal.dispose();
        } else {
            int opc = JOptionPane.showConfirmDialog(vIngSal,
                    "Desea salir sin guardar los cambios", "Cancelar Registro",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (opc == 0) {
                vIngSal.dispose();
            }
        }

    }

}
