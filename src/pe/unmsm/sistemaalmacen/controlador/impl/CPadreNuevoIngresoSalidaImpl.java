/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.controlador.impl;

import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import java.awt.event.ActionEvent;
import java.util.Optional;
import javax.swing.JOptionPane;
import pe.unmsm.sistemaalmacen.vista.VPadreNuevoIngresoSalida;
import pe.unmsm.sistemaalmacen.controlador.CModeloNuevoIngresoSalida;
import pe.unmsm.sistemaalmacen.dao.impl.ProductoDAOImpl;
import pe.unmsm.sistemaalmacen.dominio.DetalleRegistro;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.dominio.Registro;
import pe.unmsm.sistemaalmacen.service.ProductoService;
import pe.unmsm.sistemaalmacen.service.RegistroService;
import pe.unmsm.sistemaalmacen.service.impl.DetalleRegistroServiceImpl;
import pe.unmsm.sistemaalmacen.service.impl.ProductoServiceImpl;
import pe.unmsm.sistemaalmacen.service.impl.RegistroServiceImpl;
import pe.unmsm.sistemaalmacen.util.Utils;
import pe.unmsm.sistemaalmacen.vista.VentanaNuevaSalida;
import pe.unmsm.sistemaalmacen.vista.VentanaNuevoIngreso;
import pe.unmsm.sistemaalmacen.vista.VentanaProductos;

/**
 *
 */
public abstract class CPadreNuevoIngresoSalidaImpl implements CModeloNuevoIngresoSalida {

    VPadreNuevoIngresoSalida vIngSal;

    ListaDoble<Producto> listaProductosTabla = new ListaDoble<>();

    public void setMiModeloNuevoIngresoSalida(VPadreNuevoIngresoSalida miModeloIngSal) {
        vIngSal = miModeloIngSal; // vIngSal se encuentra el el padre

        miModeloIngSal.btnProductos.addActionListener(this::clickBtnProductos);
        miModeloIngSal.btnEliminar.addActionListener(this::clickBtnEliminar);

        miModeloIngSal.btnIncluirImpuesto.addActionListener(this::clickBtnIncluirImpuesto);
        miModeloIngSal.btnGuardar.addActionListener(this::clickBtnGuardar);
        miModeloIngSal.btnCancelar.addActionListener(this::clickBtnCancelar);
        vIngSal.txtCodigo.setText(generarCodigo());
    }

    @Override
    public void clickBtnProductos(ActionEvent evt) {
        ListaDoble<Producto> listaProductos = (new ProductoDAOImpl()).getAll();
        VentanaProductos miVentanaProducto;

        if (vIngSal instanceof VentanaNuevaSalida) {
            int cont = 0;
            for (Producto p : listaProductos) {
                if (p.getExistencia() == 0) {
                    listaProductos.eliminar(cont);
                } else {
                    cont++;
                }
            }
        }

        miVentanaProducto = new VentanaProductos(null, true, listaProductos);

        CProductoImpl coordinadorProdutos = new CProductoImpl(miVentanaProducto);
        coordinadorProdutos.setvIngSal(vIngSal);
        miVentanaProducto.setLocationRelativeTo(null);
        miVentanaProducto.setVisible(true);

    }

    @Override
    public void clickBtnEliminar(ActionEvent evt) {

        int seleccion = vIngSal.jTable.getSelectedRow();
        if (seleccion != -1) {
            vIngSal.miListaProductos.eliminar(seleccion);
            vIngSal.actualizarDatos();
        }

        if (vIngSal.miListaProductos.size() == 0) {
            vIngSal.btnGuardar.setEnabled(false);
            vIngSal.btnEliminar.setEnabled(false);
        }

    }

    @Override
    public void clickBtnIncluirImpuesto(ActionEvent evt) {
        vIngSal.calcularTotalyLlenar();
        if (vIngSal.btnIncluirImpuesto.isSelected()) {
            vIngSal.btnIncluirImpuesto.setText("Excluir impuestos");
        } else {
            vIngSal.btnIncluirImpuesto.setText("Incluir impuestos");
        }

    }

