package dao;

import model.ChequePropio;
import util.GenericDAO;

public class ChequePropioDAO extends GenericDAO<ChequePropio> {
    public ChequePropioDAO(Class<ChequePropio> clase, String file) throws Exception {
        super(clase, file);
    }
}
