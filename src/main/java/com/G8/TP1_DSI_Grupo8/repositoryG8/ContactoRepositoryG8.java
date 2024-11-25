package com.G8.TP1_DSI_Grupo8.repositoryG8;
import com.G8.TP1_DSI_Grupo8.entityG8.ContactoG8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepositoryG8 extends JpaRepository<ContactoG8, Long> {

}
