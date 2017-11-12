package pe.unmsm.sistemaalmacen.dao.impl;

import pe.unmsm.sistemaalmacen.daou.DetalleEntradaSalidaDAO;

public class RegistroSalidaDAOImpl extends RegistroDAOImpl {
    public RegistroSalidaDAOImpl(){
        super("registrosalida","cliente");
    }

    @Override
    public DetalleEntradaSalidaDAO obtenerDetalleDAO(int folio) {
        return new DetalleSalidaDAOImpl(folio);
    }
}
