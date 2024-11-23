package com.G8.TP1_DSI_Grupo8.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes_potenciales")
public class ClientePotencial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClientePotencial;


    private String nombre;

    private String email;

    private String telefono;

    public ClientePotencial(Long idClientePotencial, String nombre, String email, String telefono) {
        this.idClientePotencial = idClientePotencial;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public ClientePotencial(){

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
