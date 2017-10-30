/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador.impl;

import java.awt.event.ActionEvent;
import proy.controlador.CReporteSalida;
import proy.vista.VentanaReporteEntrada;
import proy.vista.VentanaReporteSalida;

/**
 *
 * @author Miguel
 */
public class CReporteSalidaImpl extends CPadreReportesIngresoSalida implements CReporteSalida{
  
    
    @Override
    public void clickBtnEliminar(ActionEvent e){
        System.out.println("clickBtnEliminar de ventana salida");
    }
}
