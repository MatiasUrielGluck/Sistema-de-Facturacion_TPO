package model;
abstract class Documento {
    int id;
    String cuit;
    Boolean estaPago;
    double monto;


    public String getCuit() {
        return cuit;
    }

    public Boolean getEstaPago() {
        return estaPago;
    }

    public double getMonto() {
        return monto;
    }
}

