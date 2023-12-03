package controller;

import dao.FacturaDAO;
import dao.OrdenDeCompraDAO;
import dao.ProveedorDAO;
import model.Factura;
import model.LineaOrden;
import model.OrdenDeCompra;
import dto.CuentaCorrienteDTO;
import model.Proveedor;

import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ControllerGestion {

    private static ControllerGestion INSTANCE = null;

    private static FacturaDAO facturaDAO;
    private static OrdenDeCompraDAO ordenDeCompraDAO;
    private static ProveedorDAO proveedorDAO;

    private static List<Proveedor> proveedor;

    public static void setOrdenDeCompraDAO(OrdenDeCompraDAO ordenDeCompraDAO) {
        ControllerGestion.ordenDeCompraDAO = ordenDeCompraDAO;
    }

    private ControllerGestion(FacturaDAO facturaDAO, ProveedorDAO proveedorDAO, OrdenDeCompraDAO ordenDeCompraDAO) {
        this.facturaDAO = facturaDAO;
        this.proveedorDAO = proveedorDAO;
        this.ordenDeCompraDAO = ordenDeCompraDAO;
    }

    public double facturasPorDiaProveedor(int idProvedor, Date fecha){
        List<Factura> facturas = this.facturaDAO.getAll(Factura.class);
        double montoTotal = 0;
        for (Factura factura: facturas) {
            if (factura.getCuit() == idProvedor || factura.getFecha() == fecha) {
                montoTotal += factura.getMonto();
            }
        }
        return montoTotal;
    };
    
    public static synchronized ControllerGestion getInstances() throws Exception {
        if(INSTANCE == null) {
            FacturaDAO FacturaDAO = new FacturaDAO(Factura.class, getPathOutModel(Factura.class.getSimpleName()));
            ProveedorDAO ProveedorDAO = new ProveedorDAO(Proveedor.class, getPathOutModel(Proveedor.class.getSimpleName()));
            OrdenDeCompraDAO OrdenDeCompraDAO = new OrdenDeCompraDAO(OrdenDeCompra.class, getPathOutModel(OrdenDeCompra.class.getSimpleName()));
            INSTANCE = new ControllerGestion(FacturaDAO, ProveedorDAO, OrdenDeCompraDAO);
        }
        return INSTANCE;
    }

    public CuentaCorrienteDTO obtenerCuentaCorrienteProveedores(int idProvedor) throws Exception{
        List<OrdenDeCompra> ordenes = this.ordenDeCompraDAO.getAll(OrdenDeCompra.class);
        Collection<LineaOrden> detalles = null;
        for (OrdenDeCompra orden: ordenes) {
            if (orden.getIdOrdenDeCompra().equals(idProvedor)){
                detalles.addAll(orden.getDetalles());
            }
        }

        Double montoAcum = detalles.stream().mapToDouble(LineaOrden::getUltimoPrecioAcordado).sum();
        String nombreProveedor = proveedorDAO.search(idProvedor).getNombre();

        return  new CuentaCorrienteDTO(nombreProveedor, montoAcum);
    };

    private static String getPathOutModel(String name){
        String dir = "C:/IOO/";
        return  new File(dir+name+".json").getPath();
    }
    public void consultarPrecioPorRubro(){};

    public void totalDeudaPorProveedor(){};

    public void obtenerDeudaPorProveedor(){};

    public void obtenerImpuestosRetenidos(){};

    public void consultaLibroIva(){};


}
