package pe.unmsm.sistemaalmacen.dao.impl;

import pe.unmsm.sistemaalmacen.dominio.RegistroEntrada;
import pe.unmsm.sistemaalmacen.estructuras.ListaDoble;
import java.sql.Date;
import pe.unmsm.sistemaalmacen.daou.AbstractDAO;
import pe.unmsm.sistemaalmacen.daou.RegistroEntradaDAO;
import pe.unmsm.sistemaalmacen.dominio.EntradaSalida;
import pe.unmsm.sistemaalmacen.dominio.Producto;
import pe.unmsm.sistemaalmacen.dominio.Registro;

/**
 *
 * FALTA PONER LOS PROTOTIPOS DE ESTOS METODOS EN RegistroEntradaDAO
 *
 */
public class RegistroEntradaDAOImpl implements RegistroEntradaDAO {

    @Override
    public boolean registrar(Registro e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Registro e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Registro get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaDoble<Registro> getAll() {

        //PRUEBA DE RETURN
        ListaDoble<Registro> listaRegistroEntrada = new ListaDoble();
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
        

        listaRegistroEntrada.insertarAlFinal(new RegistroEntrada(1, new Date(7,8,9), "Usuario1", "Proveedor1",  listaIngreso1,"Observacion 1",1234f, 12312.0f,123123.0f));
        
        listaIngreso2.insertarAlFinal(new EntradaSalida(prod3, 2, 5477));
        listaIngreso2.insertarAlFinal(new EntradaSalida(prod4, 13, 1331));
        listaIngreso2.insertarAlFinal(new EntradaSalida(prod1, 23, 321));
        
        listaRegistroEntrada.insertarAlFinal(new RegistroEntrada(2, new Date(10,11,12), "Administrador2", "Proveedor2",  listaIngreso2,"Observacion 2",21234f, 123.0f,3123.0f));

        return listaRegistroEntrada;

    }

    @Override
    public boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
