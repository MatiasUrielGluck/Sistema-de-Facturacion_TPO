package controller;

import dao.*;
import edu.Impuesto;
import model.*;
import dao.ProveedorDAO;
import dto.OrdenDePagoDTO;
import dto.CuentaCorrienteDTO;

import java.io.File;
import java.util.ArrayList;
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

    private static OrdenDePagoDAO ordenDePagoDAO;

    private static ProveedorDAO proveedorDAO;

    private static List<Proveedor> proveedor;

    public static void setOrdenDeCompraDAO(OrdenDeCompraDAO ordenDeCompraDAO) {
        ControllerGestion.ordenDeCompraDAO = ordenDeCompraDAO;
    }

    private ControllerGestion(FacturaDAO facturaDAO, ProveedorDAO proveedorDAO, OrdenDeCompraDAO ordenDeCompraDAO, NotaDeCreditoDAO notaDeCreditoDAO, NotaDeDebitoDAO notaDeDebitoDAO, ChequePropioDAO chequePropioDAO, ChequeTerceroDAO chequeTerceroDAO, OrdenDePagoDAO ordenDePagoDAO) {
        this.facturaDAO = facturaDAO;
        this.proveedorDAO = proveedorDAO;
        this.ordenDeCompraDAO = ordenDeCompraDAO;
        this.notaDeCreditoDAO = notaDeCreditoDAO;
        this.notaDeDebitoDAO = notaDeDebitoDAO;
        this.chequePropioDAO = chequePropioDAO;
        this.chequeTerceroDAO = chequeTerceroDAO;
        this.ordenDePagoDAO = ordenDePagoDAO;
    }


    public double facturasPorDiaProveedor(int idProvedor, Date fecha) throws Exception {
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
            OrdenDePagoDAO OrdenDePagoDAO = new OrdenDePagoDAO(OrdenDePago.class, getPathOutModel(OrdenDePago.class.getSimpleName()));
            INSTANCE = new ControllerGestion(FacturaDAO, ProveedorDAO, OrdenDeCompraDAO, NotaDeCreditoDAO, NotaDeDebitoDAO, ChequePropioDAO, ChequeTerceroDAO, OrdenDePagoDAO);
        }
        return INSTANCE;
    }


    private static String getPathOutModel(String name){
        String dir = "C:/IOO/";
        return  new File(dir+name+".json").getPath();
    }

    public CuentaCorrienteDTO obtenerCuentaCorrienteProveedores(int idProvedor) throws Exception{
        Proveedor proveedor = proveedorDAO.search(idProvedor, Proveedor.class);
        int cuitProveedor= proveedor.getCuit();
        List<NotaDeCredito> notasDeCredito = notaDeCreditoDAO.getAll(NotaDeCredito.class).stream().filter(notaDeCredito -> notaDeCredito.getCuitProveedor() == cuitProveedor).toList();
        List<NotaDeDebito> notasDeDebito = notaDeDebitoDAO.getAll(NotaDeDebito.class).stream().filter(notaDeDebito -> notaDeDebito.getCuitProveedor() == cuitProveedor).toList();
        List<Factura> facturas = facturaDAO.getAll(Factura.class).stream().filter(factura -> factura.getCuitProveedor().equals(cuitProveedor)).toList();
        Double montoCredito = notasDeCredito.stream().mapToDouble(NotaDeCredito::getMonto).sum();
        Double montoDebito = notasDeDebito.stream().mapToDouble(NotaDeDebito::getMonto).sum();

        return  new CuentaCorrienteDTO(proveedor.getNombre(), montoCredito-montoDebito, facturas, notasDeCredito, notasDeDebito);
    };

    public void facturasPorDiaProveedor(int idProvedor){

    };

    public void consultarPrecioPorRubro(){};

    public void totalDeudaPorProveedor(){};

    public double obtenerDeudaPorProveedor(int cuit) throws Exception {
        List<Factura> facturas = this.facturaDAO.getAll(Factura.class);
        List<NotaDeCredito> notasDeCredito = this.notaDeCreditoDAO.getAll(NotaDeCredito.class);
        List<NotaDeDebito> notasDeDebito = this.notaDeDebitoDAO.getAll(NotaDeDebito.class);
        List<ChequePropio> chequesPropio = this.chequePropioDAO.getAll(ChequePropio.class);
        List<ChequeTerceros> chequesTerceros = this.chequeTerceroDAO.getAll(ChequeTerceros.class);

        return proveedorDAO.search(cuit).getDocumentosDeudaProveedor(facturas, notasDeCredito, notasDeDebito, chequesPropio, chequesTerceros);
    };

    public double obtenerImpuestosRetenidos(int cuit) throws Exception {
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

    public List<OrdenDePagoDTO> obtenerOrdenesDePago() throws Exception {
        List<OrdenDePagoDTO> resultado = new ArrayList<OrdenDePagoDTO>();
        List<OrdenDePago> ordenesDePago = this.ordenDePagoDAO.getAll(OrdenDePago.class);
        for (OrdenDePago ordenDePago : ordenesDePago){
            OrdenDePagoDTO ordenDePagoDTO = new OrdenDePagoDTO(ordenDePago);
            resultado.add(ordenDePagoDTO);
        }
        return resultado;
    }
}
