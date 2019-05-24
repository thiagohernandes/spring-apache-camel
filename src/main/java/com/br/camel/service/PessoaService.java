package com.br.camel.service;

import com.br.camel.domain.Pessoa;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PessoaService {

    List<Pessoa> listaPessoas = Arrays.asList(new Pessoa(1, "Beltrano", 33, 6000.0),
                                                     new Pessoa(2, "Ciclano", 41, 7000.0),
                                                     new Pessoa(3, "Delano", 23, 8000.0),
                                                     new Pessoa(4, "Alana", 27, 7500.0));

    public List<Pessoa> getAll() {
        return listaPessoas;
    }

    public Pessoa getById(int id){
        final Pessoa[] pessoa = {new Pessoa()};
        pessoa[0] = null;
        listaPessoas.stream().forEach(i -> {
            if(i.getId() == id) {
                pessoa[0] = i;
            }
        });
        return pessoa[0];
    }

}
