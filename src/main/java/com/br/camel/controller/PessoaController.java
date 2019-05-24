package com.br.camel.controller;

import com.br.camel.domain.Pessoa;
import com.br.camel.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * Controller auxiliar de Pessoas
 * @author Thiago Hernandes de Souza
 * @since 23-05-2019
 */

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    PessoaService service;

    @GetMapping(value = "/all")
    public List<Pessoa > getAll(){
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    public Pessoa getById(@PathVariable("id") int id){
        return service.getById(id);
    }

}
