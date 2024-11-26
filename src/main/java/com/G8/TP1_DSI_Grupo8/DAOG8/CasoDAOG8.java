package com.G8.TP1_DSI_Grupo8.DAOG8;
import com.G8.TP1_DSI_Grupo8.entityG8.CasoG8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasoDAOG8 extends JpaRepository<CasoG8, Long> {

}
