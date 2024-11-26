package com.G8.TP1_DSI_Grupo8.DAOG8;
import com.G8.TP1_DSI_Grupo8.entityG8.ContactoG8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoDAOG8 extends JpaRepository<ContactoG8, Long> {

}
