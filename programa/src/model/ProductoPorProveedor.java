package model;
public class ProductoPorProveedor {
    private int idProductoPorProveedor;
    private double ultimoPrecio;
    private Producto producto;
    public ProductoPorProveedor(double ultimoPrecio, Producto producto) {
        this.ultimoPrecio = ultimoPrecio;
        this.producto =producto;
    }

    public int getIdProductoPorProveedor() {
        return idProductoPorProveedor;
    }
    public double getUltimoPrecio() {
        return ultimoPrecio;
    }

    public Producto getProducto() {
        return producto;
    }

}
