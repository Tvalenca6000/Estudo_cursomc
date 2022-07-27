package com.tvalenca.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvalenca.cursomc.domain.Produto;

@Repository
public interface Produto_Repository extends JpaRepository<Produto, Integer>{
    
}
