/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.service.impl;

import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import javax.swing.JDialog;
import javax.swing.JFrame;
import pe.unmsm.sistemaalmacen.dao.impl.ConfiguracionDAOImpl;
import pe.unmsm.sistemaalmacen.dominio.Categoria;
import pe.unmsm.sistemaalmacen.dominio.Configuracion;
import pe.unmsm.sistemaalmacen.service.ConfiguracionService;
import pe.unmsm.sistemaalmacen.vista.VentanaConfiguracion;

/**
 *
 * @author Miguel
 */
public class ConfiguracionServiceImpl implements ConfiguracionService {

    ConfiguracionDAOImpl configuracionDAO = new ConfiguracionDAOImpl();
    
    @Override
    public boolean registrar(Configuracion e) {
        return configuracionDAO.registrar(e);
    }

    @Override
    public boolean modificar(Configuracion e) {
        return configuracionDAO.modificar(e);
    }

    public boolean modificar(VentanaConfiguracion v) {

        if (true/*VALIDACIONES*/) {            
//
            //TODAS LAS VALCIDACIONES DE DATOS 
            //
            String logo = v.txtLogo.getText();
            String nombre = v.txtNombre.getText();
            String ruc = v.txtRuc.getText();
            String direccion = v.txtDireccion.getText();
            double igv = Double.parseDouble(v.txtIgv.getText());
            Configuracion miConfiguracion = new Configuracion(logo, nombre, ruc, direccion, igv);
            
            configuracionDAO.modificar(miConfiguracion);
            
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Configuracion get(String id) {
        return configuracionDAO.get(id);
    }

    @Override
    public ListaDoble<Configuracion> getAll() {
        return configuracionDAO.getAll();
    }

    @Override
    public boolean eliminar(String id) {
        return configuracionDAO.eliminar(id);
    }

}
