/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.dominio;

/**
 *
 * @author Miguel
 */
public class DetalleRegistro {

    private String codigo;
    private Producto producto;
    private double monto;
    private double cantidad;


      public DetalleRegistro(String codigo,Producto producto, double monto, double cantidad) {
        this.codigo = codigo;
        this.producto = producto;
        this.monto = monto;
        this.cantidad = cantidad;
    }
      
    public DetalleRegistro(Producto producto, double cant, double total) {
        this.cantidad = cant;
        this.producto = producto;
        this.monto = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

//    public int getCodigoProducto() {
//        return codigoProducto;
//    }
//
//    public void setCodigoProducto(int codigoProducto) {
//        this.codigoProducto = codigoProducto;
//    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleRegistro{" + "codigo=" + codigo + ", producto=" + producto + ", monto=" + monto + ", cantidad=" + cantidad + '}';
    }
    
    

}
