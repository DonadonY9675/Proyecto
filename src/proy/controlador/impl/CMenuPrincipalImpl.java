/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador.impl;

import java.awt.event.ActionEvent;
import proy.controlador.CConfiguracion;
import proy.vista.VentanaMenuPrincipal;
import proy.vista.VentanaNuevaSalida;
import proy.vista.VentanaNuevoIngreso;
import proy.controlador.CMenuPrincipal;
import proy.vista.VentanaConfiguracion;

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
        ventPrincipal.mnItmDatos.addActionListener(this::clickBtnConfiguracion);
    }

    @Override
    public void clickBtnNuevaEntrada(ActionEvent evt) {
        VentanaNuevoIngreso ventanaNuevoIngreso;ventanaNuevoIngreso = new VentanaNuevoIngreso(ventPrincipal, true);
        CNuevoIngresoImpl coordinadorNuevoIngreso = new CNuevoIngresoImpl();
        coordinadorNuevoIngreso.setMiModeloNuevoIngresoSalida(ventanaNuevoIngreso);
        ventanaNuevoIngreso.setLocationRelativeTo(null);
        ventanaNuevoIngreso.setVisible(true);

    }

    @Override
    public void clickBtnNuevaSalida(ActionEvent evt) {
        VentanaNuevaSalida ventanaNuevaSalida = new VentanaNuevaSalida(ventPrincipal, true);
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
    
    public void clickBtnConfiguracion(ActionEvent evt){
        VentanaConfiguracion ventanaConfiguracion = new VentanaConfiguracion(ventPrincipal, true);
        CConfiguracionImpl coordinadorVConfiguracion = new CConfiguracionImpl();
        System.out.println("seteando ventPriciapl");
        coordinadorVConfiguracion.setVConfiguracion(ventanaConfiguracion, ventPrincipal);
        ventanaConfiguracion.setLocationRelativeTo(null);
        ventanaConfiguracion.setVisible(true);
    }

}
