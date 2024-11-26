package com.G8.TP1_DSI_Grupo8.controllerG8;

import com.G8.TP1_DSI_Grupo8.entityG8.CuentaG8;
import com.G8.TP1_DSI_Grupo8.serviceG8.cuentaService.CuentaServiceInterfaceG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaControllerG8 {

    @Autowired
    private CuentaServiceInterfaceG8 cuentaService;

    @PostMapping("/save")
    public CuentaG8 guardarCuenta(@RequestBody CuentaG8 cuenta) {
        try {
            return cuentaService.guardar(cuenta);
        } catch (RuntimeException e) {
            throw new RuntimeException("error al guardar la cuenta", e);
        }
    }

    @GetMapping("/todas")
    public List<CuentaG8> obtenerTodas() {
        try {
            return cuentaService.obtenerTodas();
        } catch (RuntimeException e) {
            throw new RuntimeException("error al traer las cuentas", e);
        }
    }

    @GetMapping("/{id}")
    public CuentaG8 buscarPorId(@PathVariable Long id) {
        try {
            return cuentaService.buscarPorId(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("error al buscar la cuenta", e);
        }
    }

    @PostMapping("/crear-desde-cliente")
    public ResponseEntity<CuentaG8> crearCuentaDesdeClientePotencial(
            @RequestParam Long idCliente,
            @RequestBody CuentaG8 cuenta) {
        try {
            CuentaG8 cuentaCreada = cuentaService.crearCuentaDesdeClientePotencial(idCliente, cuenta);
            return ResponseEntity.ok(cuentaCreada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
