package com.tvalenca.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvalenca.cursomc.domain.Cidade;

@Repository
public interface Cidade_Repository extends JpaRepository<Cidade, Integer> {
    
}
