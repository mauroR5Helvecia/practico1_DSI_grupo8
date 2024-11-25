package com.G8.TP1_DSI_Grupo8.serviceG8.cuentaService;
import com.G8.TP1_DSI_Grupo8.entityG8.CuentaG8;
import java.util.List;

public interface CuentaServiceInterfaceG8 {

    List<CuentaG8> obtenerTodas();

    CuentaG8 guardar(CuentaG8 cuenta);

    CuentaG8 buscarPorId(Long idCuenta);


    CuentaG8 crearCuentaDesdeClientePotencial(Long idCliente, CuentaG8 cuenta);
}
