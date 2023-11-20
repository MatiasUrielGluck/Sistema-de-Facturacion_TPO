
enum TipoImpuesto{
    IVA, IBB, GANANCIAS
}

public class Impuesto {
    private int idImpuesto;
    private TipoImpuesto tipo;
    private double porcentaje;

    public int getIdImpuesto() {
        return idImpuesto;
    }
}
