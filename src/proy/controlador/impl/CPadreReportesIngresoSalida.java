/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador.impl;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import proy.vista.VPadreReportesIngresoSalida;

/**
 *
 * @author Miguel
 */
public abstract class CPadreReportesIngresoSalida {

    VPadreReportesIngresoSalida vRepIngSal;

    public void setVPadreReportesIngresoSalida(VPadreReportesIngresoSalida vRepIngSal) {
        this.vRepIngSal = vRepIngSal;
        vRepIngSal.btnBuscar.addActionListener(this::clickBtnBuscar);
        vRepIngSal.btnEliminar.addActionListener(this::clickBtnEliminar);
        vRepIngSal.lstProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clickLstProductos(e);
            }
        });
    }

    public void clickLstProductos(MouseEvent e) {
        
        vRepIngSal.actualizarTabla();
        vRepIngSal.actualizarDatos();
    }

    public void clickBtnBuscar(ActionEvent e) {
        
    }

    public abstract void clickBtnEliminar(ActionEvent evt);

}
