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

public class CProductoImpl extends CoordinadorDeCoordinadores implements CProductos {

    VentanaProductos vProd;
    VPadreNuevoIngresoSalida vIngSal;

    public void setvIngSal(VPadreNuevoIngresoSalida vIngSal) {
        this.vIngSal = vIngSal;
    }

    public CProductoImpl(VentanaProductos miVentanaProductos) {
        this.vProd = miVentanaProductos;
        miVentanaProductos.btnAgregar.addActionListener(this::clickBtnAgregar);
        miVentanaProductos.btnBuscar.addActionListener(this::clickBtnBuscar);
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
        });
        actualizarJList();
    }

    //falta culminar con las validaciones de errores
    public void ingresarCantidad(KeyEvent evt) {
        if (evt.getKeyChar() >= 48 && evt.getKeyChar() <= 57) {
            Double precio = Double.parseDouble(vProd.txtPrecio.getText());
            int cant = Integer.parseInt(vProd.txtCantidad.getText());
            vProd.txtTotal.setText(Math.rint(precio * cant * 100) / 100 + "");
        } else {
            evt.consume();
        }
    }

    public void clickBtnBuscar(ActionEvent evt) {
        System.out.println("clickbtnBuscar");

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
        vProd.dispose();
    }

    public void clickLstProductos(MouseEvent evt) {
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
    }

}
