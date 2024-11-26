package com.G8.TP1_DSI_Grupo8.controllerG8;

import com.G8.TP1_DSI_Grupo8.DTOG8.OportunidadDTOG8;
import com.G8.TP1_DSI_Grupo8.entityG8.OportunidadG8;
import com.G8.TP1_DSI_Grupo8.entityG8.RolOportunidadG8;
import com.G8.TP1_DSI_Grupo8.serviceG8.oportunidadService.OportunidadServiceInterfaceG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oportunidad")
public class OportunidadControllerG8 {

    @Autowired
    private OportunidadServiceInterfaceG8 oportunidadService;

    @PostMapping("/save")
    public OportunidadG8 guardarOportunidad(@RequestBody OportunidadG8 oportunidad) {
        try {
            return oportunidadService.guardar(oportunidad);
        } catch (RuntimeException e) {
            throw new RuntimeException("error al guardar la oportunidad", e);
        }
    }

    @GetMapping("/todas")
    public List<OportunidadG8> obtenerTodas() {
        try {
            return oportunidadService.obtenerTodas();
        } catch (RuntimeException e) {
            throw new RuntimeException("error al obtener todas las oportunidades", e);
        }
    }

    @GetMapping("/{id}")
    public OportunidadG8 buscarPorId(@PathVariable Long id) {
        try {
            return oportunidadService.buscarPorId(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("error al buscar la oportunidad con ID: " + id, e);
        }
    }

    @GetMapping("/etapa")
    public List<OportunidadG8> buscarPorEtapa(@RequestParam String etapa) {
        try {
            return oportunidadService.buscarPorEtapa(etapa);
        } catch (RuntimeException e) {
            throw new RuntimeException("error al buscar oportunidades por etapa: " + etapa, e);
        }
    }



    @PostMapping("/crear")
    public ResponseEntity<OportunidadG8> crearOportunidad(
            @RequestBody OportunidadDTOG8 oportunidadDTOG8
            ) {
        try {
            OportunidadG8 oportunidad = oportunidadService.crearOportunidad(oportunidadDTOG8);
            return ResponseEntity.ok(oportunidad);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    @PostMapping("/{idOportunidad}/asociar-contacto")
    public ResponseEntity<RolOportunidadG8> asociarContactoAOportunidad(
            @PathVariable Long idOportunidad,
            @RequestParam Long idContacto) {
        try {
            RolOportunidadG8 rolOportunidad = oportunidadService.asociarContactoAOportunidad(idOportunidad, idContacto);
            return ResponseEntity.ok(rolOportunidad);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
