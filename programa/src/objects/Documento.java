package objects;

abstract class Documento {
    private int id;
    private int cuit;
    private Boolean estaPago;
    private double monto;


    public int getCuit() {
        return cuit;
    }

    public Boolean getEstaPago() {
        return estaPago;
    }

    public double getMonto() {
        return monto;
    }
}

