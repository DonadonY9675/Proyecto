/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.main;

import proy.controlador.impl.CMenuPrincipalImpl;
import proy.controlador.impl.CModeloIngresoSalidaImpl;
import proy.vista.*;

/**
 *
 */
public class Main {
    VentanaMenuPrincipal miVentanaPrincipal;
    ModeloNuevoIngresoSalida miVentanaNuevoIngreso;
    CMenuPrincipalImpl miCoordinadorVPrincipal;
    
    public static void main(String[] args) {
        Main principal = new Main();
        principal.iniciar();
    }
    
    public void iniciar(){
        miVentanaPrincipal = new VentanaMenuPrincipal();
        miVentanaPrincipal.setVisible(true);
        miCoordinadorVPrincipal = new CMenuPrincipalImpl();
        
        miCoordinadorVPrincipal.setVentanaMenuPrincipal(miVentanaPrincipal);
        
        
    }
    
}
