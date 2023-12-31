package dto;

import model.*;

import java.util.List;

public class CuentaCorrienteDTO {

    private String nombreProveedor;

    private Double montoDeuda;

    private List<Factura> facturas;
    private List<NotaDeCredito> notasDeCredito;

    private List<NotaDeDebito> notasDeDebito;



    public CuentaCorrienteDTO(String nombreProveedor, Double montoDeuda, List<Factura> facturas, List<NotaDeCredito> notasDeCredito, List<NotaDeDebito> notasDeDebito) {
        this.nombreProveedor = nombreProveedor;
        this.montoDeuda = montoDeuda;
        this.facturas = facturas;
        this.notasDeCredito = notasDeCredito;
        this.notasDeDebito = notasDeDebito;
    }

    public String nombreProveedor() {
        return nombreProveedor;
    }

    public void nombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Double getMontoDeuda() {
        return montoDeuda;
    }

    public void setMontoDeuda(Double montoDeuda) {
        this.montoDeuda = montoDeuda;
    }

}
