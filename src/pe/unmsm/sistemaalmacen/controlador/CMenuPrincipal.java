/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador;

import java.awt.event.ActionEvent;
import pe.unmsm.sistemaalmacen.vista.VentanaMenuPrincipal;

/**
 *
 * @author Miguel
 */
public interface CMenuPrincipal extends MantenimientoControlador {

    public void setVentanaMenuPrincipal(VentanaMenuPrincipal miVenanaMenuPrincipal);

    void clickBtnNuevaEntrada(ActionEvent evt);

    public void clickBtnNuevaSalida(ActionEvent evt);

    void clickBtnMiInventario(ActionEvent evt);

    void clickBtnReportesDeEntrada(ActionEvent evt);

    void clickBtnReportesDeSalida(ActionEvent evt);

    public void clickBtnConfiguracion(ActionEvent evt);
}
