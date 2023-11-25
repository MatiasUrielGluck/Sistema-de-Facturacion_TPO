package controller;

import dao.OrdenDeCompraDAO;
import dao.ProveedorDAO;
import model.LineaOrden;
import model.OrdenDeCompra;
import dto.CuentaCorrienteDTO;
import model.Proveedor;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class ControllerGestion {

    private static ControllerGestion INSTANCE = null;

    private static OrdenDeCompraDAO ordenDeCompraDAO;
    private static ProveedorDAO proveedorDAO;

    private static List<Proveedor> proveedor;

    public static void setOrdenDeCompraDAO(OrdenDeCompraDAO ordenDeCompraDAO) {
        ControllerGestion.ordenDeCompraDAO = ordenDeCompraDAO;
    }

    public void facturasPorDiaProveedor(int idProvedor){

    };
    private ControllerGestion(ProveedorDAO proveedorDAO, OrdenDeCompraDAO ordenDeCompraDAO){
        this.proveedorDAO = proveedorDAO;
        this.ordenDeCompraDAO = ordenDeCompraDAO;
    }
    public static synchronized ControllerGestion getInstances() throws Exception {
        if(INSTANCE == null) {
            ProveedorDAO ProveedorDAO = new ProveedorDAO(Proveedor.class, getPathOutModel(Proveedor.class.getSimpleName()));
            OrdenDeCompraDAO OrdenDeCompraDAO = new OrdenDeCompraDAO(OrdenDeCompra.class, getPathOutModel(OrdenDeCompra.class.getSimpleName()));
            INSTANCE = new ControllerGestion(ProveedorDAO, OrdenDeCompraDAO);
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
