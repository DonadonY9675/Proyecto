/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import pe.unmsm.sistemaalmacen.controlador.CEditarProducto;
import pe.unmsm.sistemaalmacen.dao.impl.ProductoDAOImpl;
import pe.unmsm.sistemaalmacen.daou.ProductoDAO;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.vista.VentanaEditarProducto;

/**
 *
 * @author Miguel
 */
public class CEditarProductoImpl implements CEditarProducto {
    private VentanaEditarProducto miVentanaEditarProducto;
    private ProductoDAO daoProducto = new ProductoDAOImpl();
    
    @Override
    public void setVentanaEditarProducto(VentanaEditarProducto ventana) {
        
        miVentanaEditarProducto = ventana;
        miVentanaEditarProducto.BtnEditar.addActionListener(this::clickBtnEditar);
        miVentanaEditarProducto.btnExaminar.addActionListener(this::clickBtnExaminar);
        //Al iniciar no hay filtros por lo que ambas listas se hacen iguales
    }
    
    @Override
    public void clickBtnEditar(ActionEvent e) {
        miVentanaEditarProducto.producto.setNombre(miVentanaEditarProducto.txtNombre.getText());
        miVentanaEditarProducto.producto.setMarca(miVentanaEditarProducto.txtMarca.getText());
        miVentanaEditarProducto.producto.setModelo(miVentanaEditarProducto.txtModelo.getText());
        miVentanaEditarProducto.producto.setUbicacion(miVentanaEditarProducto.txtUbicacion.getText());
        miVentanaEditarProducto.producto.setUnidadDeMedida(miVentanaEditarProducto.txtUnidadMedida.getText());
        miVentanaEditarProducto.producto.setCantidadMinima(Float.parseFloat(miVentanaEditarProducto.txtCantidadMin.getText()));
        miVentanaEditarProducto.producto.setExistencia(Float.parseFloat(miVentanaEditarProducto.txtExistencia.getText()));
        miVentanaEditarProducto.producto.setPrecioUnitario(Float.parseFloat(miVentanaEditarProducto.txtPrecioUnit.getText()));
        
        //HABILITAR CUANDO TODOS TENGAN LA BASE DE DATOS
//        daoProducto.modificar(miVentanaEditarProducto.producto);
        
        JOptionPane.showMessageDialog(miVentanaEditarProducto,
                    "Cambios guardados exitosamente", "", JOptionPane.INFORMATION_MESSAGE);
        
        miVentanaEditarProducto.dispose();
    }
    
    @Override
    public void clickBtnExaminar(ActionEvent evt) {

        FileNameExtensionFilter filtro
                = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG; .png)",
                        "jpg", "jpeg", "png");

        JFileChooser archivo = new JFileChooser();

        archivo.addChoosableFileFilter(filtro);
        archivo.setFileFilter(filtro);
        archivo.setDialogTitle("Escoger imagen de producto");
        File ruta = new File("C:/");

        archivo.setCurrentDirectory(ruta);

        int ventana = archivo.showOpenDialog(miVentanaEditarProducto);

        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            String cadenaRuta = String.valueOf(file);
            Image logo = miVentanaEditarProducto.getToolkit().getImage(cadenaRuta);
            logo = logo.getScaledInstance(240, 240, Image.SCALE_DEFAULT);
            miVentanaEditarProducto.labelImagen.setIcon(new ImageIcon(logo));
        }

    }
}

