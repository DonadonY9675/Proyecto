/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador;

import java.awt.event.ActionEvent;
import pe.unmsm.sistemaalmacen.vista.VentanaLogIn;

/**
 *
 * @author Miguel
 */
public interface CLogin extends MantenimientoControlador {

    public void setVentanaLogin(VentanaLogIn ventana);

    public void clickbtnEntrar(ActionEvent evt);

    public void clickbtnSalir(ActionEvent evt);
}
