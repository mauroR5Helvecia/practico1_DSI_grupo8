package com.G8.TP1_DSI_Grupo8.entityG8;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Cuenta")
public class CuentaG8 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;

    private String nombreCuenta;
    private String descripcionCuenta;
    private String telefonoCuenta;
    private String direccionFacturacion;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<ContactoG8> contactos;

    @OneToOne(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private ContratoG8 contrato;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OportunidadG8> oportunidades;


    public CuentaG8(Long idCuenta, String nombreCuenta, String descripcionCuenta, String telefonoCuenta, String direccionFacturacion) {
        this.idCuenta = idCuenta;
        this.nombreCuenta = nombreCuenta;
        this.descripcionCuenta = descripcionCuenta;
        this.telefonoCuenta = telefonoCuenta;
        this.direccionFacturacion = direccionFacturacion;
    }

    public CuentaG8() {

    }

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getDescripcionCuenta() {
        return descripcionCuenta;
    }

    public void setDescripcionCuenta(String descripcionCuenta) {
        this.descripcionCuenta = descripcionCuenta;
    }

    public String getTelefonoCuenta() {
        return telefonoCuenta;
    }

    public void setTelefonoCuenta(String telefonoCuenta) {
        this.telefonoCuenta = telefonoCuenta;
    }

    public String getDireccionFacturacion() {
        return direccionFacturacion;
    }

    public void setDireccionFacturacion(String direccionFacturacion) {
        this.direccionFacturacion = direccionFacturacion;
    }
}
