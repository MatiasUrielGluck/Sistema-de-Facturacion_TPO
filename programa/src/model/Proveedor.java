package model;

import java.util.Date;

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
    public void getDocumentosDeudaProveedor(){

    };
    public void calcularDeudaProveedor(){

    };


}
