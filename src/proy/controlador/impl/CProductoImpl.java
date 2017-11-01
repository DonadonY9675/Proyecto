/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.controlador.impl;

/**
 *
 * @author Miguel
 */
import estructuras.ListaDoble;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import proy.vista.VentanaProductos;
import proy.controlador.CProductos;
import proy.dominio.Producto;
import proy.dominio.EntradaSalida;
import proy.vista.VPadreNuevoIngresoSalida;

public class CProductoImpl implements CProductos {

    VentanaProductos vProd;
    VPadreNuevoIngresoSalida vIngSal;

    public void setvIngSal(VPadreNuevoIngresoSalida vIngSal) {
        this.vIngSal = vIngSal;
    }

    public CProductoImpl(VentanaProductos miVentanaProductos) {
        this.vProd = miVentanaProductos;
        miVentanaProductos.btnAgregar.addActionListener(this::clickBtnAgregar);
        miVentanaProductos.btnLimpiar.addActionListener(this::clickBtnLimpiar);
        miVentanaProductos.lstProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clickLstProductos(e);
            }
        });

        miVentanaProductos.txtCantidad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ingresarCantidad(e);
            }

            @Override
            public void keyTyped(KeyEvent e) {
                verificarSoloNumeros(e);
            }
        });
        miVentanaProductos.txtBuscar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e){
                clickTxtBuscar(e);
            }
        });
        
        miVentanaProductos.txtBuscar.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                clickBtnBuscar(e) ;
            }
        });
        
        

        iniciarComponentes();
    }

    public void iniciarComponentes() {
        actualizarJList();
        vProd.txtBuscar.selectAll();

    }

    public void clickTxtBuscar(MouseEvent e){
        vProd.txtBuscar.selectAll();
    }
    //falta culminar con las validaciones de errores
    public void ingresarCantidad(KeyEvent evt) {

        if (!vProd.txtCantidad.getText().equals("")) {
            double precio = Double.parseDouble(vProd.txtPrecio.getText());
            int cant = Integer.parseInt(vProd.txtCantidad.getText());
            vProd.txtTotal.setText(Math.rint(precio * cant * 100) / 100 + "");
            if (!vProd.txtCantidad.getText().equals("0")) {
                vProd.btnAgregar.setEnabled(true);
            }
        } else {
            vProd.txtTotal.setText(null);
            vProd.btnAgregar.setEnabled(false);
        }

    }

    public void verificarSoloNumeros(KeyEvent e) {
        if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
            e.consume();
        }
    }

    public void clickBtnBuscar(KeyEvent evt) {
        String prodBuscado = vProd.txtBuscar.getText();
        vProd.listaProductos = vProd.listaProductosCompleta; 
        if (!prodBuscado.equals("")) {
            ListaDoble<Producto> prodEncontrados = new ListaDoble();
            DefaultListModel lista = new DefaultListModel();
            for (Producto p : vProd.listaProductos) {
                if (p.getNombre().toLowerCase().contains(prodBuscado.toLowerCase())) {
                    lista.addElement(p.getNombre());
                    prodEncontrados.insertarAlFinal(p);
                }
            }
            vProd.lstProductos.setModel(lista);
            vProd.listaProductos = prodEncontrados;
        } 
        actualizarJList();
    }

    public void clickBtnLimpiar(ActionEvent evt) {
        vProd.txtBuscar.setText(null);
        vProd.btnBuscar.doClick();
    }

    public void clickBtnAgregar(ActionEvent evt) {
        Producto prodSelec = vProd.listaProductos.get(vProd.lstProductos.getSelectedIndex());
        int cant = Integer.parseInt(vProd.txtCantidad.getText());
        double total = Double.parseDouble(vProd.txtTotal.getText());

        //validando si ya existe algun producto en la listaProducto
        boolean existe = false;
        for (EntradaSalida p : vIngSal.miListaProductos) {
            if (p.getProducto().getCodigo() == prodSelec.getCodigo()) {
                p.setCant(p.getCantidad() + cant);
                p.setTotal(p.getTotal() + total);
                existe = true;
                break;
            }
        }

        if (!existe) {
            vIngSal.miListaProductos.insertarAlInicio(
                    new EntradaSalida(prodSelec, cant, total));
        }
        vIngSal.actualizarDatos();
        
        //cada vez que se actualiza se activa el jButton en caso este desactivado;
        vIngSal.btnGuardar.setEnabled(true);
        vIngSal.btnEliminar.setEnabled(true);
        
        vProd.dispose();
        
    }

    public void clickLstProductos(MouseEvent evt) {
        actualizarDatosConElementoSeleccionado();
        vProd.txtCantidad.setText(null);
        vProd.txtTotal.setText(null);
        vProd.txtCantidad.requestFocus();
    }

    public void actualizarDatosConElementoSeleccionado() {
        int indSelec = vProd.lstProductos.getSelectedIndex();
        vProd.txtProducto.setText(vProd.listaProductos.get(indSelec).getNombre());
        vProd.txtCodigo.setText(vProd.listaProductos.get(indSelec).getCodigo() + "");
        vProd.txtMarca.setText(vProd.listaProductos.get(indSelec).getMarca());
        vProd.txtModelo.setText(vProd.listaProductos.get(indSelec).getModelo());
        vProd.txtExistencia.setText(vProd.listaProductos.get(indSelec).getExistencia() + "");
        vProd.txtPrecio.setText(vProd.listaProductos.get(indSelec).getPrecioUnitario() + "");
    }

    public void actualizarJList() {
        DefaultListModel lista = new DefaultListModel();
        for (Producto p : vProd.listaProductos) {
            lista.addElement(p.getNombre());
        }
        vProd.lstProductos.setModel(lista);
        if (vProd.listaProductos.size() != 0) {
            vProd.lstProductos.setSelectedIndex(0);
            actualizarDatosConElementoSeleccionado();
        }
    }

}
