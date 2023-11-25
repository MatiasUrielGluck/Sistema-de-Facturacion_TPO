package dao;

import model.Factura;
import util.GenericDAO;

public class FacturaDAO extends GenericDAO<Factura> {
    public FacturaDAO(Class<Factura> clase, String file) throws Exception {
        super(clase, file);
    }
}
