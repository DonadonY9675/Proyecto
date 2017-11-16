/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import pe.unmsm.sistemaalmacen.controlador.CEditarProducto;
import pe.unmsm.sistemaalmacen.dao.impl.CategoriaDAOImpl;
import pe.unmsm.sistemaalmacen.dao.impl.ProductoDAOImpl;
import pe.unmsm.sistemaalmacen.dao.CategoriaDAO;
import pe.unmsm.sistemaalmacen.dao.ProductoDAO;
import pe.unmsm.sistemaalmacen.dominio.Categoria;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import pe.unmsm.sistemaalmacen.vista.VentanaEditarProducto;

/**
 *
 * @author Miguel
 */
public class CEditarProductoImpl implements CEditarProducto {
    private VentanaEditarProducto miVentanaEditarProducto;
    private ProductoDAO daoProducto = new ProductoDAOImpl();
    private CategoriaDAO daoCategoria = new CategoriaDAOImpl();

    @Override
    public void setVentanaEditarProducto(VentanaEditarProducto ventana) {
        
        miVentanaEditarProducto = ventana;
        miVentanaEditarProducto.BtnEditar.addActionListener(this::clickBtnEditar);
        miVentanaEditarProducto.btnExaminar.addActionListener(this::clickBtnExaminar);
        miVentanaEditarProducto.comboCategoria.addItemListener(this::clickCombo);
        
        miVentanaEditarProducto.listaCategorias = daoCategoria.getAll();
        miVentanaEditarProducto.comboCategoria.addItem("Nueva categoria");
        
        miVentanaEditarProducto.listaCategorias.stream().map(Categoria::getDescripcion)
                .forEach((c)->{miVentanaEditarProducto.comboCategoria.addItem(c);
                if(miVentanaEditarProducto.producto.getCat()!=null && 
                        c.equals(miVentanaEditarProducto.producto.getCat().getDescripcion())){
                    miVentanaEditarProducto.comboCategoria.setSelectedItem(c);
                }});
        
        if(miVentanaEditarProducto.comboCategoria.getSelectedIndex()==0){
            miVentanaEditarProducto.comboCategoria.setEditable(true);
        }else{
            miVentanaEditarProducto.comboCategoria.setEditable(false);
        }
        
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
        
        Categoria categoria = null;
        int escogido = miVentanaEditarProducto.comboCategoria.getSelectedIndex();
        System.out.println("es: "+escogido+"-"+miVentanaEditarProducto.comboCategoria.getItemAt(escogido));
        if(escogido>0){
            categoria = miVentanaEditarProducto.listaCategorias.buscar
                (miVentanaEditarProducto.comboCategoria.getItemAt(escogido),Categoria::getDescripcion);
            miVentanaEditarProducto.producto.setCat(categoria);
        }
//        else if(!miVentanaEditarProducto.comboCategoria.getItemAt(escogido).equals("Nueva categoria")){
//            categoria = new Categoria(miVentanaEditarProducto.comboCategoria.getItemCount(),
//                    miVentanaEditarProducto.comboCategoria.getItemAt(escogido));
//            
//            daoCategoria.registrar(categoria);
//        }
        
        //HABILITAR CUANDO TODOS TENGAN LA BASE DE DATOS
        if(daoProducto.modificar(miVentanaEditarProducto.producto)){
            JOptionPane.showMessageDialog(miVentanaEditarProducto,
                        "Cambios guardados exitosamente", "", JOptionPane.INFORMATION_MESSAGE);
            miVentanaEditarProducto.dispose();
        }else{
            JOptionPane.showMessageDialog(miVentanaEditarProducto,
                        "Error al modificar el producto", "Error", JOptionPane.ERROR_MESSAGE);
        }    
        
        
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
    
    @Override
    public void clickCombo(ItemEvent evt) {
        if(miVentanaEditarProducto.comboCategoria.getSelectedIndex()==0){
            miVentanaEditarProducto.comboCategoria.setEditable(true);
        }else{
            miVentanaEditarProducto.comboCategoria.setEditable(false);
        }
    }
}

