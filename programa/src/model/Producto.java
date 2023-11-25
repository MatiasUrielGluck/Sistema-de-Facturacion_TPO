package model;
enum TipoRubro{
    MEDICINA_PREPAGA, VIATICOS_MOVILIDAD, MANTENIMINETO_MUEBLES, LIBRERIA, PAPELERIA_IMPRESIONES, PRODUCTOS_REVENTA
}
enum TipoUnidad{
    UNIDAD, PESO, HORA
}

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private TipoRubro rubro;
    private TipoUnidad tipoUnidad;
    private double tipoIva;

    public Producto(int idProducto, String nombreProducto, TipoRubro rubro, TipoUnidad tipoUnidad, double tipoIva) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.rubro = rubro;
        this.tipoUnidad = tipoUnidad;
        this.tipoIva = tipoIva;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public TipoRubro getRubro() {
        return rubro;
    }

    public double getTipoIva() {
        return tipoIva;
    }

    public void getUltimoPrecioAcordado(){

    };

    public void getProductoPorProveedor(){

    };
}
