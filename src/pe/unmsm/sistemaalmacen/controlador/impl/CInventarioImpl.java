/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import pe.unmsm.sistemaalmacen.controlador.CInventario;
import pe.unmsm.sistemaalmacen.daou.ProductoDAO;
import pe.unmsm.sistemaalmacen.dao.impl.ProductoDAOImpl;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.vista.VentanaAgregarProducto;
import pe.unmsm.sistemaalmacen.vista.VentanaEditarProducto;
import pe.unmsm.sistemaalmacen.vista.VentanaInventario;

/**
 *
 * @author Miguel
 */
public class CInventarioImpl implements CInventario {

    private VentanaInventario miVentanaInventario;
    private ProductoDAO daoProducto = new ProductoDAOImpl();

    //listProdComp cargara la informacion de todos los productos almacenados en
    //la base de datos
    private ListaDoble<Producto> listProdComp = new ListaDoble<>();
    //Sin embargo es  la listProdFilt, que es una sublista filtrada de la
    //original, la unica que se mostrara  al usuario
    private ListaDoble<Producto> listProdFilt;

    public void setVentanaInventario(VentanaInventario ventana) {
        miVentanaInventario = ventana;

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
        
        miVentanaInventario.txtBuscar.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                clickBtnBuscar(e) ;
            }
        });
        
        listProdComp = daoProducto.getAll();
        //Al iniciar no hay filtros por lo que ambas listas se hacen iguales
        listProdFilt = listProdComp;
        actualizarJList();
    }

    @Override
    public void actualizarJList() {
        DefaultListModel lista = new DefaultListModel();
        for (Producto p : listProdFilt) {
            lista.addElement(p.getNombre());
        }
        miVentanaInventario.jListProductos.setModel(lista);
    }

    @Override
    public void clickBtnBuscar(KeyEvent e) {
        String entrada = miVentanaInventario.txtBuscar.getText();

        if (miVentanaInventario.rBtnNombre.isSelected()) {
            listProdFilt = listProdComp.filtrar(
                    (t) -> t.getNombre().toLowerCase().contains(entrada.toLowerCase()));
        }
        if (miVentanaInventario.rBtnCodigo.isSelected()) {
            listProdFilt = listProdComp.filtrar(
                    (t) -> String.valueOf(t.getCodigo()).equals(entrada));
        }

        actualizarJList();
    }

    @Override
    public void clickBtnMostrarTodos(ActionEvent e) {
        listProdFilt = listProdComp;
        actualizarJList();
    }

    @Override
    public void clickBtnProxAgot(ActionEvent e) {
        listProdFilt = listProdComp.filtrar(
                (t) -> t.getExistencia() <= 2*t.getCantidadMinima());
        actualizarJList();
    }

    @Override
    public void clickBtnAgregar(ActionEvent e) {
        VentanaAgregarProducto vAgregarProducto = new VentanaAgregarProducto(null, true);
        vAgregarProducto.setLocationRelativeTo(null);
        vAgregarProducto.setVisible(true);
    }

    @Override
    public void clickBtnEditar(ActionEvent e) {
        VentanaEditarProducto vEditarProducto = new VentanaEditarProducto(null, true);
        vEditarProducto.setLocationRelativeTo(null);
        vEditarProducto.setVisible(true);
    }

    @Override
    public void clickBtnEliminar(ActionEvent e) {
        int opc = JOptionPane.showConfirmDialog(miVentanaInventario,
                    "Esta seguro que desea eliminar el producto", "Eliminar producto",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opc == 0) {
            
            int indSelec = miVentanaInventario.jListProductos.getSelectedIndex();
            listProdFilt.eliminar(indSelec);
            
            actualizarJList();
        }
    }

    @Override
    public void clickjListProductos(MouseEvent e) {
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
        miVentanaInventario.txtCantMin.setText(producEscogido.getCantidadMinima() + "");

    }
}
