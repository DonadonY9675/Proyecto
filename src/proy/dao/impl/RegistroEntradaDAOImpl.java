
package proy.dao.impl;

import proy.dominio.RegistroEntrada;
import estructuras.ListaDoble;
import java.util.Date;
import proy.dao.AbstractDAO;
/**
 * 
 * FALTA PONER LOS PROTOTIPOS DE ESTOS METODOS EN RegistroEntradaDAO
 * 
*/

public class RegistroEntradaDAOImpl implements AbstractDAO {

    
    public ListaDoble<RegistroEntrada> buscarPorProveedor(String nombreProveedor){
        //Consulta a la base de datos
        return null;
    }
    
    
    public ListaDoble<RegistroEntrada> buscarPorFolio(int numFolio){
        //Consulta a la base de datos
        return null;
    }
    
    
    public ListaDoble<RegistroEntrada> buscarPorUsuario(String nombreUsuario){
        //Consulta a la base de datos
        return null;
    }
    
    
    public ListaDoble<RegistroEntrada> buscarPorFecha(Date fecha){
        //Consulta a la base de datos
        return null;
    }

    @Override
    public boolean registrar(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaDoble getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
