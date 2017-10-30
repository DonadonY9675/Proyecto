package proy.dao.impl;

import proy.dominio.RegistroSalida;
import estructuras.ListaDoble;
import java.util.Date;
import proy.dao.RegistroSalidaDAO;
import proy.dominio.EntradaSalida;
import proy.dominio.Producto;
import proy.dominio.Registro;
import proy.dominio.RegistroEntrada;

public class RegistroSalidaDAOImpl implements RegistroSalidaDAO {

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
        ListaDoble<Registro> SalidaEntrada = new ListaDoble();
        ListaDoble<EntradaSalida> listaSalida = new ListaDoble();

        Producto prod1 = new Producto(1, "TelevisorSalida", "LG", "HG002",
                "Unidades", "ESTAND 01", 1, 0, 730);
        Producto prod2 = new Producto(2, "LavadoraSalida", "LG", "LV002",
                "Unidades", "ESTAND 02", 1, 5, 650);
        Producto prod3 = new Producto(3, "LaptopSalida", "Razer", "RZ002",
                "Unidades", "ESTAND 01", 1, 0, 3000);
        Producto prod4 = new Producto(4, "Iphone 8-salida", "Apple", "SC0001",
                "Unidades", "ESTAND 03", 1, 5, 3600);

        //listaSalida se obtiene consultando en IngresoSalidaDAO todos los IngresoSalida que tiene codigo = RegistroSalida.folio
        listaSalida.insertarAlFinal(new EntradaSalida(prod1, 32, 12331));
        listaSalida.insertarAlFinal(new EntradaSalida(prod2, 3, 3245));

        SalidaEntrada.insertarAlFinal(new RegistroEntrada(1, null, "Usuario1", "Cliente1",listaSalida,"Observacion 1", 1234f,  12312.0f, 123123.0f));

        ListaDoble<EntradaSalida> listaSalida2 = new ListaDoble();
        listaSalida2.insertarAlFinal(new EntradaSalida(prod1, 2, 5477));
        listaSalida2.insertarAlFinal(new EntradaSalida(prod2, 13, 1331));
        listaSalida2.insertarAlFinal(new EntradaSalida(prod3, 2, 5477));
        listaSalida2.insertarAlFinal(new EntradaSalida(prod4, 13, 1331));

        SalidaEntrada.insertarAlFinal(new RegistroEntrada(2, null, "Administrador2", "Cliente2",listaSalida2,"Observacion 2", 221234f,  123.0f, 3123.0f));

        return SalidaEntrada;
    }

    @Override
    public boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
