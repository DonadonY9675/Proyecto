/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackagedao;

import pe.unmsm.sistemaalmacen.dominio.Configuracion;
import java.net.URL;
import pe.unmsm.sistemaalmacen.dao.impl.CategoriaDAOImpl;
import pe.unmsm.sistemaalmacen.dao.impl.ConfiguracionDAOImpl;
/**
 *
 * @author Josecarlos
 */
public class pruebaConfiguracionDAO {
        URL url = getClass().getResource("/proy/images/logo.png");
        String logo = url.toExternalForm().replace("file:/", "");
        
    public static void main(String[] args) {
        pruebaConfiguracionDAO prueba= new pruebaConfiguracionDAO();
//        System.out.println(url.toExternalForm().replace("file:/", "")); // = C:/Users/... 
//        return 
        Configuracion config = new Configuracion(prueba.logo,"UNSMS", "123456789012", "Av. Universitaria /Calle Germán Amézaga 375. Edificio Jorge Basadre Ciudad Universitaria", 0.18);
        System.out.println(prueba.logo.length());
        ConfiguracionDAOImpl dao = new ConfiguracionDAOImpl();
        
        dao.registrar(config);
        
//        return null;
    }
}
