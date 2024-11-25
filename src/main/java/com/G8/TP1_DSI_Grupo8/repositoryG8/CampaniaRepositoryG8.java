package com.G8.TP1_DSI_Grupo8.repositoryG8;

import com.G8.TP1_DSI_Grupo8.entityG8.CampaniaG8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaniaRepositoryG8 extends JpaRepository<CampaniaG8, Long> {

//    En base a los atributos de campania se busca por nombre, ignorando las mayusculas y minusculas,
//    esto es algo que ya vien  con spring data jpa
    List<CampaniaG8> findByNombreCampaniaContainingIgnoreCase(String nombre);
}
