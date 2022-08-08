package com.tvalenca.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvalenca.cursomc.domain.Pedido;

@Repository
public interface Pedido_Repository extends JpaRepository<Pedido, Integer>{
    
}
