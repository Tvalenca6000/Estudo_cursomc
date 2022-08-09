package com.tvalenca.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvalenca.cursomc.domain.Item_Pedido;

@Repository
public interface Item_Pedido_Repository extends JpaRepository<Item_Pedido, Integer> {
    
}
