package pe.unmsm.sistemaalmacen.dao.impl;

import pe.unmsm.sistemaalmacen.dao.DetalleEntradaSalidaDAO;

public class RegistroSalidaDAOImpl extends RegistroDAOImpl {
    public RegistroSalidaDAOImpl(){
        super("registrosalida","cliente");
    }

    @Override
    public DetalleEntradaSalidaDAO obtenerTipoDetalleDAO(int folio) {
        return new DetalleSalidaDAOImpl(folio);
    }
}
