/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import pe.unmsm.sistemaalmacen.vista.VentanaInventario;

/**
 *
 */
public interface CInventario extends MantenimientoControlador {

    public void setVentanaInventario(VentanaInventario ventana);

    public void clickBtnBuscar(KeyEvent e);

    public void clickBtnMostrarTodos(ActionEvent e);

    public void clickBtnProxAgot(ActionEvent e);

    public void clickBtnAgregar(ActionEvent e);

    public void clickBtnEditar(ActionEvent e);

    public void clickBtnEliminar(ActionEvent e);

    public void clickjListProductos(MouseEvent e);
}
