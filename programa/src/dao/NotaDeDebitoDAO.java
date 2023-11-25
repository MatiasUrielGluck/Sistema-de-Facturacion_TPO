package dao;

import model.NotaDeDebito;
import util.GenericDAO;

public class NotaDeDebitoDAO extends GenericDAO<NotaDeDebito> {
    public NotaDeDebitoDAO(Class<NotaDeDebito> clase, String file) throws Exception {
        super(clase, file);
    }
}
