/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import pe.unmsm.sistemaalmacen.vista.VentanaEditarProducto;

/**
 *
 * @author Miguel
 */
public interface CEditarProducto extends MantenimientoControlador  {
    public void setVentanaEditarProducto(VentanaEditarProducto ventana);
    
    public void clickBtnEditar(ActionEvent e);
    
    public void clickBtnExaminar(ActionEvent evt);
    
    public void clickCombo(ItemEvent evt);
}