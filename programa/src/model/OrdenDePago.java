package model;
import enums.FormaPago;

import java.util.Date;

public class OrdenDePago {
    private int idOrdenDePago;
    private double totalCancelar;
    private FormaPago formaPago;
    private double totalRetenciones;
    private Date fecha;

    public void getDocumentosAsociados(){};

    public int getIdOrdenDePago() {
        return idOrdenDePago;
    }

    public double getTotalCancelar() {
        return totalCancelar;
    }

    public FormaPago getFormaPago() {return formaPago;}

    public double getTotalRetenciones() {
        return totalRetenciones;
    }
    public Date getFecha() {return fecha;}
}
