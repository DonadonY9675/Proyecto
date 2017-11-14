/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import pe.unmsm.sistemaalmacen.controlador.CAgregarProducto;
import pe.unmsm.sistemaalmacen.dao.impl.ProductoDAOImpl;
import pe.unmsm.sistemaalmacen.daou.ProductoDAO;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.vista.VentanaAgregarProducto;

/**
 *
 * @author Miguel
 */
public class CAgregarProductoImpl implements CAgregarProducto{
    private VentanaAgregarProducto miVentanaAgregarProducto;
    private ProductoDAO daoProducto = new ProductoDAOImpl();

    @Override
    public void setVentanaAgregarProducto(VentanaAgregarProducto ventana) {
        miVentanaAgregarProducto = ventana;
        miVentanaAgregarProducto.BtnAgregar.addActionListener(this::clickBtnAgregar);
        miVentanaAgregarProducto.btnExaminar.addActionListener(this::clickBtnExaminar);
    }

    @Override
    public void clickBtnAgregar(ActionEvent e) {
        
        int codigo=Integer.parseInt(miVentanaAgregarProducto.txtCodigo.getText());
        String nombre=miVentanaAgregarProducto.txtNombre.getText();
        String marca=miVentanaAgregarProducto.txtMarca.getText();
        String modelo=miVentanaAgregarProducto.txtModelo.getText();
        String unidadMedida=miVentanaAgregarProducto.txtUnidadMedida.getText();
        String ubicacion=miVentanaAgregarProducto.txtUnidadMedida.getText();
        float cantidadMin=Float.parseFloat(miVentanaAgregarProducto.txtCantidadMinima.getText());
        float existencia=Float.parseFloat(miVentanaAgregarProducto.txtExistencia.getText());
        float precioUnitario=Float.parseFloat(miVentanaAgregarProducto.txtPrecioUnitario.getText());
        Icon imagen = miVentanaAgregarProducto.labelImagen.getIcon();
//        
        Producto nuevoProducto = new Producto(codigo, nombre, marca, modelo, unidadMedida, ubicacion, cantidadMin, existencia, precioUnitario);
        
        miVentanaAgregarProducto.listaProductos.insertarAlFinal(nuevoProducto);
//      HABILITAR CUANDO TODOS TENGAN LA BASE DE DATOS
//        daoProducto.registrar(nuevoProducto);
        JOptionPane.showMessageDialog(miVentanaAgregarProducto,"Producto agregado exitosamente");
        //ACTUALIZAR LISTA 
//        miVentanaAgregarProducto.listaProductos = daoProducto.getAll();
        
        miVentanaAgregarProducto.dispose();
    } 
    
    @Override
    public void clickBtnExaminar(ActionEvent evt) {
        System.out.println("ACCIONANDO");
        FileNameExtensionFilter filtro
                = new FileNameExtensionFilter("Formatos de Archivos JPEG(*.JPG;*.JPEG; .png)",
                        "jpg", "jpeg", "png");

        JFileChooser archivo = new JFileChooser();

        archivo.addChoosableFileFilter(filtro);
        archivo.setFileFilter(filtro);
        archivo.setDialogTitle("Escoger imagen de producto");
        File ruta = new File("C:/");

        archivo.setCurrentDirectory(ruta);

        int ventana = archivo.showOpenDialog(miVentanaAgregarProducto);

        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            String cadenaRuta = String.valueOf(file);
            Image imagen = miVentanaAgregarProducto.getToolkit().getImage(cadenaRuta);
            imagen = imagen.getScaledInstance(240, 240, Image.SCALE_DEFAULT);
            
            miVentanaAgregarProducto.labelImagen.setIcon(new ImageIcon(imagen));
        }

    }
}
