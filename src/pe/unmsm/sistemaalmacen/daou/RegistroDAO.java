/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unmsm.sistemaalmacen.daou;

import pe.unmsm.sistemaalmacen.dominio.Registro;

/**
 *
 * @author Josecarlos
 */
public interface RegistroDAO extends AbstractDAO<Registro, Integer>{
    
    public abstract DetalleEntradaSalidaDAO obtenerTipoDetalleDAO(int folio);
}
