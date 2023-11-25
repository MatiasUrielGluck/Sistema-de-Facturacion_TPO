package model;
public class NotaDeDebito extends Documento{
    public NotaDeDebito(int id, int cuit, boolean estaPago, double monto) {
        this.id = id;
        this.cuit = cuit;
        this.estaPago = estaPago;
        this.monto = monto;
    }
    @Override
    public int getCuit() {
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
}
