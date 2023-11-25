package dao;

import util.GenericDAO;
import model.OrdenDeCompra;

public class OrdenDeCompraDAO extends GenericDAO<OrdenDeCompra> {

    public OrdenDeCompraDAO(Class<OrdenDeCompra> clase, String file) throws Exception {
        super(clase, file);
    }
}
