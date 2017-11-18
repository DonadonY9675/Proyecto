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
import java.sql.Blob;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import pe.unmsm.sistemaalmacen.controlador.CAgregarProducto;
import pe.unmsm.sistemaalmacen.dominio.Categoria;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.service.CategoriaService;
import pe.unmsm.sistemaalmacen.service.ProductoService;
import pe.unmsm.sistemaalmacen.service.impl.CategoriaServiceImpl;
import pe.unmsm.sistemaalmacen.service.impl.ProductoServiceImpl;
import pe.unmsm.sistemaalmacen.util.Utils;
import pe.unmsm.sistemaalmacen.vista.VentanaAgregarProducto;

/**
 * @author Miguel
 */
public class CAgregarProductoImpl implements CAgregarProducto{
    private VentanaAgregarProducto miVentanaAgregarProducto;
    private ProductoService serviceProducto = new ProductoServiceImpl();
    private CategoriaService serviceCategoria = new CategoriaServiceImpl();
    
    @Override
    public void setVentanaAgregarProducto(VentanaAgregarProducto ventana) {
        miVentanaAgregarProducto = ventana;
        miVentanaAgregarProducto.BtnAgregar.addActionListener(this::clickBtnAgregar);
        miVentanaAgregarProducto.btnExaminar.addActionListener(this::clickBtnExaminar);
        
        miVentanaAgregarProducto.listaCategorias = serviceCategoria.getAll();
        
        miVentanaAgregarProducto.comboCategoria.addItem("Nueva categoria");
        miVentanaAgregarProducto.listaCategorias.stream().map(Categoria::getDescripcion)
                .forEach(miVentanaAgregarProducto.comboCategoria::addItem);
        
        miVentanaAgregarProducto.comboCategoria.addItemListener(this::clickCombo);
        miVentanaAgregarProducto.comboCategoria.setEditable(true);
    }
    
    public boolean existeCodigo(){
        return miVentanaAgregarProducto.listaProductos.stream()
                                                     .anyMatch(p->p.getCodigo()==Integer.parseInt(miVentanaAgregarProducto.txtCodigo.getText()));
            
    }
    
    @Override
    public void clickBtnAgregar(ActionEvent e) {
        int codigo=0;
        String nombre=miVentanaAgregarProducto.txtNombre.getText();
        String marca=miVentanaAgregarProducto.txtMarca.getText();
        String modelo=miVentanaAgregarProducto.txtModelo.getText();
        String unidadMedida=miVentanaAgregarProducto.txtUnidadMedida.getText();
        String ubicacion=miVentanaAgregarProducto.txtUbicacion.getText();
        float cantidadMin=(float) 0.0;
        float existencia=(float) 0.0;
        float precioUnitario=(float) 0.0;
        Icon imagen = miVentanaAgregarProducto.labelImagen.getIcon();
        Categoria categoria = null;
        
        if(!miVentanaAgregarProducto.txtCodigo.getText().isEmpty()&&!miVentanaAgregarProducto.txtCantidadMinima.getText().isEmpty()
                &&!miVentanaAgregarProducto.txtExistencia.getText().isEmpty()&&!miVentanaAgregarProducto.txtPrecioUnitario.getText().isEmpty()){
            codigo=Integer.parseInt(miVentanaAgregarProducto.txtCodigo.getText());
            cantidadMin=Float.parseFloat(miVentanaAgregarProducto.txtCantidadMinima.getText());
            existencia=Float.parseFloat(miVentanaAgregarProducto.txtExistencia.getText());
            precioUnitario=Float.parseFloat(miVentanaAgregarProducto.txtPrecioUnitario.getText());
        }
        
        if(!nombre.isEmpty()&&!modelo.isEmpty()&&!unidadMedida.isEmpty()
                &&!miVentanaAgregarProducto.txtCantidadMinima.getText().isEmpty()&&!miVentanaAgregarProducto.txtPrecioUnitario.getText().isEmpty()){
            if(!existeCodigo()){
                if(cantidadMin>=(float) 1.0){
                marca="N/A";
                ubicacion="N/A";
                int escogido = miVentanaAgregarProducto.comboCategoria.getSelectedIndex();
                if(escogido>0){
                    categoria = miVentanaAgregarProducto.listaCategorias.buscar
                        (miVentanaAgregarProducto.comboCategoria.getSelectedIndex());

                }else if(!miVentanaAgregarProducto.comboCategoria.getItemAt(escogido).equals("Nueva categoria")){
                    categoria = new Categoria(miVentanaAgregarProducto.comboCategoria.getItemCount(),
                            miVentanaAgregarProducto.comboCategoria.getItemAt(escogido));

                    serviceCategoria.registrar(categoria);
                }

                Producto nuevoProducto = new Producto(codigo, nombre, marca, modelo, categoria,
                        unidadMedida, ubicacion, cantidadMin, existencia, precioUnitario);

                miVentanaAgregarProducto.listaProductos.insertarAlFinal(nuevoProducto);
        //      HABILITAR CUANDO TODOS TENGAN LA BASE DE DATOS
                serviceProducto.registrar(nuevoProducto);
                JOptionPane.showMessageDialog(miVentanaAgregarProducto,"Producto agregado exitosamente");
                miVentanaAgregarProducto.dispose();
                }else{
                    JOptionPane.showMessageDialog(miVentanaAgregarProducto,"La cantidad minima debe ser mayor o igual a 1.");
                }
            }else{
                JOptionPane.showMessageDialog(miVentanaAgregarProducto,"El codigo del producto ya existe. Digite otro codigo de producto.");
            }
            
            
        }else{
            JOptionPane.showMessageDialog(miVentanaAgregarProducto,"Por favor, llene todos los datos marcados con '*'.");
        }
        
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
    
    @Override
    public void clickCombo(ItemEvent evt) {
            miVentanaAgregarProducto.comboCategoria.setEditable(
                    miVentanaAgregarProducto.comboCategoria.getSelectedIndex()==0);
        
    }
    
}
