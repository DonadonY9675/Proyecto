/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador;

import java.awt.event.ActionEvent;

/**
 *
 * @author Miguel
 */
public interface CLogin extends MantenimientoControlador {
    void clickbtnEntrar(ActionEvent evt);
    
    void clickbtnSalir(ActionEvent evt);
}