    public void clickBtnGuardar(ActionEvent evt) {
        if (!vIngSal.txtProveedor.getText().equals("")) {
            RegistroService serviceRegistro = new RegistroServiceImpl();
            DetalleRegistroServiceImpl serviceDetalleRegistro = new DetalleRegistroServiceImpl();
            vIngSal.estaGuardado = true;

            float impuesto = 0;
            if (vIngSal.txtImpuesto.getText().equals("-")) {
                impuesto = Float.parseFloat(vIngSal.txtImpuesto.getText());
            }

            Registro registro = new Registro(
                    vIngSal.txtCodigo.getText(),
                    Utils.convertirFechaAdateSQL(vIngSal.txtFecha.getText()),
                    vIngSal.txtUsuario.getText(),
                    vIngSal.txtProveedor.getText(),
                    null,
                    vIngSal.txtObservaciones.getText(),
                    Float.parseFloat(vIngSal.txtSubTotal.getText()),
                    impuesto,
                    Float.parseFloat(vIngSal.txtTotal.getText()));

            System.out.println(registro);
            vIngSal.miListaProductos.stream().forEach(r -> r.setCodigo(vIngSal.txtCodigo.getText()));
            vIngSal.miListaProductos.stream().forEach(System.out::println);
            //REGISTRO EN LA BASE DE DATOS

            serviceRegistro.registrar(registro);
            vIngSal.miListaProductos.stream().forEach(serviceDetalleRegistro::registrar);

            actualizarStockProductos();

            JOptionPane.showMessageDialog(vIngSal, "Se realizo un nuevo registro de entrada", "Guardado exitoso!!!", JOptionPane.INFORMATION_MESSAGE);
            vIngSal.dispose();
        } else {
            JOptionPane.showMessageDialog(vIngSal, "ERROR!! Debe ingresar un nombre proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            vIngSal.txtProveedor.requestFocus();
        }
    }

    private void actualizarStockProductos() {
        if (vIngSal instanceof VentanaNuevoIngreso) {
            ProductoService service = new ProductoServiceImpl();
            for (DetalleRegistro d : vIngSal.miListaProductos) {
                //consultado de la bd
                Producto prodBd = service.get(d.getProducto().getCodigo());

                d.getProducto().setExistencia(prodBd.getExistencia() + (float) d.getCantidad());
                service.modificar(d.getProducto());
            }
        }else {
            ProductoService service = new ProductoServiceImpl();
            for (DetalleRegistro d : vIngSal.miListaProductos) {
                //consultado de la bd
                Producto prodBd = service.get(d.getProducto().getCodigo());

                d.getProducto().setExistencia(prodBd.getExistencia() - (float) d.getCantidad());
                service.modificar(d.getProducto());
            }
        }
    }

    @Override
    public void clickBtnCancelar(ActionEvent evt) {

        if (vIngSal.estaGuardado || vIngSal.miListaProductos.size() == 0) {
            vIngSal.dispose();
        } else {
            int opc = JOptionPane.showConfirmDialog(vIngSal,
                    "Desea salir sin guardar los cambios", "Cancelar Registro",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (opc == 0) {
                vIngSal.dispose();
            }
        }

    }

    public String generarCodigo() {

        ListaDoble<Registro> listaRegistro = new RegistroServiceImpl().getAll();

        if (vIngSal instanceof VentanaNuevoIngreso) {
            Optional<String> max = listaRegistro.stream()
                    .map(r -> r.getCodigo())
                    .filter(c -> c.contains("RE"))
                    .max((t1, t2) -> t1.compareTo(t2));
            int valor = Integer.parseInt(max.get().substring(2)) + 1;

            return "RE" + String.format("%04d", valor);
        } else {
            Optional<String> max = listaRegistro.stream()
                    .map(r -> r.getCodigo())
                    .filter(c -> c.contains("RS"))
                    .max((t1, t2) -> t1.compareTo(t2));
            int valor = Integer.parseInt(max.get().substring(2)) + 1;

            return "RS" + String.format("%04d", valor);
        }

    }
}
