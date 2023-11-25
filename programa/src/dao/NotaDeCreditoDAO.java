package dao;

import model.NotaDeCredito;
import util.GenericDAO;

public class NotaDeCreditoDAO extends GenericDAO<NotaDeCredito> {
    public NotaDeCreditoDAO(Class<NotaDeCredito> clase, String file) throws Exception {
        super(clase, file);
    }
}
