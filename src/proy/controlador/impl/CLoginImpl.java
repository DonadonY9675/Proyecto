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
/**
 *
 * @author Miguel
 */
public class CLoginImpl implements CLogin{
    private VentanaLogIn miVentanaLogIn;
    
    private String usuario;
    private String password;
    
    public CLoginImpl(VentanaLogIn ventana){
        this.miVentanaLogIn = ventana;
        miVentanaLogIn.jButtonEntrar.addActionListener((evt) -> this.clickbtnEntrar(evt));
        miVentanaLogIn.jButtonCancelar.addActionListener((evt) -> this.clickbtnSalir(evt));
    }
    
    
    public void obtenerEntradas(){
        usuario = miVentanaLogIn.jTextFieldUsuario.getText();
        password = String.valueOf(miVentanaLogIn.jPasswordFieldContrasenia.getPassword());
        
    }
    
    public void iniciarVentana(){
        miVentanaLogIn = new VentanaLogIn(this);
        miVentanaLogIn.setLocationRelativeTo(null);
        miVentanaLogIn.setVisible(true);
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
//            VMenuPrincipal miMenu = new VMenuPrincipalImpl();
//            miVentanaLogIn.dispose();
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
    
    /* ------------------------------
        PODRIA IR COMO UN METODO DE LA INTERFAZ MANTENIMIENTO CONTROLADOR
        ESTE METODO SIRVE PARA ESTABLECER PARENTS CON OTRAS VENTANAS
    */
    public Window getUIComponent(){
        return miVentanaLogIn;
    }
}
