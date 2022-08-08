package com.tvalenca.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvalenca.cursomc.domain.Pagamento;

@Repository
public interface Pagamento_Repository extends JpaRepository<Pagamento, Integer>{
    
}
