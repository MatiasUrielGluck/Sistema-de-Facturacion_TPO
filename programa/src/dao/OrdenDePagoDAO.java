package dao;

import model.OrdenDePago;
import util.GenericDAO;

public class OrdenDePagoDAO extends GenericDAO<OrdenDePago> {
    public OrdenDePagoDAO(Class<OrdenDePago> clase, String file) throws Exception {
        super(clase, file);
    }
}
