package controller;

import dao.*;
import model.*;
import dto.*;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class ControllerGestion {

    private static ControllerGestion INSTANCE = null;

    private static NotaDeCreditoDAO notaDeCreditoDAO;
    private static NotaDeDebitoDAO notaDeDebitoDAO;

    private static OrdenDePagoDAO ordenDePagoDAO;
    private static FacturaDAO facturaDAO;

    private static ProveedorDAO proveedorDAO;

    private ControllerGestion(ProveedorDAO proveedor, NotaDeCreditoDAO notaDeCredito, NotaDeDebitoDAO notaDeDebito, OrdenDePagoDAO ordenDePago, FacturaDAO factura){
        proveedorDAO = proveedor;
        notaDeCreditoDAO = notaDeCredito;
        notaDeDebitoDAO = notaDeDebito;
        ordenDePagoDAO = ordenDePago;
        facturaDAO = factura;
    }

    public static synchronized ControllerGestion getInstances() throws Exception {
        if(INSTANCE == null) {
            ProveedorDAO ProveedorDAO = new ProveedorDAO(Proveedor.class, getPathOutModel(Proveedor.class.getSimpleName()));
            NotaDeCreditoDAO notaDeCreditoDAO = new NotaDeCreditoDAO(NotaDeCredito.class, getPathOutModel(NotaDeCredito.class.getSimpleName()));
            NotaDeDebitoDAO notaDeDebitoDAO = new NotaDeDebitoDAO(NotaDeDebito.class, getPathOutModel(NotaDeDebito.class.getSimpleName()));
            OrdenDePagoDAO ordenDePagoDAO = new OrdenDePagoDAO(OrdenDePago.class, getPathOutModel(OrdenDePago.class.getSimpleName()));
            FacturaDAO facturaDAO = new FacturaDAO(Factura.class, getPathOutModel(Factura.class.getSimpleName()));
            INSTANCE = new ControllerGestion(ProveedorDAO, notaDeCreditoDAO, notaDeDebitoDAO, ordenDePagoDAO, facturaDAO);
        }
        return INSTANCE;
    }

    private static String getPathOutModel(String name){
        String dir = "programa\\src\\fixtures\\";
        return  new File(dir+name+".json").getAbsolutePath();
    }

    public CuentaCorrienteDTO obtenerCuentaCorrienteProveedores(int idProvedor) throws Exception{
        Proveedor proveedor = proveedorDAO.search(idProvedor, Proveedor.class);
        String cuitProveedor= proveedor.getCuit();
        List<NotaDeCredito> notasDeCredito = notaDeCreditoDAO.getAll(NotaDeCredito.class).stream().filter(notaDeCredito -> notaDeCredito.getCuitProveedor().equals(cuitProveedor)).toList();
        List<NotaDeDebito> notasDeDebito = notaDeDebitoDAO.getAll(NotaDeDebito.class).stream().filter(notaDeDebito -> notaDeDebito.getCuitProveedor().equals(cuitProveedor)).toList();
        List<Factura> facturas = facturaDAO.getAll(Factura.class).stream().filter(factura -> factura.getCuitProveedor().equals(cuitProveedor)).toList();
        Double montoCredito = notasDeCredito.stream().mapToDouble(NotaDeCredito::getMonto).sum();
        Double montoDebito = notasDeDebito.stream().mapToDouble(NotaDeDebito::getMonto).sum();

        return  new CuentaCorrienteDTO(proveedor.getNombre(), montoCredito-montoDebito, facturas, notasDeCredito, notasDeDebito);
    };

    public void facturasPorDiaProveedor(int idProvedor){

    };

    public void consultarPrecioPorRubro(){};

    public void totalDeudaPorProveedor(){};

    public void obtenerDeudaPorProveedor(){

    };

    public void obtenerImpuestosRetenidos(){};

    public void consultaLibroIva(){};


}
