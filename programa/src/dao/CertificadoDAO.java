package dao;

import model.Certificado;
import util.GenericDAO;

public class CertificadoDAO extends GenericDAO<Certificado> {
    public CertificadoDAO(Class<Certificado> clase, String file) throws Exception {
        super(clase, file);
    }
}
