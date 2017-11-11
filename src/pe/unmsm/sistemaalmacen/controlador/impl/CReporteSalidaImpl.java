/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import java.awt.event.ActionEvent;
import pe.unmsm.sistemaalmacen.controlador.CReporteSalida;
import pe.unmsm.sistemaalmacen.vista.VentanaReporteEntrada;
import pe.unmsm.sistemaalmacen.vista.VentanaReporteSalida;

/**
 *
 * @author Miguel
 */
public class CReporteSalidaImpl extends CPadreReportesIngresoSalidaImpl implements CReporteSalida{
  
    
    @Override
    public void clickBtnEliminar(ActionEvent e){
        System.out.println("clickBtnEliminar de ventana salida");
    }
}
