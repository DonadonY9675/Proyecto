/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import pe.unmsm.sistemaalmacen.controlador.CLogin;
import pe.unmsm.sistemaalmacen.daou.UsuarioDao;
import pe.unmsm.sistemaalmacen.dao.impl.UsuarioDAOImpl;
import pe.unmsm.sistemaalmacen.util.Constantes;
import pe.unmsm.sistemaalmacen.dominio.Usuario;
import pe.unmsm.sistemaalmacen.vista.VentanaLogIn;
import pe.unmsm.sistemaalmacen.vista.VentanaMenuPrincipal;
/**
 *
 * @author Miguel
 */
public class CLoginImpl implements CLogin{
    private VentanaLogIn miVentanaLogIn;
    private UsuarioDao usuarioDao = new UsuarioDAOImpl();
    
    @Override
    public void setVentanaLogin(VentanaLogIn ventana){
        this.miVentanaLogIn = ventana;
        miVentanaLogIn.jButtonEntrar.addActionListener((evt) -> this.clickbtnEntrar(evt));
        miVentanaLogIn.jButtonCancelar.addActionListener((evt) -> this.clickbtnSalir(evt));
    }
    
    
    @Override
    public void clickbtnEntrar(ActionEvent evt) {
        boolean existe=false;
        String nombreUsuario = miVentanaLogIn.jTextFieldUsuario.getText();
        String password = String.valueOf(miVentanaLogIn.jPasswordFieldContrasenia.getPassword());
         
        //COMPROBAR EXISTENCIA DE USUARIO
        //---------------------------------------------------
        existe=true;
        //---------------------------------------------------
        
        if(existe){
            
            Usuario usuario = new Usuario(nombreUsuario, password, true);
            Constantes.USER = usuario;
            
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
