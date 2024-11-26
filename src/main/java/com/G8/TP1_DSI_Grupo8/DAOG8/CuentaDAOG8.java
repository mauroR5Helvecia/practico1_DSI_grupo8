package com.G8.TP1_DSI_Grupo8.DAOG8;
import com.G8.TP1_DSI_Grupo8.entityG8.CuentaG8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaDAOG8 extends JpaRepository<CuentaG8, Long> {

}
