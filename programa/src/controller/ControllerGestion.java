package controller;

import dao.*;
import edu.Impuesto;
import model.*;
import dto.CuentaCorrienteDTO;

import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ControllerGestion {

    private static ControllerGestion INSTANCE = null;

    private static FacturaDAO facturaDAO;
    private static NotaDeCreditoDAO notaDeCreditoDAO;
    private static NotaDeDebitoDAO notaDeDebitoDAO;
    private static ChequePropioDAO chequePropioDAO;
    private static ChequeTerceroDAO chequeTerceroDAO;
    private static OrdenDeCompraDAO ordenDeCompraDAO;
    private static ProveedorDAO proveedorDAO;

    private static List<Proveedor> proveedor;

    public static void setOrdenDeCompraDAO(OrdenDeCompraDAO ordenDeCompraDAO) {
        ControllerGestion.ordenDeCompraDAO = ordenDeCompraDAO;
    }

    private ControllerGestion(FacturaDAO facturaDAO, ProveedorDAO proveedorDAO, OrdenDeCompraDAO ordenDeCompraDAO, NotaDeCreditoDAO notaDeCreditoDAO, NotaDeDebitoDAO notaDeDebitoDAO, ChequePropioDAO chequePropioDAO, ChequeTerceroDAO chequeTerceroDAO) {
        this.facturaDAO = facturaDAO;
        this.proveedorDAO = proveedorDAO;
        this.ordenDeCompraDAO = ordenDeCompraDAO;
        this.notaDeCreditoDAO = notaDeCreditoDAO;
        this.notaDeDebitoDAO = notaDeDebitoDAO;
        this.chequePropioDAO = chequePropioDAO;
        this.chequeTerceroDAO = chequeTerceroDAO;
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
            NotaDeCreditoDAO NotaDeCreditoDAO = new NotaDeCreditoDAO(NotaDeCredito.class, getPathOutModel(NotaDeCredito.class.getSimpleName()));
            NotaDeDebitoDAO NotaDeDebitoDAO = new NotaDeDebitoDAO(NotaDeDebito.class, getPathOutModel(NotaDeDebito.class.getSimpleName()));
            ChequeTerceroDAO ChequeTerceroDAO = new ChequeTerceroDAO(ChequeTerceros.class, getPathOutModel(ChequeTerceros.class.getSimpleName()));
            ChequePropioDAO ChequePropioDAO = new ChequePropioDAO(ChequePropio.class, getPathOutModel(ChequePropio.class.getSimpleName()));
            INSTANCE = new ControllerGestion(FacturaDAO, ProveedorDAO, OrdenDeCompraDAO, NotaDeCreditoDAO, notaDeDebitoDAO, chequePropioDAO, chequeTerceroDAO);
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

    public double obtenerDeudaPorProveedor(int cuit) {
        List<Factura> facturas = this.facturaDAO.getAll(Factura.class);
        List<NotaDeCredito> notasDeCredito = this.notaDeCreditoDAO.getAll(NotaDeCredito.class);
        List<NotaDeDebito> notasDeDebito = this.notaDeDebitoDAO.getAll(NotaDeDebito.class);
        List<ChequePropio> chequesPropio = this.chequePropioDAO.getAll(ChequePropio.class);
        List<ChequeTerceros> chequesTerceros = this.chequeTerceroDAO.getAll(ChequeTerceros.class);

        return proveedorDAO.search(cuit).getDocumentosDeudaProveedor(facturas, notasDeCredito, notasDeDebito, chequesPropio, chequesTerceros);
    };

    public double obtenerImpuestosRetenidos(int cuit) {
        List<Factura> facturas = this.facturaDAO.getAll(Factura.class);
        double impuestosRetenidos = 0;
        for (Factura factura: facturas) {
            if (factura.getCuit() != cuit) continue;
            
            Collection<Impuesto> impuestos = factura.getImpuestos();
            for (Impuesto impuesto: impuestos) {
                impuestosRetenidos += factura.getMonto() * impuesto.getPercentage();
            }
        }
        return impuestosRetenidos;
    };

    public void consultaLibroIva(){};


}
