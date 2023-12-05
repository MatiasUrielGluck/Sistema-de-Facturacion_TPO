package dao;

import enums.TipoResponsabilidad;
import model.Proveedor;
import util.GenericDAO;

import java.util.Date;

public class ProveedorDAO {

    public ProveedorDAO() throws Exception {
        Proveedor textilVendoTelas = new Proveedor(
                1,
                TipoResponsabilidad.RESPONSABLE_INSCRIPTO,
                "Textil Vendo Telas",
                "Textil Vendo Telas",
                "Una calle muy linda 123",
                null,
                null,
                20,
                new Date(),
                null);


    Proveedor despegarPuntoCom = new Proveedor(
            2,
            TipoResponsabilidad.RESPONSABLE_INSCRIPTO,
            "Despegar Punto Com",
            "Despegar Punto Com",
            "Una calle muy linda 456",
            null,
            null,
            20,
            new Date(),
            null);


    Proveedor pescaderiaDeTito = new Proveedor(
            3,
            TipoResponsabilidad.MONOTRIBUTO,
            "La Pescaderia de Tito",
            "Tito Baratito",
            "El Muelle 1024",
            null,
            null,
            5,
            new Date(),
            null);
    }
}
