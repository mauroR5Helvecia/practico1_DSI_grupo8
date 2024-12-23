package com.G8.TP1_DSI_Grupo8.controllerG8;

import com.G8.TP1_DSI_Grupo8.DTOG8.RegistrarCasoDTOG8;
import com.G8.TP1_DSI_Grupo8.entityG8.CasoG8;
import com.G8.TP1_DSI_Grupo8.serviceG8.casoServiceG8.CasoServiceInterfaceG8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caso")
public class CasoControllerG8 {

    @Autowired
    private CasoServiceInterfaceG8 casoService;


    @GetMapping("/todos")
    public List<CasoG8> obtenerTodos() {
        try {
            return casoService.obtenerTodos();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al obtener todos los casos", e);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarCaso(@RequestBody RegistrarCasoDTOG8 dto) {
        try {
            CasoG8 caso = casoService.registrarCaso(dto.getIdContacto());
            return ResponseEntity.ok("Se ha creado un caso, pronto sera contactado para recibir asesoramiento");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("error al registrar el caso");
        }
    }

}
