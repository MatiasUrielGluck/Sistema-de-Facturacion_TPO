package dao;

import model.Proveedor;
import util.GenericDAO;

public class ProveedorDAO extends GenericDAO<Proveedor> {

    public ProveedorDAO(Class<Proveedor> clase, String file) throws Exception {
        super(clase, file);
    }
}
