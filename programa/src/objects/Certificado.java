package objects;

import java.util.Date;

public class Certificado {
    private Date fechaInicio;
    private Date fechaFin;
    private Impuesto impuesto;
    private Proveedor proveedor;

    public Impuesto getImpuestoById() {
        return impuesto;
    }

    public Proveedor getProveedorByCuit() {
        return proveedor;
    }
}
