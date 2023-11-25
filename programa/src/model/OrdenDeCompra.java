package model;

import java.util.Collection;

public class OrdenDeCompra {
    private String idOrdenDeCompra;
    private Collection<LineaOrden> detalles;

    public OrdenDeCompra(String idOrdenDeCompra, Collection<LineaOrden> detalles) {
        this.idOrdenDeCompra = idOrdenDeCompra;
        this.detalles = detalles;
    }
    public void setIdOrdenDeCompra(String idOrdenDeCompra) {
        this.idOrdenDeCompra = idOrdenDeCompra;
    }
    public String getIdOrdenDeCompra() {
        return idOrdenDeCompra;
    }

    public void setDetalles(Collection<LineaOrden> detalles) {
        this.detalles = detalles;
    }
    public Collection<LineaOrden> getDetalles() { return detalles; }
}