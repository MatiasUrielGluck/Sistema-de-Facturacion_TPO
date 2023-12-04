package model;

enum FormaPago{
    EFECTIVO, CHEQUE
}

public class OrdenDePago {
    private int idOrdenDePago;
    private double totalCancelar;
    private FormaPago formaPago;
    private double totalRetenciones;

    private String cuitProveedor;

    public void getDocumentosAsociados(){};

    public int getIdOrdenDePago() {
        return idOrdenDePago;
    }

    public double getTotalCancelar() {
        return totalCancelar;
    }

    public double getTotalRetenciones() {
        return totalRetenciones;
    }

    public String getCuitProveedor() { return cuitProveedor; }
}
