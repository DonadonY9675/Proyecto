/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import java.awt.event.ActionEvent;
import pe.unmsm.sistemaalmacen.controlador.CReporteEntrada;
import pe.unmsm.sistemaalmacen.dominio.Registro;
import pe.unmsm.sistemaalmacen.service.RegistroService;
import pe.unmsm.sistemaalmacen.service.impl.RegistroServiceImpl;
import pe.unmsm.sistemaalmacen.vista.VentanaReporteEntrada;

/**
 *
 * @author Miguel
 */
public class CReporteEntradaImpl extends CPadreReportesIngresoSalidaImpl implements CReporteEntrada {

    @Override
    public void clickBtnEliminar(ActionEvent e) {
        int seleccion = super.vRepIngSal.lstProductos.getSelectedIndex();
        System.out.println(seleccion+"ADS");
        if (seleccion != -1) {
            Registro regElim = super.vRepIngSal.miListaRegistrosFiltrado.get(seleccion);
            System.out.println(regElim.getCodigo());
            
            RegistroService service = new RegistroServiceImpl();
            
            service.eliminar(regElim.getCodigo());
            
            super.vRepIngSal.miListaRegistroCompleta = super.vRepIngSal.miListaRegistroCompleta
                    .filtrar(elem -> !elem.getCodigo().equals(regElim.getCodigo()));
            super.vRepIngSal.miListaRegistrosFiltrado = super.vRepIngSal.miListaRegistrosFiltrado
                    .filtrar(elem -> !elem.getCodigo().equals(regElim.getCodigo()));
            super.vRepIngSal.actualizarLista();
            super.vRepIngSal.actualizarTabla();
        }

    }

}
