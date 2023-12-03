package model;

import java.util.Date;

enum TipoResponsabilidad{
    RESPONSABLE_INSCRIPTO, MONOTRIBUTO
}

public class Proveedor {
    private int id;
    private String cuit;
    private TipoResponsabilidad responsabilidad;
    private String razonSocial;
    private String nombre;
    private String direccion;
    private String telefono;
    private String mail;
    private double ingresosBrutos;
    private Date fechaInicioActividades;


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
