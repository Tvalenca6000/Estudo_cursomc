package com.tvalenca.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvalenca.cursomc.domain.Endereco;

@Repository
public interface Endereco_Repository extends JpaRepository<Endereco, Integer> {
    
}
