
package pe.unmsm.sistemaalmacen.dominio;

import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;

public class Inventario {
    ListaDoble<Producto> inventario = new ListaDoble<>();
    
    public Inventario(){
        inventario=null;
    }
    
    public void agregarProducto(Producto p){
        inventario.insertarAlInicio(p);
    }
    
    public void eliminarProducto(int codigo){
        inventario.eliminar(codigo);
    }
    
    public Producto buscar(int pos){
        Producto p = null;
        return p;
    }
    public void reemplazaProducto(Producto p, int cod){
        Producto temp=buscar(cod);
        //Reemplazamos p en lapodicion de temp
    }
    
}
