package dao;

import model.ChequeTerceros;
import util.GenericDAO;

public class ChequeTerceroDAO extends GenericDAO<ChequeTerceros> {
    public ChequeTerceroDAO(Class<ChequeTerceros> clase, String file) throws Exception {
        super(clase, file);
    }
}
