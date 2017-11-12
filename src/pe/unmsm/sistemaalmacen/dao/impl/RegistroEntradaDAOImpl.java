package pe.unmsm.sistemaalmacen.dao.impl;

import pe.unmsm.sistemaalmacen.daou.DetalleEntradaSalidaDAO;

public class RegistroEntradaDAOImpl extends RegistroDAOImpl {
    public RegistroEntradaDAOImpl(){
        super("registroentrada","proveedor");
    }

    @Override
    public DetalleEntradaSalidaDAO obtenerDetalleDAO(int folio) {
        return new DetalleEntradaDAOImpl(folio);
    }
}
