package model;

import java.util.Date;

abstract class Cheque extends Documento{
    private Date fechaEmision;
    private Date fechaVencimiento;
    private String firmante;
    private double importe;

}
