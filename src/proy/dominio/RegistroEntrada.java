/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.dominio;

import estructuras.ListaDoble;
import java.util.Date;

/**
 *
 * @author Miguel
 */
public class RegistroEntrada extends Registro{
    private String proveedor;

    public RegistroEntrada( int folio, Date fecha, String ususario,String proveedor, ListaDoble<EntradaSalida> listaProductos, String observaciones, float subTotal, float impuestos, float total) {
        super(folio, fecha, ususario, listaProductos, observaciones, subTotal, impuestos, total);
        this.proveedor = proveedor;
    }
    
  

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    
}
