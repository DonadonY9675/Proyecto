/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador.impl;

import java.awt.event.ActionEvent;
import proy.controlador.CNuevaSalida;

/**
 *
 * @author Miguel
 */
public class CNuevaSalidaImpl extends CModeloIngresoSalidaImpl implements CNuevaSalida {

    @Override
    public void clickBtnGuardar(ActionEvent evt) {
        System.out.println("clickBtnGuardar de vsalida");
    }

}
