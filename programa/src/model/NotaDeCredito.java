package model;
public class NotaDeCredito extends Documento{
    String cuitProveedor;

    public NotaDeCredito(int id, String cuit, boolean estaPago, double monto, String cuitProveedor) {
        this.id = id;
        this.cuit = cuit;
        this.estaPago = estaPago;
        this.monto = monto;
        this.cuitProveedor = cuitProveedor;
    }
    @Override
    public String getCuit() {
        return super.getCuit();
    }

    @Override
    public Boolean getEstaPago() {
        return super.getEstaPago();
    }

    @Override
    public double getMonto() {
        return super.getMonto();
    }

    public String getId() {
        return super.getCuit();
    }

    public String getCuitProveedor() {
        return this.cuitProveedor;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    public void setEstaPago(boolean estaPago) {
        this.estaPago = estaPago;
    }
    public void setCuitProveedor(String cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }
}
