/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import java.awt.event.ActionEvent;
import pe.unmsm.sistemaalmacen.controlador.CConfiguracion;
import pe.unmsm.sistemaalmacen.vista.VentanaMenuPrincipal;
import pe.unmsm.sistemaalmacen.vista.VentanaNuevaSalida;
import pe.unmsm.sistemaalmacen.vista.VentanaNuevoIngreso;
import pe.unmsm.sistemaalmacen.controlador.CMenuPrincipal;
import pe.unmsm.sistemaalmacen.dominio.Registro;
import pe.unmsm.sistemaalmacen.dominio.RegistroEntrada;
import pe.unmsm.sistemaalmacen.service.impl.RegistroEntradaServiceImpl;
import pe.unmsm.sistemaalmacen.service.impl.RegistroSalidaServiceImpl;
import pe.unmsm.sistemaalmacen.vista.VentanaConfiguracion;
import pe.unmsm.sistemaalmacen.vista.VentanaInventario;
import pe.unmsm.sistemaalmacen.vista.VentanaReporteEntrada;
import pe.unmsm.sistemaalmacen.vista.VentanaReporteSalida;

/**
 *
 */
public class CMenuPrincipalImpl implements CMenuPrincipal {
    
    VentanaMenuPrincipal ventPrincipal;
    
    @Override
    public void setVentanaMenuPrincipal(VentanaMenuPrincipal miVenanaMenuPrincipal) {
        this.ventPrincipal = miVenanaMenuPrincipal;
        //agregando action listener de los botones del menuprincipal
        ventPrincipal.btnNuevaEntrada.addActionListener((evt) -> this.clickBtnNuevaEntrada(evt));
        ventPrincipal.btnNuevaSalida.addActionListener((evt) -> this.clickBtnNuevaSalida(evt));
        ventPrincipal.btnMiInventario.addActionListener((evt) -> this.clickBtnMiInventario(evt));
        ventPrincipal.btnReportesDeEntrada.addActionListener((evt) -> this.clickBtnReportesDeEntrada(evt));
        ventPrincipal.btnReportesDeSalida.addActionListener((evt) -> this.clickBtnReportesDeSalida(evt));
        ventPrincipal.mnItmDatos.addActionListener(this::clickBtnConfiguracion);
    }
    
    @Override
    public void clickBtnNuevaEntrada(ActionEvent evt) {
        VentanaNuevoIngreso ventanaNuevoIngreso = new VentanaNuevoIngreso(ventPrincipal, true);
        CNuevoIngresoImpl coordinadorNuevoIngreso = new CNuevoIngresoImpl();
        coordinadorNuevoIngreso.setMiModeloNuevoIngresoSalida(ventanaNuevoIngreso);
        ventanaNuevoIngreso.setLocationRelativeTo(null);
        ventanaNuevoIngreso.setVisible(true);
        
    }
    
    @Override
    public void clickBtnNuevaSalida(ActionEvent evt) {
        VentanaNuevaSalida ventanaNuevaSalida = new VentanaNuevaSalida(ventPrincipal, true);
        CNuevaSalidaImpl coordinadorNuevaSalida = new CNuevaSalidaImpl();
        coordinadorNuevaSalida.setMiModeloNuevoIngresoSalida(ventanaNuevaSalida);
        ventanaNuevaSalida.setLocationRelativeTo(null);
        ventanaNuevaSalida.setVisible(true);
    }
    
    @Override
    public void clickBtnMiInventario(ActionEvent evt) {
        VentanaInventario ventanaInventario = new VentanaInventario(ventPrincipal, true);
        CInventarioImpl coordinadorInventario = new CInventarioImpl();
        coordinadorInventario.setVentanaInventario(ventanaInventario);
        ventanaInventario.setLocationRelativeTo(null);
        ventanaInventario.setVisible(true);
    }
    
    @Override
    public void clickBtnReportesDeEntrada(ActionEvent evt) {
        ListaDoble<Registro> listaRegistrosEntrada = new RegistroEntradaServiceImpl().getAll();
        
        VentanaReporteEntrada vReporteEntrada = new VentanaReporteEntrada(ventPrincipal, true, listaRegistrosEntrada);
        CReporteEntradaImpl coorReporteEntrada = new CReporteEntradaImpl();
        coorReporteEntrada.setVPadreReportesIngresoSalida(vReporteEntrada);
        vReporteEntrada.setLocationRelativeTo(ventPrincipal);
        vReporteEntrada.setVisible(true);
    }
    
    @Override
    public void clickBtnReportesDeSalida(ActionEvent evt) {
        ListaDoble<Registro> listaRegistroSalida = new RegistroSalidaServiceImpl().getAll();
        
        VentanaReporteSalida vReporteSalida = new VentanaReporteSalida(ventPrincipal, true, listaRegistroSalida);
        CReporteSalidaImpl coorReporteSalida = new CReporteSalidaImpl();
        coorReporteSalida.setVPadreReportesIngresoSalida(vReporteSalida);
        vReporteSalida.setLocationRelativeTo(null);
        vReporteSalida.setVisible(true);
        
    }
    
    public void clickBtnConfiguracion(ActionEvent evt) {
        VentanaConfiguracion ventanaConfiguracion = new VentanaConfiguracion(ventPrincipal, true);
        CConfiguracionImpl coordinadorVConfiguracion = new CConfiguracionImpl();
        System.out.println("seteando ventPriciapl");
        coordinadorVConfiguracion.setVConfiguracion(ventanaConfiguracion, ventPrincipal);
        ventanaConfiguracion.setLocationRelativeTo(null);
        ventanaConfiguracion.setVisible(true);
    }
    
}
