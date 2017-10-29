/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.main;

import java.awt.Color;
import javax.swing.UIManager;
import proy.controlador.impl.CLoginImpl;
import proy.controlador.impl.CMenuPrincipalImpl;
import proy.controlador.impl.CoordinadorDeCoordinadores;
import proy.dao.impl.ConfiguracionDAOImpl;
import proy.dominio.Configuracion;
import proy.dominio.Constantes;
import proy.vista.*;

/**
 *
 */
public class Main extends CoordinadorDeCoordinadores {

//    VentanaMenuPrincipal miVentanaPrincipal;
//    CMenuPrincipalImpl miCoordinadorVPrincipal;
    VentanaLogIn miVentanaLogIn;
    CLoginImpl miCoordinadorLogin;

    public static void main(String[] args) {
        Main principal = new Main();
        principal.cargarConfiguracionInicial();
        principal.iniciar();
        
    }

    public void iniciar() {
        UIManager.put("Button.background", Color.white); //da color blanco a los botones

        miVentanaLogIn =new VentanaLogIn();
        miVentanaLogIn.setVisible(true);
        miVentanaLogIn.setLocationRelativeTo(null);
        miCoordinadorLogin = new CLoginImpl();
        
        miCoordinadorLogin.setVentanaLogin(miVentanaLogIn);
        
//        miVentanaPrincipal = new VentanaMenuPrincipal();
//        miVentanaPrincipal.setVisible(true);
//        miCoordinadorVPrincipal = new CMenuPrincipalImpl();
//
//        miCoordinadorVPrincipal.setVentanaMenuPrincipal(miVentanaPrincipal);
    }

    public void cargarConfiguracionInicial() {

        Configuracion miConfiguracionInicial = new ConfiguracionDAOImpl().get("scads");
        Constantes.IGV = miConfiguracionInicial.getIGV();
        Constantes.logo = miConfiguracionInicial.getLogo();

    }
}
