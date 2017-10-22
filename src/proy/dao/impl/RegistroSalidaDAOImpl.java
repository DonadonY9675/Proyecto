
package proy.dao.impl;

import proy.dominio.RegistroSalida;
import estructuras.ListaDoble;
import java.util.Date;
import proy.dao.RegistroSalidaDAO;

public class RegistroSalidaDAOImpl implements RegistroSalidaDAO {


    
    public ListaDoble<RegistroSalida> buscarPorCliente(String nombreCliente){
        //Consulta a la base de datos
        return null;
    }
    
    
    public ListaDoble<RegistroSalida> buscarPorFolio(int numFolio){
        //Consulta a la base de datos
        return null;
    }
    
    
    public ListaDoble<RegistroSalida> buscarPorUsuario(String nombreUsuario){
        //Consulta a la base de datos
        return null;
    }
    
    
    public ListaDoble<RegistroSalida> buscarPorFecha(Date fecha){
        //Consulta a la base de datos
        return null;
    }

    
    @Override
    public boolean registrar(RegistroSalida e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(RegistroSalida e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RegistroSalida get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaDoble<RegistroSalida> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}