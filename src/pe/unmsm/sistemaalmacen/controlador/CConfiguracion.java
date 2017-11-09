/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador;

import java.awt.event.ActionEvent;
import pe.unmsm.sistemaalmacen.vista.VentanaConfiguracion;
import pe.unmsm.sistemaalmacen.vista.VentanaMenuPrincipal;

/**
 *
 * @author Miguel
 */
public interface CConfiguracion extends MantenimientoControlador {

    public void setVConfiguracion(VentanaConfiguracion vConf, VentanaMenuPrincipal vPrincipal);

    public void clickBtnGuardar(ActionEvent evt);

    public void clickBtnSalir(ActionEvent evt);

    public void clickBtnExaminar(ActionEvent evt);
}
