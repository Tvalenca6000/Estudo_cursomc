package com.tvalenca.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvalenca.cursomc.domain.Pedido;
import com.tvalenca.cursomc.repositories.Pedido_Repository;
import com.tvalenca.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class Pedido_Service {
    
    @Autowired
    private Pedido_Repository repo;

    public Pedido buscar(Integer id){
        Optional<Pedido> obj = repo.findById(id); 
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: "
                                     + Pedido.class.getName()));
    }
}