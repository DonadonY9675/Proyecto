/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proy.dao.impl;

import estructuras.ListaDoble;
import java.net.URL;
import proy.dao.ConfiguracionDAO;
import proy.dominio.Configuracion;
import proy.dominio.Producto;
import proy.vista.VentanaMenuPrincipal;

/**
 *
 * @author Miguel
 */
public class ConfiguracionDAOImpl implements ConfiguracionDAO{
    
    //esta clase solo necesita MODIFICAR y cargar
    
    @Override
    public boolean modificar(Configuracion elem) {
        //Logica de actualizacion en BD
        //UPDATE
        return true;

    }
    
    //solo habrá una configuracion con ID = 1
    @Override
    public Configuracion get(Integer ID) {
        
        
        //Logica de buscar por ID
        //SELECT
        //WHERE ID = ELEM
        
        //ELIMINAR ESTE RETURN, SOLO SE UTILIZA PARA PROBAR LA CARGA INICIAL(EN EL MAIN)
        URL url = getClass().getResource("/proy/images/logo.png");  
        System.out.println(url.toExternalForm().replace("file:/", "")); // = C:/Users/... 
        return new Configuracion(url.toExternalForm().replace("file:/", ""),"UNSMS", "123456789012", "Av. Universitaria /Calle Germán Amézaga 375. Edificio Jorge Basadre Ciudad Universitaria", 0.18);
//        return null;
    }

    
    //El resto de metodos NO es necesario implementarlos
    @Override
    public boolean registrar(Configuracion e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaDoble<Configuracion> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
