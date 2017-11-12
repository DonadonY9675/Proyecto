/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackagedao;

import java.sql.Date;
import java.time.LocalDate;
import pe.unmsm.sistemaalmacen.dao.impl.DetalleEntradaSalidaDAOImpl;
import pe.unmsm.sistemaalmacen.dao.impl.RegistroEntradaDAOImpl;
import pe.unmsm.sistemaalmacen.daou.DetalleEntradaSalidaDAO;
import pe.unmsm.sistemaalmacen.dominio.EntradaSalida;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.dominio.RegistroEntrada;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;

/**
 *
 * @author Josecarlos
 */
public class pruebaRegistroEntradaDAO {
    public static void main(String[] args) {
        RegistroEntradaDAOImpl dao = new RegistroEntradaDAOImpl();
        RegistroEntrada registroEntrada = null;
        ListaDoble<EntradaSalida> listaIngreso1 = new ListaDoble();
        ListaDoble<EntradaSalida> listaIngreso2 = new ListaDoble();
        ListaDoble<Producto> miLista = new ListaDoble();
        Producto prod1 = new Producto(1, "TelevisorEntrada", "LG", "HG002",
                "Unidades", "ESTAND 01", 1, 0, 730);
        Producto prod2 = new Producto(2, "LavadoraEntrada", "LG", "LV002",
                "Unidades", "ESTAND 02", 1, 5, 650);
        Producto prod3 = new Producto(3, "LaptopEntrada", "Razer", "RZ002",
                "Unidades", "ESTAND 01", 1, 0, 3000);
        Producto prod4 = new Producto(4, "Iphone 8Entrada", "Apple", "SC0001",
                "Unidades", "ESTAND 03", 1, 5, 3600);

        listaIngreso1.insertarAlFinal(new EntradaSalida(prod1, 32, 12331));
        listaIngreso1.insertarAlFinal(new EntradaSalida(prod2, 3, 3245));
        
        registroEntrada = new RegistroEntrada(0,Date.valueOf(LocalDate.now()),"us003","sd", listaIngreso1, "ninguna", 0, 0, 0);
        
//        dao.registrar(registroEntrada);

        DetalleEntradaSalidaDAO otroDao = new DetalleEntradaSalidaDAOImpl(registroEntrada.getFolio());
        
//        otroDao.registrar(registroEntrada.getListaEntradaSalida().get(0));
        otroDao.registrar(registroEntrada.getListaEntradaSalida().get(1));
    }
}
