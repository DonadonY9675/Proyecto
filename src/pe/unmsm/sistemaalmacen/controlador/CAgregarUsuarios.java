/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador;

import java.awt.event.ActionEvent;
import pe.unmsm.sistemaalmacen.vista.VentanaAgregarUsuarios;
import pe.unmsm.sistemaalmacen.vista.VentanaMenuPrincipal;

/**
 *
 * @author Anthony
 */
public interface CAgregarUsuarios extends MantenimientoControlador {
    public void setVAgregarUsuarios(VentanaAgregarUsuarios vAgregarUsuarios, VentanaMenuPrincipal vPrincipal);

    public void clickBtnEditar(ActionEvent evt);
    
    public void clickBtnAgregar(ActionEvent evt);
    
    public void clickBtnEliminar(ActionEvent evt);
    
    
}
