/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador.impl;

import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import proy.controlador.CLogin;
import proy.vista.VentanaLogIn;
import proy.vista.VentanaMenuPrincipal;
/**
 *
 * @author Miguel
 */
public class CLoginImpl implements CLogin{
    private VentanaLogIn miVentanaLogIn;
    
    private String usuario;
    private String password;
    
    public void setVentanaLogin(VentanaLogIn ventana){
        this.miVentanaLogIn = ventana;
        miVentanaLogIn.jButtonEntrar.addActionListener((evt) -> this.clickbtnEntrar(evt));
        miVentanaLogIn.jButtonCancelar.addActionListener((evt) -> this.clickbtnSalir(evt));
    }
    
    public void obtenerEntradas(){
        usuario = miVentanaLogIn.jTextFieldUsuario.getText();
        password = String.valueOf(miVentanaLogIn.jPasswordFieldContrasenia.getPassword());
        
    }

    @Override
    public void clickbtnEntrar(ActionEvent evt) {
        boolean existe=false;
        obtenerEntradas();
        
        //COMPROBAR EXISTENCIA DE USUARIO
        //---------------------------------------------------
        existe=true;
        //---------------------------------------------------
        
        if(existe){
            VentanaMenuPrincipal ventanaPrincipal = new VentanaMenuPrincipal();
            CMenuPrincipalImpl coordinadorNuevaSalida = new CMenuPrincipalImpl();
            coordinadorNuevaSalida.setVentanaMenuPrincipal(ventanaPrincipal);
            ventanaPrincipal.setLocationRelativeTo(null);
            ventanaPrincipal.setVisible(true);
            miVentanaLogIn.dispose();
    
        }else{
            JOptionPane.showMessageDialog(this.miVentanaLogIn,"Nombre de usuario"
                    + " o contraseña invalidos");
            miVentanaLogIn.jPasswordFieldContrasenia.setText("");
        }
    }

    @Override
    public void clickbtnSalir(ActionEvent evt) {
        System.exit(0);
    }
    
}
