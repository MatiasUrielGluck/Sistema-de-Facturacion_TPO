package dto;

public class CuentaCorrienteDTO {

    private String nombreProveedor;

    private Double montoDeuda;

    public CuentaCorrienteDTO(String nombreProveedor, Double montoDeuda) {
        this.nombreProveedor = nombreProveedor;
        this.montoDeuda = montoDeuda;
    }

    public String nombreProveedor() {
        return nombreProveedor;
    }

    public void nombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Double getMontoDeuda() {
        return montoDeuda;
    }

    public void setMontoDeuda(Double montoDeuda) {
        this.montoDeuda = montoDeuda;
    }

}
