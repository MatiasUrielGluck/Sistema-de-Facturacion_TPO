package objects;

public class ChequeTerceros extends Cheque{
    private String empresaEmisora;

    public String getEmpresaEmisora() {
        return empresaEmisora;
    }

    @Override
    public Boolean getEstaPago() {
        return super.getEstaPago();
    }

    @Override
    public double getMonto() {
        return super.getMonto();
    }

    @Override
    public int getCuit() {
        return super.getCuit();
    }
}
