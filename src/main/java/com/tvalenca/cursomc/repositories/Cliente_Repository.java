package com.tvalenca.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvalenca.cursomc.domain.Cliente;

@Repository
public interface Cliente_Repository extends JpaRepository<Cliente, Integer> {
    
}
