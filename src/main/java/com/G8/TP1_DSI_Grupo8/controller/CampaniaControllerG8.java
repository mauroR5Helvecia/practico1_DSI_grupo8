package com.G8.TP1_DSI_Grupo8.controller;
import com.G8.TP1_DSI_Grupo8.entityG8.CampaniaG8;
import com.G8.TP1_DSI_Grupo8.entityG8.MiembroCampaniaG8;
import com.G8.TP1_DSI_Grupo8.serviceG8.campaniaServiceG8.CampaniaServiceInrterfaceG8;
import com.G8.TP1_DSI_Grupo8.serviceG8.campaniaServiceG8.CampaniaServiceInterfaceG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/campania")
public class CampaniaControllerG8 {

    @Autowired
    private CampaniaServiceInterfaceG8 campaniaInterfaceG8;



    @PostMapping("/save")
    public String saveCampania(@RequestBody CampaniaG8 campania) {
        try {
            CampaniaG8 campaniaResponse = campaniaInterfaceG8.guardar(campania);
            return campaniaResponse.toString();
        } catch (RuntimeException e) {
            throw new RuntimeException("Hubo un error al guardar la campania", e);
        }
    }

    @GetMapping("/traer")
    public List<CampaniaG8> traerCampanias() {
        try {
            return campaniaInterfaceG8.obtenerTodas();
        } catch (RuntimeException e) {
            throw new RuntimeException("Hubo un error al traer la lista de campañas", e);
        }
    }


    @GetMapping("/buscar")
    public List<CampaniaG8> buscarCampaniaPorNombre(@RequestParam String nombre) {
        try {
            return campaniaInterfaceG8.buscarPorNombre(nombre);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("No puedes mandar el campo vacio", e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Hubo un error al buscar campañas por nombre", e);
        }
    }


    @PostMapping("/{idCampania}/asociar-cliente")
    public ResponseEntity<MiembroCampaniaG8> asociarClienteACampania(
            @PathVariable Long idCampania,
            @RequestParam Long idCliente) {
        try {
            MiembroCampaniaG8 miembro = campaniaInterfaceG8.asociarClienteACampania(idCampania, idCliente);
            return ResponseEntity.ok(miembro);
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body(null);
        }



    }




}
