package model;

import enums.TipoResponsabilidad;

import java.util.Date;

public class Proveedor {
    private String cuit;
    private TipoResponsabilidad responsabilidad;
    private String razonSocial;
    private String nombre;
    private String direccion;
    private String telefono;
    private String mail;
    private double ingresosBrutos;
    private Date fechaInicioActividades;

    private ProductoPorProveedor productoPorProveedor;


    public String getCuit() {
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
