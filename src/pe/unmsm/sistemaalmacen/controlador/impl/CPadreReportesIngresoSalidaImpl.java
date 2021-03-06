/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import pe.unmsm.sistemaalmacen.util.Utils;
import pe.unmsm.sistemaalmacen.dominio.Registro;

import pe.unmsm.sistemaalmacen.vista.VPadreReportesIngresoSalida;
import pe.unmsm.sistemaalmacen.vista.VentanaReporteEntrada;

/**
 *
 * @author Miguel
 */
public abstract class CPadreReportesIngresoSalidaImpl {

    VPadreReportesIngresoSalida vRepIngSal;

    public void setVPadreReportesIngresoSalida(VPadreReportesIngresoSalida vRepIngSal) {
        this.vRepIngSal = vRepIngSal;
        vRepIngSal.btnBuscar.addActionListener(this::clickBtnBuscar);
        vRepIngSal.btnEliminar.addActionListener(this::clickBtnEliminar);
        vRepIngSal.btnTodos.addActionListener(this::clickBtnTodos);

        //evento de JList
        vRepIngSal.lstProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clickLstProductos(e);
            }
        });
        //eventos de JadioButton
        vRepIngSal.rbrnFecha.addItemListener(this::clickRdbnFecha);
        vRepIngSal.txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                presionTeclaTxtBuscar(e);
            }
        });
    }

    public void presionTeclaTxtBuscar(KeyEvent e) {
        if (vRepIngSal.rbtnUsuario.isSelected()) {
            buscarPorUsuario();
        } else if (vRepIngSal.rbtnProveedor.isSelected()) {
            buscarPorClienteProveedor();
        } else if (vRepIngSal.rbrnFecha.isSelected()) {
            buscarPorFecha();
        } else if (vRepIngSal.rbtnFolio.isSelected()) {
            buscarPorCodigo();
        }
        vRepIngSal.actualizarLista();
        vRepIngSal.actualizarDatos();
        vRepIngSal.actualizarTabla();

    }

    private void buscarPorUsuario() {
        vRepIngSal.miListaRegistrosFiltrado = vRepIngSal.miListaRegistroCompleta
                .filtrar((Registro r) -> r.getUsusario().toLowerCase().
                contains(vRepIngSal.txtBuscar.getText().toLowerCase()));
    }

    private void buscarPorCodigo() {
        if (!vRepIngSal.txtBuscar.getText().equals("")) {
            vRepIngSal.miListaRegistrosFiltrado = vRepIngSal.miListaRegistroCompleta
                    .filtrar(u -> u.getCodigo().toUpperCase().contains(vRepIngSal.txtBuscar.getText().toUpperCase()));
        } else {
            vRepIngSal.miListaRegistrosFiltrado = vRepIngSal.miListaRegistroCompleta;
        }
    }

    private void buscarPorFecha() {
        if (vRepIngSal.jDateFecha.getDate() == null) {
            JOptionPane.showMessageDialog(vRepIngSal, "ERROR!!!, Seleccione una fecha", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String fecha = Utils.convertirDateSQLaString(
                    new java.sql.Date(vRepIngSal.jDateFecha.getDate().getTime()));
            vRepIngSal.miListaRegistrosFiltrado = vRepIngSal.miListaRegistroCompleta
                    .filtrar(u -> Utils.convertirDateSQLaString(u.getFecha()).equals(fecha));
        }
    }

    private void buscarPorClienteProveedor() {

        vRepIngSal.miListaRegistrosFiltrado = vRepIngSal.miListaRegistroCompleta
                .filtrar(r -> r.getAgente().toLowerCase().
                contains(vRepIngSal.txtBuscar.getText().toLowerCase()));

    }

    public void clickRdbnFecha(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            vRepIngSal.mostrarJDateChooser();
        } else {
            vRepIngSal.mostrarTxtBuscar();
        }
    }

    public void clickLstProductos(MouseEvent e) {

        vRepIngSal.actualizarTabla();
        vRepIngSal.actualizarDatos();
    }

    public void clickBtnBuscar(ActionEvent e) {

        if (vRepIngSal.rbtnUsuario.isSelected()) {
            buscarPorUsuario();
        } else if (vRepIngSal.rbtnProveedor.isSelected()) {
            buscarPorClienteProveedor();
        } else if (vRepIngSal.rbrnFecha.isSelected()) {
            buscarPorFecha();
        } else if (vRepIngSal.rbtnFolio.isSelected()) {
            buscarPorCodigo();
        }
        vRepIngSal.actualizarLista();
        vRepIngSal.actualizarDatos();
        vRepIngSal.actualizarTabla();

    }

    public void clickBtnTodos(ActionEvent e) {
        vRepIngSal.miListaRegistrosFiltrado = vRepIngSal.miListaRegistroCompleta;
        vRepIngSal.actualizarLista();
        vRepIngSal.actualizarDatos();
        vRepIngSal.actualizarTabla();
    }

    public abstract void clickBtnEliminar(ActionEvent evt);

}
