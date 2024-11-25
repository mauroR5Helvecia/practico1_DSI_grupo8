package com.G8.TP1_DSI_Grupo8.repositoryG8;

import com.G8.TP1_DSI_Grupo8.entityG8.OportunidadG8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OportunidadRepositoryG8 extends JpaRepository<OportunidadG8, Long> {
    List<OportunidadG8> findByEtapaOportunidadContainingIgnoreCase(String etapaOportunidad);
}
