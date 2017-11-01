/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador.impl;


import estructuras.ListaDoble;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Predicate;
import javax.swing.DefaultListModel;
import proy.controlador.CInventario;
import proy.dao.ProductoDAO;
import proy.dao.impl.ProductoDAOImpl;
import proy.dominio.Producto;
import proy.vista.VentanaAgregarProducto;
import proy.vista.VentanaEditarProducto;
import proy.vista.VentanaInventario;


/**
 *
 * @author Miguel
 */
public class CInventarioImpl implements CInventario{
    
    private VentanaInventario miVentanaInventario;
    private ProductoDAO daoProducto = new ProductoDAOImpl();
    
    //listProdComp cargara la informacion de todos los productos almacenados en
    //la base de datos
    private ListaDoble<Producto> listProdComp = new ListaDoble<>();
    //Sin embargo es  la listProdFilt, que es una sublista filtrada de la
    //original, la unica que se mostrara  al usuario
    private ListaDoble<Producto> listProdFilt;
    
    public void setVentanaInventario(VentanaInventario ventana){
        miVentanaInventario = ventana;
        
        miVentanaInventario.btnBuscar.addActionListener(this::clickBtnBuscar);
        miVentanaInventario.btnMostrarTodos.addActionListener(this::clickBtnMostrarTodos);
        miVentanaInventario.btnProxAgot.addActionListener(this::clickBtnProxAgot);
        miVentanaInventario.btnAgregar.addActionListener(this::clickBtnAgregar);
        miVentanaInventario.btnEditar.addActionListener(this::clickBtnEditar);
        miVentanaInventario.btnEliminar.addActionListener(this::clickBtnEliminar);
        
        miVentanaInventario.rBtnGroup.add(miVentanaInventario.rBtnNombre);
        miVentanaInventario.rBtnGroup.add(miVentanaInventario.rBtnCodigo);
        
        miVentanaInventario.rBtnNombre.setSelected(true);

        miVentanaInventario.jListProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clickjListProductos(e);
            }
        });
        
        //EL usuario no padra modificar ningun textfield
        miVentanaInventario.txtProducto.setEditable(false);
        miVentanaInventario.txtCodigo.setEditable(false);
        miVentanaInventario.txtMarca.setEditable(false);
        miVentanaInventario.txtModelo.setEditable(false);
        miVentanaInventario.txtExist.setEditable(false);
        miVentanaInventario.txtPrecUnit.setEditable(false);
        miVentanaInventario.txtUnidMed.setEditable(false);
        miVentanaInventario.txtUbicacion.setEditable(false);
        miVentanaInventario.txtCantMin.setEditable(false);
        miVentanaInventario.txtCategoria.setEditable(false);
        
        listProdComp = daoProducto.getAll();
        //Al iniciar no hay filtros por lo que ambas listas se hacen iguales
        listProdFilt = listProdComp;
        actualizarJList();
    }
    
    public void actualizarJList() {
        DefaultListModel lista = new DefaultListModel();
        for (Producto p : listProdFilt) {
            lista.addElement(p.getNombre());
        }
        miVentanaInventario.jListProductos.setModel(lista);
    }
    
    public void clickBtnBuscar(ActionEvent e){
        String entrada = miVentanaInventario.txtBuscar.getText();
        
        if(miVentanaInventario.rBtnNombre.isSelected()){
            listProdFilt = listProdComp.filtrar(
                    (t)->t.getNombre().contains(entrada));
        }
        if(miVentanaInventario.rBtnCodigo.isSelected()){
            listProdFilt = listProdComp.filtrar(
                    (t)->String.valueOf(t.getCodigo()).equals(entrada));
        }
        
        actualizarJList();
    }
    
    public void clickBtnMostrarTodos(ActionEvent e){
        listProdFilt = listProdComp;
        actualizarJList();
    }
    
    public void clickBtnProxAgot(ActionEvent e){
        //MEJORAR PREDICADO, IDEAS??
        listProdFilt = listProdComp.filtrar(
                (t)->t.getExistencia()<=t.getCantidadMinima());
        actualizarJList();
    }
    
    public void clickBtnAgregar(ActionEvent e){
        VentanaAgregarProducto vAgregarProducto = new VentanaAgregarProducto(null,true);
        vAgregarProducto.setLocationRelativeTo(null);
        vAgregarProducto.setVisible(true);
    }
    public void clickBtnEditar(ActionEvent e){
        VentanaEditarProducto   vEditarProducto = new VentanaEditarProducto(null,true);
        vEditarProducto.setLocationRelativeTo(null);
        vEditarProducto.setVisible(true);
    }
    public void clickBtnEliminar(ActionEvent e){
        
    }
    
    public void clickjListProductos(MouseEvent e){
        int indSelec = miVentanaInventario.jListProductos.getSelectedIndex();
        Producto producEscogido = listProdFilt.get(indSelec);
        
        miVentanaInventario.txtProducto.setText(producEscogido.getNombre());
        miVentanaInventario.txtCodigo.setText(producEscogido.getCodigo() + "");
        miVentanaInventario.txtMarca.setText(producEscogido.getMarca());
        miVentanaInventario.txtModelo.setText(producEscogido.getModelo());
        miVentanaInventario.txtExist.setText(producEscogido.getExistencia() + "");
        miVentanaInventario.txtPrecUnit.setText(producEscogido.getPrecioUnitario() + "");
        miVentanaInventario.txtUnidMed.setText(producEscogido.getUnidadDeMedida());
        miVentanaInventario.txtUbicacion.setText(producEscogido.getUbicacion());
        miVentanaInventario.txtCantMin.setText(producEscogido.getCantidadMinima()+"");
        
    }
}
