/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import proy.dominio.Producto;
import proy.vista.VentanaAgregarProducto;
import proy.vista.VentanaEditarProducto;
import proy.vista.VentanaInventario;

/**
 *
 */
public interface CInventario extends MantenimientoControlador {

    public void setVentanaInventario(VentanaInventario ventana);

    public void actualizarJList();

    public void clickBtnBuscar(ActionEvent e);

    public void clickBtnMostrarTodos(ActionEvent e);

    public void clickBtnProxAgot(ActionEvent e);

    public void clickBtnAgregar(ActionEvent e);

    public void clickBtnEditar(ActionEvent e);

    public void clickBtnEliminar(ActionEvent e);

    public void clickjListProductos(MouseEvent e);
}
