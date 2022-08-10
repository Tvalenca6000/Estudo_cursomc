package com.tvalenca.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tvalenca.cursomc.domain.Pedido;
import com.tvalenca.cursomc.services.Pedido_Service;

@RestController
@RequestMapping(value="/pedidos")
public class Pedido_Resource {

    @Autowired
    private Pedido_Service service;
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> Listar(@PathVariable Integer id){
        Pedido obj = service.buscar(id);

        return ResponseEntity.ok().body(obj);
    }
}
