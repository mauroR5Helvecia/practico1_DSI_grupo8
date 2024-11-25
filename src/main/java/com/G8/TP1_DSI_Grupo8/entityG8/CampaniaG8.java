package com.G8.TP1_DSI_Grupo8.entityG8;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "campanias")
public class CampaniaG8 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCampania;

    private String nombreCampania;
    private String objetivosCampania;
    private String patrocinadorCampania;
    private LocalDate fechaInicioCampania;

    private LocalDate fechaFinCampania;
    private String otrosDetallesCampania;

    @OneToMany(mappedBy = "campania", cascade = CascadeType.ALL)
    private List<MiembroCampaniaG8> miembrosCampania;

    public CampaniaG8 (){

    }

    public CampaniaG8(Long idCampania, String nombreCampania, String objetivosCampania, String patrocinadorCampania, LocalDate fechaInicioCampania, LocalDate fechaFinCampania, String otrosDetallesCampania) {
        this.idCampania = idCampania;
        this.nombreCampania = nombreCampania;
        this.objetivosCampania = objetivosCampania;
        this.patrocinadorCampania = patrocinadorCampania;
        this.fechaInicioCampania = fechaInicioCampania;
        this.fechaFinCampania = fechaFinCampania;
        this.otrosDetallesCampania = otrosDetallesCampania;
    }

    public Long getIdCampania() {
        return idCampania;
    }

    public void setIdCampania(Long idCampania) {
        this.idCampania = idCampania;
    }

    public String getNombreCampania() {
        return nombreCampania;
    }

    public void setNombreCampania(String nombreCampania) {
        this.nombreCampania = nombreCampania;
    }

    public String getObjetivosCampania() {
        return objetivosCampania;
    }

    public void setObjetivosCampania(String objetivosCampania) {
        this.objetivosCampania = objetivosCampania;
    }

    public String getPatrocinadorCampania() {
        return patrocinadorCampania;
    }

    public void setPatrocinadorCampania(String patrocinadorCampania) {
        this.patrocinadorCampania = patrocinadorCampania;
    }

    public LocalDate getFechaInicioCampania() {
        return fechaInicioCampania;
    }

    public void setFechaInicioCampania(LocalDate fechaInicioCampania) {
        this.fechaInicioCampania = fechaInicioCampania;
    }

    public LocalDate getFechaFinCampania() {
        return fechaFinCampania;
    }

    public void setFechaFinCampania(LocalDate fechaFinCampania) {
        this.fechaFinCampania = fechaFinCampania;
    }

    public String getOtrosDetallesCampania() {
        return otrosDetallesCampania;
    }

    public void setOtrosDetallesCampania(String otrosDetallesCampania) {
        this.otrosDetallesCampania = otrosDetallesCampania;
    }

    public List<MiembroCampaniaG8> getMiembrosCampania() {
        return miembrosCampania;
    }

    public void setMiembrosCampania(List<MiembroCampaniaG8> miembrosCampania) {
        this.miembrosCampania = miembrosCampania;
    }
}
