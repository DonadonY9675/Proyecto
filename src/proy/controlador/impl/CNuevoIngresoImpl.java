/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador.impl;

import java.awt.event.ActionEvent;
import proy.controlador.CNuevoIngreso;
import proy.service.impl.RegistroEntradaServiceImpl;

/**
 *
 * @author Miguel
 */
public class CNuevoIngresoImpl extends CPadreNuevoIngresoSalidaImpl implements CNuevoIngreso {
    
    @Override
    public void clickBtnGuardar(ActionEvent evt) {
        RegistroEntradaServiceImpl  validacionRegistroDAO =  new RegistroEntradaServiceImpl();
        
//        validacionRegistroDAO.registrar(e);

    }
    
}
