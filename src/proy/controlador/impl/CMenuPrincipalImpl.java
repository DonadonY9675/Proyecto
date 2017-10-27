/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador.impl;

import java.awt.event.ActionEvent;
import proy.vista.VentanaMenuPrincipal;
import proy.vista.VentanaNuevaSalida;
import proy.vista.VentanaNuevoIngreso;
import proy.controlador.CMenuPrincipal;

/**
 *
 */
public class CMenuPrincipalImpl extends CoordinadorDeCoordinadores implements CMenuPrincipal {

    VentanaMenuPrincipal ventPrincipal;

    public void setVentanaMenuPrincipal(VentanaMenuPrincipal miVenanaMenuPrincipal) {
        this.ventPrincipal = miVenanaMenuPrincipal;
        //agregando action listener de los botones del menuprincipal
        ventPrincipal.btnNuevaEntrada.addActionListener((evt) -> this.clickBtnNuevaEntrada(evt));
        ventPrincipal.btnNuevaSalida.addActionListener((evt) -> this.clickBtnNuevaSalida(evt));
        ventPrincipal.btnMiInventario.addActionListener((evt) -> this.clickBtnMiInventario(evt));
        ventPrincipal.btnReportesDeEntrada.addActionListener((evt) -> this.clickBtnReportesDeEntrada(evt));
        ventPrincipal.btnReportesDeSalida.addActionListener((evt) -> this.clickBtnReportesDeSalida(evt));

    }

    @Override
    public void clickBtnNuevaEntrada(ActionEvent evt) {
        VentanaNuevoIngreso ventanaNuevoIngreso;ventanaNuevoIngreso = new VentanaNuevoIngreso(null, true);
        CNuevoIngresoImpl coordinadorNuevoIngreso = new CNuevoIngresoImpl();
        coordinadorNuevoIngreso.setMiModeloNuevoIngresoSalida(ventanaNuevoIngreso);
        ventanaNuevoIngreso.setLocationRelativeTo(null);
        ventanaNuevoIngreso.setVisible(true);

    }

    @Override
    public void clickBtnNuevaSalida(ActionEvent evt) {
        VentanaNuevaSalida ventanaNuevaSalida = new VentanaNuevaSalida(null, true);
        CNuevaSalidaImpl coordinadorNuevaSalida = new CNuevaSalidaImpl();
        coordinadorNuevaSalida.setMiModeloNuevoIngresoSalida(ventanaNuevaSalida);
        ventanaNuevaSalida.setLocationRelativeTo(null);
        ventanaNuevaSalida.setVisible(true);
    }

    @Override
    public void clickBtnMiInventario(ActionEvent evt) {

    }

    @Override
    public void clickBtnReportesDeEntrada(ActionEvent evt) {

    }

    @Override
    public void clickBtnReportesDeSalida(ActionEvent evt) {

    }

}
