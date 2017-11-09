/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador;

import java.awt.event.ActionEvent;

/**
 *
 * @author Miguel
 */
public interface CNuevoIngreso extends CModeloNuevoIngresoSalida{
    /**
     * hereda todos sus metodos de CModeloNuevoIngresoSalida
     */
    public void clickBtnGuardar(ActionEvent evt);
}
