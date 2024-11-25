package com.G8.TP1_DSI_Grupo8.entityG8;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "Contacto")
public class ContactoG8 {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContacto;

    private String direccionContacto;
    private String detallesContacto;

    @ManyToOne
    @JoinColumn(name = "idCuenta", nullable = false)
    private CuentaG8 cuenta;

    @OneToMany(mappedBy = "contacto", cascade = CascadeType.ALL)
    private List<CasoG8> casos;


    @OneToMany(mappedBy = "contacto", cascade = CascadeType.ALL)
    private List<RolCuentaG8> rolesCuenta;

    @OneToMany(mappedBy = "contacto", cascade = CascadeType.ALL)
    private List<RolOportunidadG8> rolesOportunidad;

    @OneToMany(mappedBy = "contacto", cascade = CascadeType.ALL)
    private List<MiembroCampaniaG8> miembrosCampania;


    public ContactoG8(Long idContacto, String direccionContacto, String detallesContacto, CuentaG8 cuenta) {
        this.idContacto = idContacto;
        this.direccionContacto = direccionContacto;
        this.detallesContacto = detallesContacto;
        this.cuenta = cuenta;
    }

   public ContactoG8 (){


   }


    public Long getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Long idContacto) {
        this.idContacto = idContacto;
    }

    public String getDireccionContacto() {
        return direccionContacto;
    }

    public void setDireccionContacto(String direccionContacto) {
        this.direccionContacto = direccionContacto;
    }

    public String getDetallesContacto() {
        return detallesContacto;
    }

    public void setDetallesContacto(String detallesContacto) {
        this.detallesContacto = detallesContacto;
    }

    public CuentaG8 getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaG8 cuenta) {
        this.cuenta = cuenta;
    }

    public List<CasoG8> getCasos() {
        return casos;
    }

    public void setCasos(List<CasoG8> casos) {
        this.casos = casos;
    }

    public List<RolCuentaG8> getRolesCuenta() {
        return rolesCuenta;
    }

    public void setRolesCuenta(List<RolCuentaG8> rolesCuenta) {
        this.rolesCuenta = rolesCuenta;
    }

    public List<RolOportunidadG8> getRolesOportunidad() {
        return rolesOportunidad;
    }

    public void setRolesOportunidad(List<RolOportunidadG8> rolesOportunidad) {
        this.rolesOportunidad = rolesOportunidad;
    }

    public List<MiembroCampaniaG8> getMiembrosCampania() {
        return miembrosCampania;
    }

    public void setMiembrosCampania(List<MiembroCampaniaG8> miembrosCampania) {
        this.miembrosCampania = miembrosCampania;
    }
}
