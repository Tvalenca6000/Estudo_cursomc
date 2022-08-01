package com.tvalenca.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvalenca.cursomc.domain.Estado;

@Repository
public interface Estado_Repository extends JpaRepository<Estado, Integer> {
    
}
