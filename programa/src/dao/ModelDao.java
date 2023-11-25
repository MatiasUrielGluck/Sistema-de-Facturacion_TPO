package dao;

import model.Model;
import util.GenericDAO;

public class ModelDao extends GenericDAO<Model> {

    public ModelDao(Class<Model> clase, String file) throws Exception {
        super(clase, file);
    }
}
