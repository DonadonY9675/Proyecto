/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.unmsm.sistemaalmacen.controlador.CAgregarUsuarios;
import pe.unmsm.sistemaalmacen.dao.impl.UsuarioDAOImpl;
import pe.unmsm.sistemaalmacen.dominio.Usuario;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.service.UsuarioService;
import pe.unmsm.sistemaalmacen.service.impl.UsuarioServiceImpl;
import pe.unmsm.sistemaalmacen.util.Utils;
import pe.unmsm.sistemaalmacen.vista.VentanaAgregarProducto;
import pe.unmsm.sistemaalmacen.vista.VentanaAgregarUsuarios;
import pe.unmsm.sistemaalmacen.vista.VentanaMenuPrincipal;

/**
 *
 * @author Anthony
 */
public class CAgregarUsuariosImpl implements CAgregarUsuarios{

    VentanaAgregarUsuarios vAgregarUsuarios;
    VentanaMenuPrincipal vMenuPrincipal;
    UsuarioService usuarioService = new UsuarioServiceImpl();
    
    private ListaDoble<Usuario> listUsuario = new ListaDoble<>();
    
    Usuario usuarioActual = Utils.USER;
    
    @Override
    public void setVAgregarUsuarios(VentanaAgregarUsuarios vAgregarUsuarios, VentanaMenuPrincipal vPrincipal) {
        this.vMenuPrincipal=vPrincipal;
        this.vAgregarUsuarios=vAgregarUsuarios;
        vAgregarUsuarios.BtnAgregar.addActionListener(this::clickBtnAgregar);
        vAgregarUsuarios.BtnEditar.addActionListener(this::clickBtnEditar);
        vAgregarUsuarios.BtnEliminar.addActionListener(this::clickBtnEliminar);
        
        listUsuario=usuarioService.getAll();
        llenarTabla();
        
        vAgregarUsuarios.jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clickjListProductos(e);
            }
        });
        vAgregarUsuarios.jTable1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                teclaListProductos(e);
            }
        });
        
    }
    
    @Override
    public void clickBtnEditar(ActionEvent evt) {
        int repetidosID=0;
        boolean esAdmin=false;
        for(Usuario u : listUsuario){
            if(u.getNombre().equals(vAgregarUsuarios.txtUsuario.getText())){
                repetidosID++;
            }
        }
        if(repetidosID!=0){
            if(vAgregarUsuarios.jPasswordField1.getText().equals(vAgregarUsuarios.jPasswordField2.getText())){
                if(vAgregarUsuarios.tipo.getSelectedIndex()==0){
                        esAdmin=true;
                        Usuario nuevo =new Usuario(vAgregarUsuarios.txtUsuario.getText(),
                                vAgregarUsuarios.jPasswordField1.getText(), esAdmin);    
                        //AGREGAR A LA BASE
                        if(usuarioActual.isEsAdmin()){
                            usuarioService.modificar(nuevo);
                            actualizarTabla();
                        }else{
                        JOptionPane.showMessageDialog(vAgregarUsuarios,"Usted no cuenta con los permisos necesarios");
                        }                        
                        //VACIAR CAMPOS
                        vAgregarUsuarios.txtUsuario.setText("");
                        vAgregarUsuarios.jPasswordField1.setText("");
                        vAgregarUsuarios.jPasswordField2.setText("");

                }else{
                    Usuario nuevo =new Usuario(vAgregarUsuarios.txtUsuario.getText(),
                                    vAgregarUsuarios.jPasswordField1.getText(), esAdmin);    
                    //AGREGAR A LA BASE
                    if(usuarioActual.isEsAdmin()){
                            usuarioService.modificar(nuevo);
                            JOptionPane.showMessageDialog(vAgregarUsuarios,"Modificado correctamente");
                            actualizarTabla();
                    }else{
                        JOptionPane.showMessageDialog(vAgregarUsuarios,"Usted no cuenta con los permisos necesarios");
                    }
                    //VACIAR CAMPOS
                    vAgregarUsuarios.txtUsuario.setText("");
                    vAgregarUsuarios.jPasswordField1.setText("");
                    vAgregarUsuarios.jPasswordField2.setText("");
                    
                }
            }else{
                JOptionPane.showMessageDialog(vAgregarUsuarios, "Las contraseñas no coinciden");
                vAgregarUsuarios.jPasswordField1.setText("");
                vAgregarUsuarios.jPasswordField2.setText("");
                } 
        }else{
            JOptionPane.showMessageDialog(vAgregarUsuarios,"No se encontro el nombre ID");
        }
    }

    @Override
    public void clickBtnAgregar(ActionEvent evt) {
        boolean esAdmin=false;
        int repetidosID=0;
        for(Usuario u : listUsuario){
            if(u.getNombre().equals(vAgregarUsuarios.txtUsuario.getText())){
                repetidosID++;
            }
        }
        if(repetidosID==0){
            if(vAgregarUsuarios.jPasswordField1.getText().equals(vAgregarUsuarios.jPasswordField2.getText())){
                if(vAgregarUsuarios.tipo.getSelectedIndex()==0){
                        esAdmin=true;
                        Usuario nuevo =new Usuario(vAgregarUsuarios.txtUsuario.getText(),
                                vAgregarUsuarios.jPasswordField1.getText(), esAdmin);    
                        //AGREGAR A LA BASE
                        if(usuarioActual.isEsAdmin()){
                            usuarioService.registrar(nuevo);
                            actualizarTabla();
                        }else{
                        JOptionPane.showMessageDialog(vAgregarUsuarios,"Usted no cuenta con los permisos necesarios");
                        }  
                        //VACIAR CAMPOS
                        vAgregarUsuarios.txtUsuario.setText("");
                        vAgregarUsuarios.jPasswordField1.setText("");
                        vAgregarUsuarios.jPasswordField2.setText("");

                }else{
                    Usuario nuevo =new Usuario(vAgregarUsuarios.txtUsuario.getText(),
                                    vAgregarUsuarios.jPasswordField1.getText(), esAdmin);    
                    //AGREGAR A LA BASE
                    if(usuarioActual.isEsAdmin()){
                            usuarioService.registrar(nuevo);
                            JOptionPane.showMessageDialog(vAgregarUsuarios,"Agregado correctamente");
                            actualizarTabla();
                    }else{
                        JOptionPane.showMessageDialog(vAgregarUsuarios,"Usted no cuenta con los permisos necesarios");
                    }  
                    //VACIAR CAMPOS
                    vAgregarUsuarios.txtUsuario.setText("");
                    vAgregarUsuarios.jPasswordField1.setText("");
                    vAgregarUsuarios.jPasswordField2.setText("");
                    
                }
            }else{
                JOptionPane.showMessageDialog(vAgregarUsuarios, "Las contraseñas no coinciden");
                vAgregarUsuarios.jPasswordField1.setText("");
                vAgregarUsuarios.jPasswordField2.setText("");
                }
        }else{
            JOptionPane.showMessageDialog(vAgregarUsuarios,"El nombre ID ya existe");
            vAgregarUsuarios.txtUsuario.setText("");
            vAgregarUsuarios.jPasswordField1.setText("");
            vAgregarUsuarios.jPasswordField2.setText("");
        }
    }

    @Override
    public void clickBtnEliminar(ActionEvent evt) {
        int indexSelect=vAgregarUsuarios.jTable1.getSelectedRow();
        String nombreEscogido=listUsuario.get(indexSelect).getNombre();
        if(usuarioActual.isEsAdmin()){
            usuarioService.eliminar(nombreEscogido);
            JOptionPane.showMessageDialog(vAgregarUsuarios,"Eliminado correctamente");
            actualizarTabla();
        }else{
            JOptionPane.showMessageDialog(vAgregarUsuarios,"Usted no cuenta con los permisos necesarios");
        }  
        actualizarTabla();
    }

    private void llenarTabla() {
        String Titulo[] = {"Nombre ID", "Tipo"};
        String registro[] = new String[2];
        DefaultTableModel modelo = new DefaultTableModel(null, Titulo) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        for (Usuario p : listUsuario) {
            registro[0] = p.getNombre();
            if(p.isEsAdmin()){
                registro[1] = "Administrador";
            }else{
                registro[1] = "Usuario";
            }
            
            modelo.addRow(registro);
        }
        vAgregarUsuarios.jTable1.setModel(modelo);
    }

    public void clickjListProductos(MouseEvent e) {
        int indSelec = vAgregarUsuarios.jTable1.getSelectedRow();
        Usuario usuarioEscogido = listUsuario.get(indSelec);
        
        vAgregarUsuarios.txtUsuario.setText(usuarioEscogido.getNombre());
        if(usuarioEscogido.isEsAdmin()){
            vAgregarUsuarios.tipo.setSelectedIndex(0);
        }else{
            vAgregarUsuarios.tipo.setSelectedIndex(1);
        }
        vAgregarUsuarios.jPasswordField1.setText(usuarioEscogido.getContrasenia());
        vAgregarUsuarios.jPasswordField2.setText(usuarioEscogido.getContrasenia());
        
        
    }
    
    public void teclaListProductos(KeyEvent e){
        int indSelec = vAgregarUsuarios.jTable1.getSelectedRow();
        Usuario usuarioEscogido = listUsuario.get(indSelec);
        
        vAgregarUsuarios.txtUsuario.setText(usuarioEscogido.getNombre());
        if(usuarioEscogido.isEsAdmin()){
            vAgregarUsuarios.tipo.setSelectedIndex(0);
        }else{
            vAgregarUsuarios.tipo.setSelectedIndex(1);
        }
        vAgregarUsuarios.jPasswordField1.setText(usuarioEscogido.getContrasenia());
        vAgregarUsuarios.jPasswordField2.setText(usuarioEscogido.getContrasenia());
        vAgregarUsuarios.BtnAgregar.setEnabled(false); 
       
    }

    private void actualizarTabla() {
        listUsuario=usuarioService.getAll();
        llenarTabla();
        
    }
}
