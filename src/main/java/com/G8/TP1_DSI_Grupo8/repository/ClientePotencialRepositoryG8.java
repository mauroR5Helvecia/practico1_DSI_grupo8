package com.G8.TP1_DSI_Grupo8.repository;

import com.G8.TP1_DSI_Grupo8.entity.ClientePotencialG8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePotencialRepositoryG8 extends JpaRepository<ClientePotencialG8, Long> {
}
