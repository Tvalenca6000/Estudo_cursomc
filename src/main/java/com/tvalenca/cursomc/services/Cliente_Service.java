package com.tvalenca.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvalenca.cursomc.domain.Cliente;
import com.tvalenca.cursomc.repositories.Cliente_Repository;
import com.tvalenca.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class Cliente_Service {
    
    @Autowired
    private Cliente_Repository repo;

    public Cliente buscar(Integer id){
        Optional<Cliente> obj = repo.findById(id); 
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: "
                                     + Cliente.class.getName()));
    }
}