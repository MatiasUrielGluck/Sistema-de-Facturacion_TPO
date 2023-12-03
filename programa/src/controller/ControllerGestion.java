package controller;

import dao.NotaDeCreditoDAO;
import dao.NotaDeDebitoDAO;
import dao.OrdenDeCompraDAO;
import dao.ProveedorDAO;
import model.*;
import dto.CuentaCorrienteDTO;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class ControllerGestion {

    private static ControllerGestion INSTANCE = null;

    private static NotaDeCreditoDAO notaDeCreditoDAO;
    private static NotaDeDebitoDAO notaDeDebitoDAO;

    private static ProveedorDAO proveedorDAO;

    private ControllerGestion(ProveedorDAO proveedorDAO, NotaDeCreditoDAO notaDeCredito, NotaDeDebitoDAO notaDeDebito){
        ControllerGestion.proveedorDAO = proveedorDAO;
        notaDeCreditoDAO = notaDeCredito;
        notaDeDebitoDAO = notaDeDebito;
    }

    public static synchronized ControllerGestion getInstances() throws Exception {
        if(INSTANCE == null) {
            ProveedorDAO ProveedorDAO = new ProveedorDAO(Proveedor.class, getPathOutModel(Proveedor.class.getSimpleName()));
            NotaDeCreditoDAO notaDeCreditoDAO = new NotaDeCreditoDAO(NotaDeCredito.class, getPathOutModel(NotaDeCredito.class.getSimpleName()));
            NotaDeDebitoDAO notaDeDebitoDAO = new NotaDeDebitoDAO(NotaDeDebito.class, getPathOutModel(NotaDeDebito.class.getSimpleName()));
            INSTANCE = new ControllerGestion(ProveedorDAO, notaDeCreditoDAO, notaDeDebitoDAO);
        }
        return INSTANCE;
    }

    private static String getPathOutModel(String name){
        String dir = "programa\\src\\fixtures\\";
        return  new File(dir+name+".json").getAbsolutePath();
    }

    public CuentaCorrienteDTO obtenerCuentaCorrienteProveedores(int idProvedor) throws Exception{
        List<NotaDeCredito> notasDeCredito = notaDeCreditoDAO.getAll(NotaDeCredito.class);
        List<NotaDeDebito> notasDeDebito = notaDeDebitoDAO.getAll(NotaDeDebito.class);
        Proveedor proveedor = proveedorDAO.search(idProvedor, Proveedor.class);

        Double montoCredito = notasDeCredito.stream().filter(notaDeCredito -> notaDeCredito.getCuitProveedor().equals(proveedor.getCuit())).mapToDouble(NotaDeCredito::getMonto).sum();
        Double montoDebito = notasDeDebito.stream().filter(notaDeDebito -> notaDeDebito.getCuitProveedor().equals(proveedor.getCuit())).mapToDouble(NotaDeDebito::getMonto).sum();

        return  new CuentaCorrienteDTO(proveedor.getNombre(), montoCredito-montoDebito);
    };

    public void facturasPorDiaProveedor(int idProvedor){

    };

    public void consultarPrecioPorRubro(){};

    public void totalDeudaPorProveedor(){};

    public void obtenerDeudaPorProveedor(){};

    public void obtenerImpuestosRetenidos(){};

    public void consultaLibroIva(){};


}
