/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackagedao;

import pe.unmsm.sistemaalmacen.dao.impl.ProductoDAOImpl;
import pe.unmsm.sistemaalmacen.dao.ProductoDAO;
import pe.unmsm.sistemaalmacen.dominio.EntradaSalida;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;

/**
 *
 * @author Josecarlos
 */
public class pruebaProductoDAO {
    public static void main(String[] args) {
        ListaDoble<Producto> miLista = new ListaDoble();
        ProductoDAO productoDAO = new ProductoDAOImpl();
        
        Producto prod1 = new Producto(1, "TelevisorEntrada", "LG", "HG002",
                "Unidades", "ESTAND 01", 1, 0, 730);
        Producto prod2 = new Producto(2, "LavadoraEntrada", "LG", "LV002",
                "Unidades", "ESTAND 02", 1, 5, 650);
        Producto prod3 = new Producto(3, "LaptopEntrada", "Razer", "RZ002",
                "Unidades", "ESTAND 01", 1, 0, 3000);
        Producto prod4 = new Producto(4, "Iphone 8Entrada", "Apple", "SC0001",
                "Unidades", "ESTAND 03", 1, 5, 3600);

        
        productoDAO.registrar(prod1);
        productoDAO.registrar(prod2);
        productoDAO.registrar(prod3);
        productoDAO.registrar(prod4);
    }
}
