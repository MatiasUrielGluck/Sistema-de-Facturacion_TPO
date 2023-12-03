package dto;

import enums.FormaPago;
import model.OrdenDePago;

import java.util.Date;

public class OrdenDePagoDTO {
    private int idOrdenDePago;

    private double totalCancelar;

    private FormaPago formaPago;

    private double totalRetenciones;

    private Date fecha;

    public OrdenDePagoDTO(OrdenDePago o) {
        this.idOrdenDePago = o.getIdOrdenDePago();
        this.totalCancelar = o.getTotalCancelar();
        this.formaPago = o.getFormaPago();
        this.totalRetenciones = o.getTotalRetenciones();
        this.fecha = o.getFecha();
    }
}