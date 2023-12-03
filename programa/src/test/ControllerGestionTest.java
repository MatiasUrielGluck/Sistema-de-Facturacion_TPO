package test;

import controller.Controller;
import controller.ControllerGestion;
import dto.CuentaCorrienteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ControllerGestionTest {
    ControllerGestion controllerGestion;

    @BeforeEach
    public void init() throws Exception {
        controllerGestion = ControllerGestion.getInstances();
    }

    @Test
    void getInstances() throws Exception {
        assertNotNull(controllerGestion);
    }

    @Test
    void obtenerCuentaCorrienteProveedoresConDeuda() throws Exception {
        CuentaCorrienteDTO Respuesta = controllerGestion.obtenerCuentaCorrienteProveedores(1);
        assertEquals(-108351.0, Respuesta.getMontoDeuda());
    }

    @Test
    void obtenerCuentaCorrienteProveedoresCuenta0() throws Exception {
        CuentaCorrienteDTO Respuesta = controllerGestion.obtenerCuentaCorrienteProveedores(2);
        assertEquals(0, Respuesta.getMontoDeuda());
    }

    @Test
    void obtenerCuentaCorrienteProveedoresConSaldoAFavor() throws Exception {
        CuentaCorrienteDTO Respuesta = controllerGestion.obtenerCuentaCorrienteProveedores(3);
        assertEquals(41000.0, Respuesta.getMontoDeuda());
    }
}
