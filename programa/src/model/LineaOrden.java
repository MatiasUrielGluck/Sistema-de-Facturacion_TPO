package model;
public class LineaOrden {
    private int numeroRenglon;
    private int cantidad;
    private ProductoPorProveedor producto;
    private int idProveedor;
    public int getNumeroRenglon() {
        return numeroRenglon;
    }
    public int getCantidad() {
        return cantidad;
    }
    public ProductoPorProveedor getProducto() {
        return producto;
    }
    public float getUltimoPrecioAcordado(){
        return 0;
    };
}
