package model;
public class ChequePropio extends Cheque{
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

}
