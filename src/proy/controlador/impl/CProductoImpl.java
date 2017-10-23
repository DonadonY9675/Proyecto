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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import proy.vista.VentanaProductos;
import proy.controlador.CProductos;
import proy.dominio.Producto;

public class CProductoImpl implements CProductos {

    VentanaProductos vProd;

    public CProductoImpl(VentanaProductos miVentanaProductos) {
        this.vProd = miVentanaProductos;
        miVentanaProductos.btnAgregar.addActionListener(this::clickBtnAgregar);
        miVentanaProductos.btnBuscar.addActionListener(this::clickBtnBuscar);
        miVentanaProductos.lstProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickLstProductos(e);
            }
        });
        actualizarJList();
    }

    public void clickBtnBuscar(ActionEvent evt) {
        System.out.println("clickbtnBuscar");
    }

    public void clickBtnAgregar(ActionEvent evt) {
        System.out.println("clickbtnAgregar");
    }

    public void clickLstProductos(MouseEvent evt) {
        System.out.println("clickListaProductos");
    }

    public void actualizarJList() {
        DefaultListModel lista = new DefaultListModel();

        for (Producto p : vProd.listaProductos) {
            lista.addElement(p.getNombre());
        }

        vProd.lstProductos.setModel(lista);

    }

}
