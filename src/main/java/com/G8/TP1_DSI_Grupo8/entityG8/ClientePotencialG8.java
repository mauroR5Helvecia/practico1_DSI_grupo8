package com.G8.TP1_DSI_Grupo8.entityG8;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes_potenciales")
public class ClientePotencialG8 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClientePotencial;

    private String nombre;
    private String apellido;
    private String email;

    @OneToMany(mappedBy = "clientePotencial", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MiembroCampaniaG8> miembrosCampania = new ArrayList<>();


    public ClientePotencialG8(Long idClientePotencial, String nombre, String apellido, String email, List<MiembroCampaniaG8> miembrosCampania) {
        this.idClientePotencial = idClientePotencial;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.miembrosCampania = miembrosCampania;
    }

    public ClientePotencialG8(){


    }

    public Long getIdClientePotencial() {
        return idClientePotencial;
    }

    public void setIdClientePotencial(Long idClientePotencial) {
        this.idClientePotencial = idClientePotencial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MiembroCampaniaG8> getMiembrosCampania() {
        return miembrosCampania;
    }

    public void setMiembrosCampania(List<MiembroCampaniaG8> miembrosCampania) {
        this.miembrosCampania = miembrosCampania;
    }

    @Override
    public String toString() {
        return "ClientePotencialG8{" +
                "idClientePotencial=" + idClientePotencial +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", miembrosCampania=" + miembrosCampania +
                '}';
    }
}
