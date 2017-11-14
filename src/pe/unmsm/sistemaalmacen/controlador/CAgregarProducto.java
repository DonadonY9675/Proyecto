/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador;

import java.awt.event.ActionEvent;
import pe.unmsm.sistemaalmacen.vista.VentanaAgregarProducto;

/**
 *
 * @author Anthony
 */
public interface CAgregarProducto extends MantenimientoControlador {
    
    public void setVentanaAgregarProducto(VentanaAgregarProducto ventana);
    
    public void clickBtnAgregar(ActionEvent e);
    
    public void clickBtnExaminar(ActionEvent e);
}
