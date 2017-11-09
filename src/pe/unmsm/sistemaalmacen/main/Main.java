/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.main;

import pe.unmsm.sistemaalmacen.vista.VentanaLogIn;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import pe.unmsm.sistemaalmacen.controlador.impl.CLoginImpl;
import pe.unmsm.sistemaalmacen.controlador.impl.CMenuPrincipalImpl;
import pe.unmsm.sistemaalmacen.dao.impl.ConfiguracionDAOImpl;
import pe.unmsm.sistemaalmacen.dominio.Configuracion;
import pe.unmsm.sistemaalmacen.util.Constantes;

/**
 *
 */
public class Main {

//    VentanaMenuPrincipal miVentanaPrincipal;
//    CMenuPrincipalImpl miCoordinadorVPrincipal;
    VentanaLogIn miVentanaLogIn;
    CLoginImpl miCoordinadorLogin;

    public static void main(String[] args) {
        Main principal = new Main();
        principal.cargarConfiguracionInicial();
        principal.iniciar();
        
        String mensaje = "Por el momento se puede ingresar con cualquier usuario y contraseña"
                + " y lo acepará como si estuviese registrado.\n Para este avance se implementaron:"
                + " Los 5 JButton que se encuentran en el menu principal (y sus respectivas subVentanas), + el Menu configuracion"
                + "\nLas consultas SQL no se han implementado, y "
                + "en las clases DAO solo se devuelve una ListaDoble con productos preingresados para "
                + "realizar las respectivas consultas,\n "
                + " por lo que las funciones de guardar y eliminar no agregarán o quitarán productos."
                + "\nEn caso de ser nesesario se adjunto las librerias jcalendar en el archivo del proyecto"
                + "para que funcione el aplicativo";

                JOptionPane.showMessageDialog(null, mensaje, "Entregable 3", 1);
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

        Configuracion miConfiguracionInicial = new ConfiguracionDAOImpl().get("1");
        Constantes.IGV = miConfiguracionInicial.getIGV();
        Constantes.logo = miConfiguracionInicial.getLogo();

    }
}
