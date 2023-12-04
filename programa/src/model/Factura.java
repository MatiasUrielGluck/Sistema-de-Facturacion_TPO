package model;

import java.util.Collection;
import java.util.Date;
import edu.Impuesto;

public class Factura extends Documento {
    private Collection<Impuesto> impuestos;
    private Date fecha;
    private Collection<DetalleFactura> detalles;

    private String cuitProveedor;

    @Override
    public int getCuit() {
        return super.getCuit();
    }

    @Override
    public Boolean getEstaPago() {
        return super.getEstaPago();
    }

    public Collection<DetalleFactura> getDetalles() {
        return detalles;
    }

    public Collection<Impuesto> getImpuestos() {
        return impuestos;
    }

    @Override
    public double getMonto() {
        return super.getMonto();
    }

    public Date getFecha() {
        return fecha;
    }

    public String getCuitProveedor() {
        return cuitProveedor;
    }

    public void getOrdenDeCompraById(){

    };
}
