/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import pe.unmsm.sistemaalmacen.controlador.CNuevaSalida;
import pe.unmsm.sistemaalmacen.util.Utils;
import pe.unmsm.sistemaalmacen.dominio.RegistroEntrada;
import pe.unmsm.sistemaalmacen.dominio.RegistroSalida;
import pe.unmsm.sistemaalmacen.service.impl.RegistroSalidaServiceImpl;

/**
 *
 * @author Miguel
 */
public class CNuevaSalidaImpl extends CPadreNuevoIngresoSalidaImpl implements CNuevaSalida {

    @Override
    public void clickBtnGuardar(ActionEvent evt) {
        if (!vIngSal.txtProveedor.getText().equals("")) {
            RegistroSalidaServiceImpl validacionRegistroDAO = new RegistroSalidaServiceImpl();
            super.vIngSal.estaGuardado = true;

            //REGISTRO EN LA BASE DE DATOS
            RegistroSalida registroAguardar = new RegistroSalida(
                    Integer.parseInt(vIngSal.txtFolio.getText()),
                    Utils.convertirFechaAdateSQL(vIngSal.txtFecha.getText()),
                    Utils.USER.getNombre(),
                    vIngSal.txtProveedor.getText(),
                    vIngSal.miListaProductos,
                    vIngSal.txtObservaciones.getText(),
                    Float.parseFloat(vIngSal.txtSubTotal.getText()),
                    Float.parseFloat(vIngSal.txtImpuesto.getText()),
                    Float.parseFloat(vIngSal.txtTotal.getText())
            );
            //        validacionRegistroDAO.registrar(registroAguardar);
            JOptionPane.showMessageDialog(vIngSal, "Se realizo un nuevo registro de salida", "Guardado exitoso!!!", JOptionPane.INFORMATION_MESSAGE);
            super.vIngSal.dispose();
        } else {
            JOptionPane.showMessageDialog(vIngSal, "ERROR!! Debe ingresar un nombre cliente", "Error", JOptionPane.ERROR_MESSAGE);
            vIngSal.txtProveedor.requestFocus();
        }
    }

}
