package model;

import java.beans.ConstructorProperties;
import java.util.Date;
import edu.Impuesto;

public class Certificado {
    private Date fechaInicio;
    private Date fechaFin;
    private Impuesto impuesto;
    private Proveedor proveedor;

    public Impuesto getImpuestoById(Impuesto impuesto) {
        return impuesto;
    }

    public Proveedor getProveedorByCuit() {
        return proveedor;
    }
}
