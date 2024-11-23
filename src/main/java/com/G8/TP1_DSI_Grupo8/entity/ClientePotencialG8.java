package com.G8.TP1_DSI_Grupo8.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes_potenciales")
public class ClientePotencialG8 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClientePotencial;


    private String nombre;

    private String email;

    private String telefono;

    public ClientePotencialG8(Long idClientePotencial, String nombre, String email, String telefono) {
        this.idClientePotencial = idClientePotencial;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
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


    @Override
    public String toString() {
        return "Se guardo el cliente POtencial con" +
                "idClientePotencial=" + idClientePotencial +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
