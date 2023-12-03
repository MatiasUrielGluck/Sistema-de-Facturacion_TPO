package model;

import java.util.Date;
import java.util.List;

enum TipoResponsabilidad{
    RESPONSABLE_INSCRIPTO, MONOTRIBUTO
}

public class Proveedor {
    private int cuit;
    private TipoResponsabilidad responsabilidad;
    private String razonSocial;
    private String nombre;
    private String direccion;
    private String telefono;
    private String mail;
    private double ingresosBrutos;
    private Date fechaInicioActividades;

    private ProductoPorProveedor productoPorProveedor;


    public int getCuit() {
        return cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void generarCertificado(){

    };
    public double getDocumentosDeudaProveedor(List<Factura> facturas, List<NotaDeCredito> notasDeCredito, List<NotaDeDebito> notasDeDebito, List<ChequePropio> chequesPropio, List<ChequeTerceros> chequesTerceros) {
        double montosCalculados = 0;

        for (Factura factura: facturas) {
            if (factura.getCuit() != this.cuit) continue;
            if (!factura.getEstaPago()) montosCalculados += factura.getMonto();
        }

        for (NotaDeCredito notaDeCredito: notasDeCredito) {
            if (notaDeCredito.getCuit() != this.cuit) continue;
            if (!notaDeCredito.getEstaPago()) montosCalculados += notaDeCredito.getMonto();
        }

        for (NotaDeDebito notaDeDebito: notasDeDebito) {
            if (notaDeDebito.getCuit() != this.cuit) continue;
            if (!notaDeDebito.getEstaPago()) montosCalculados += notaDeDebito.getMonto();
        }

        for (ChequePropio chequePropio: chequesPropio) {
            if (chequePropio.getCuit() != this.cuit) continue;
            if (!chequePropio.getEstaPago()) montosCalculados += chequePropio.getMonto();
        }

        for (ChequeTerceros chequeTerceros: chequesTerceros) {
            if (chequeTerceros.getCuit() != this.cuit) continue;
            if (!chequeTerceros.getEstaPago()) montosCalculados += chequeTerceros.getMonto();
        }

        return montosCalculados;
    };
    public void calcularDeudaProveedor(){

    };


}
