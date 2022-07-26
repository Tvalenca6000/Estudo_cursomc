package com.tvalenca.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvalenca.cursomc.domain.Categoria;
import com.tvalenca.cursomc.repositories.Categoria_Repository;

@Service
public class Categoria_Service {
    
    @Autowired
    private Categoria_Repository repo;

    public Categoria buscar(Integer id){
        Optional<Categoria> obj = repo.findById(id); 
        return obj.orElse(null);
    }
}