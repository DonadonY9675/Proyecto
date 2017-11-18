/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import pe.unmsm.sistemaalmacen.controlador.CLogin;
import pe.unmsm.sistemaalmacen.dao.impl.UsuarioDAOImpl;
import pe.unmsm.sistemaalmacen.util.Utils;
import pe.unmsm.sistemaalmacen.dominio.Usuario;
import pe.unmsm.sistemaalmacen.vista.VentanaLogIn;
import pe.unmsm.sistemaalmacen.vista.VentanaMenuPrincipal;
import pe.unmsm.sistemaalmacen.dao.UsuarioDAO;
/**
 *
 * @author Miguel
 */
public class CLoginImpl implements CLogin{
    private VentanaLogIn miVentanaLogIn;
    private UsuarioDAO usuarioDao = new UsuarioDAOImpl();
    
    @Override
    public void setVentanaLogin(VentanaLogIn ventana){
        this.miVentanaLogIn = ventana;
        miVentanaLogIn.jButtonEntrar.addActionListener((evt) -> this.clickbtnEntrar(evt));
        miVentanaLogIn.jButtonCancelar.addActionListener((evt) -> this.clickbtnSalir(evt));
//        miVentanaLogIn.addKeyListener(new KeyAdapter() {
//            public void keyTyped(KeyEvent e){
//                if(e.getKeyChar()=='n'){
//                    comprobarUsuario();
//                }
//            }
//        });
    }
    
    
    @Override
    public void clickbtnEntrar(ActionEvent evt) {
        comprobarUsuario();
    }
    
    public void comprobarUsuario(){
        String nombreUsuario = miVentanaLogIn.jTextFieldUsuario.getText();
        String password = String.valueOf(miVentanaLogIn.jPasswordFieldContrasenia.getPassword());
         
        //COMPROBAR EXISTENCIA DE USUARIO
        //---------------------------------------------------
        Usuario usuario = usuarioDao.get(nombreUsuario);
//        Usuario usuario = new Usuario(nombreUsuario, password, true);
        //---------------------------------------------------
        
        if(usuario!=null && usuario.getContrasenia().equals(password)){
            
            Utils.USER = usuario;
            
            VentanaMenuPrincipal ventanaPrincipal = new VentanaMenuPrincipal();
            CMenuPrincipalImpl coordinadorVentPrinc = new CMenuPrincipalImpl();
            coordinadorVentPrinc.setVentanaMenuPrincipal(ventanaPrincipal);
            Thread t1 = new Thread(ventanaPrincipal);
            t1.start();
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
