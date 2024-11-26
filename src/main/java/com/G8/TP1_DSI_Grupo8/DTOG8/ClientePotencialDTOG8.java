package com.G8.TP1_DSI_Grupo8.DTOG8;

public class ClientePotencialDTOG8 {

    private String nombre;
    private String apellido;
    private String email;
    private String nombreCampania;

    public ClientePotencialDTOG8 (){

    }

    public ClientePotencialDTOG8(String nombre, String apellido, String email, String nombreCampania) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nombreCampania = nombreCampania;
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

    public String getNombreCampania() {
        return nombreCampania;
    }

    public void setNombreCampania(String nombreCampania) {
        this.nombreCampania = nombreCampania;
    }
}
