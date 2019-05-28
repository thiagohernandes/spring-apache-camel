package com.br.camel.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pessoas")
@XmlAccessorType (XmlAccessType.FIELD)
public class PessoasDTOXML {

	@XmlElement(name = "pessoa")
    private List<PessoaDTOXML> pessoas = null;
 
    public List<PessoaDTOXML> getPessoas() {
        return pessoas;
    }
 
    public void setPessoas(List<PessoaDTOXML> pessoas) {
        this.pessoas = pessoas;
    }
}
