/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import pe.unmsm.sistemaalmacen.controlador.CNuevoIngreso;
import pe.unmsm.sistemaalmacen.util.Constantes;
import pe.unmsm.sistemaalmacen.dominio.RegistroEntrada;
import pe.unmsm.sistemaalmacen.service.impl.RegistroEntradaServiceImpl;

/**
 *
 * @author Miguel
 */
public class CNuevoIngresoImpl extends CPadreNuevoIngresoSalidaImpl implements CNuevoIngreso {

    @Override
    public void clickBtnGuardar(ActionEvent evt) {
        if (!vIngSal.txtProveedor.getText().equals("")) {
            RegistroEntradaServiceImpl validacionRegistroDAO = new RegistroEntradaServiceImpl();
            super.vIngSal.estaGuardado = true;

            //REGISTRO EN LA BASE DE DATOS
            RegistroEntrada registroAguardar = new RegistroEntrada(
                    Integer.parseInt(vIngSal.txtFolio.getText()),
                    Constantes.convertirFechaAdateSQL(vIngSal.txtFecha.getText()),
                    Constantes.USER.getNombre(),
                    vIngSal.txtProveedor.getText(),
                    vIngSal.miListaProductos,
                    vIngSal.txtObservaciones.getText(),
                    Float.parseFloat(vIngSal.txtSubTotal.getText()),
                    Float.parseFloat(vIngSal.txtImpuesto.getText()),
                    Float.parseFloat(vIngSal.txtTotal.getText())
            );
            //        validacionRegistroDAO.registrar(registroAguardar);
            JOptionPane.showMessageDialog(vIngSal, "Se realizo un nuevo registro de entrada", "Guardado exitoso!!!", JOptionPane.INFORMATION_MESSAGE);
            super.vIngSal.dispose();
        } else {
            JOptionPane.showMessageDialog(vIngSal, "ERROR!! Debe ingresar un nombre proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            vIngSal.txtProveedor.requestFocus();
        }
    }

}
