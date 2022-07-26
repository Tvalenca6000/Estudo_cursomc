package com.tvalenca.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvalenca.cursomc.domain.Categoria;

@Repository
public interface Categoria_Repository extends JpaRepository<Categoria, Integer> {
    
}
