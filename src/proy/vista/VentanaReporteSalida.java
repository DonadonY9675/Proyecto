/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.vista;

import estructuras.ListaDoble;
import java.awt.Frame;
import proy.dominio.Registro;

/**
 *
 * @author Miguel
 */
public class VentanaReporteSalida extends VPadreReportesIngresoSalida{
    
    public VentanaReporteSalida(Frame parent, boolean modal, ListaDoble<Registro> miListaRegistros) {
        super(parent, modal, miListaRegistros);
        lblTitulo.setText("Reportes de Salida");
        lblProveedorCliente.setText("Cliente");
        rbtnProveedor.setText("Cliente");
    }
    
}
