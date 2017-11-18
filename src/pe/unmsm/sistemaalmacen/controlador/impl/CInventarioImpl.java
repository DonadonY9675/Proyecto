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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import pe.unmsm.sistemaalmacen.controlador.CAgregarProducto;
import pe.unmsm.sistemaalmacen.controlador.CEditarProducto;
import pe.unmsm.sistemaalmacen.controlador.CInventario;
import pe.unmsm.sistemaalmacen.dominio.Configuracion;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.service.ConfiguracionService;
import pe.unmsm.sistemaalmacen.service.ProductoService;
import pe.unmsm.sistemaalmacen.service.impl.ConfiguracionServiceImpl;
import pe.unmsm.sistemaalmacen.service.impl.ProductoServiceImpl;
import pe.unmsm.sistemaalmacen.vista.VentanaAgregarProducto;
import pe.unmsm.sistemaalmacen.vista.VentanaEditarProducto;
import pe.unmsm.sistemaalmacen.vista.VentanaInventario;
import pe.unmsm.sistemaalmacen.util.Utils;

/**
 *
 * @author Miguel
 */
public class CInventarioImpl implements CInventario {

    private VentanaInventario miVentanaInventario;
    private ProductoService serviceProducto = new ProductoServiceImpl();

    
    public void setVentanaInventario(VentanaInventario ventana) {
        miVentanaInventario = ventana;

        miVentanaInventario.btnMostrarTodos.addActionListener(this::clickBtnMostrarTodos);
        miVentanaInventario.btnProxAgot.addActionListener(this::clickBtnProxAgot);
        miVentanaInventario.btnAgregar.addActionListener(this::clickBtnAgregar);
        miVentanaInventario.btnEditar.addActionListener(this::clickBtnEditar);
        miVentanaInventario.btnEliminar.addActionListener(this::clickBtnEliminar);
        miVentanaInventario.btnExportar.addActionListener(this::clickBtnExportar);

        miVentanaInventario.rBtnGroup.add(miVentanaInventario.rBtnNombre);
        miVentanaInventario.rBtnGroup.add(miVentanaInventario.rBtnCodigo);

        miVentanaInventario.rBtnNombre.setSelected(true);

        miVentanaInventario.jListProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clickjListProductos(e);
            }
        });
        miVentanaInventario.jListProductos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                teclaListProductos(e);
            }
        });
        
        miVentanaInventario.txtBuscar.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                clickBtnBuscar(e) ;
            }
        });
        
        miVentanaInventario.setListProdComp(serviceProducto.getAll());
        miVentanaInventario.actualizarJListFiltrada((t)->true);
    }

    @Override
    public void clickBtnBuscar(KeyEvent e) {
        String entrada = miVentanaInventario.txtBuscar.getText();

        
        if (miVentanaInventario.rBtnNombre.isSelected()) {
            miVentanaInventario.actualizarJListFiltrada(
                    (p) -> p.getNombre().toLowerCase().contains(entrada.toLowerCase()));
        }
        if (miVentanaInventario.rBtnCodigo.isSelected()) {
            miVentanaInventario.actualizarJListFiltrada(
                    (p) -> String.valueOf(p.getCodigo()).equals(entrada));
        }

    }

    @Override
    public void clickBtnMostrarTodos(ActionEvent e) {
        miVentanaInventario.actualizarJListFiltrada((p)->true);
    }

    @Override
    public void clickBtnProxAgot(ActionEvent e) {
        miVentanaInventario.actualizarJListFiltrada(
                (t) -> t.getExistencia() <= 2*t.getCantidadMinima());
    }

    @Override
    public void clickBtnAgregar(ActionEvent e) {
        VentanaAgregarProducto vAgregarProducto = new VentanaAgregarProducto(null, true);
        vAgregarProducto.setListaDeProductos(miVentanaInventario.getListProdComp());
        CAgregarProducto cAgregarProducto = new CAgregarProductoImpl();
        cAgregarProducto.setVentanaAgregarProducto(vAgregarProducto);
        vAgregarProducto.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e){
                    miVentanaInventario.actualizarJListFiltrada((t)->true);
                }
                        });
        vAgregarProducto.setLocationRelativeTo(null);
        vAgregarProducto.setVisible(true);
    }

    @Override
    public void clickBtnEditar(ActionEvent e) {
        int indSelec = miVentanaInventario.jListProductos.getSelectedIndex();
        
        if(indSelec!=-1){
            VentanaEditarProducto vEditarProducto = new VentanaEditarProducto(null, true);
            vEditarProducto.setProducto(miVentanaInventario.obtenerProductoSeleccionado());
            CEditarProducto cEditarProducto = new CEditarProductoImpl();
            cEditarProducto.setVentanaEditarProducto(vEditarProducto);
            
            vEditarProducto.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e){
                    miVentanaInventario.actualizarJListFiltrada((t)->true);
                }
                        });

            vEditarProducto.setLocationRelativeTo(null);
            vEditarProducto.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(miVentanaInventario,
                    "Debe seleccionar un producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    @Override
    public void clickBtnEliminar(ActionEvent e) {
        int opc = JOptionPane.showConfirmDialog(miVentanaInventario,
                    "Esta seguro que desea eliminar el producto", "Eliminar producto",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opc == 0) {
            
            int indSelec = miVentanaInventario.jListProductos.getSelectedIndex();
            Producto productoElim = miVentanaInventario.obtenerProductoSeleccionado();
            
            if(serviceProducto.eliminar(productoElim.getCodigo())){
                miVentanaInventario.getListProdComp().eliminar(productoElim.getCodigo(),Producto::getCodigo);
                miVentanaInventario.actualizarJListFiltrada((t)->true);
            }else{
                System.out.println("HA OCURRIDO UN ERROR INESPERADO");
            }
        }
    }

    public void clickBtnExportar(ActionEvent e){
        String titulo = "Lista de productos";
        ConfiguracionService configuracionService = new ConfiguracionServiceImpl();
        Configuracion configuracion = configuracionService.get("");
        JTable jTable = new JTable();
        
        String Titulo[] = {"Código", "Nombre", "Marca", "Modelo","Categoria",
            "Precio Unitario", "Existencia", "Cant. min."};
        String registro[] = new String[8];
        
        DefaultTableModel modelo = new DefaultTableModel(null, Titulo) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        
        DecimalFormat df = new DecimalFormat("0.00");
        for (Producto p : miVentanaInventario.getListProdComp()) {
            registro[0] = String.valueOf(p.getCodigo());
            registro[1] = p.getNombre();
            registro[2] = p.getMarca();
            registro[3] = p.getModelo();
            registro[4] = p.getCat()!=null? p.getCat().getDescripcion() : "Sin categoria";
            registro[5] = df.format(p.getPrecioUnitario());
            registro[6] = p.getExistencia()+"";
            registro[7] = df.format(p.getCantidadMinima());
            modelo.addRow(registro);
        }
        
        jTable.setModel(modelo);
        TableRowSorter<TableModel> ordenar = new TableRowSorter<>(modelo);
        jTable.setRowSorter(ordenar);
        
        JFileChooser archivo = new JFileChooser();

        archivo.setDialogTitle("Escoger ruta donde exportar");
        File ruta = new File("C:/");

        archivo.setCurrentDirectory(ruta);

        int ventana = archivo.showOpenDialog(miVentanaInventario);

        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            Utils.createPDF(titulo, file, configuracion, jTable);
        }
    }
    
    @Override
    public void clickjListProductos(MouseEvent e) {
        miVentanaInventario.actualizarCampos();
    }
    
    public void teclaListProductos(KeyEvent e){
        miVentanaInventario.actualizarCampos();
    }
    
    
}
