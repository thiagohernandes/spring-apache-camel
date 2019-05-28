package com.br.camel.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pessoa")
@XmlAccessorType (XmlAccessType.FIELD)
public class PessoaDTOXML {
	 private int id;
	    private String nome;
	    private int idade;
	    private Double salario;

	    public PessoaDTOXML(){}

	    public PessoaDTOXML(int id, String nome, int idade, Double salario) {
	        this.id = id;
	        this.nome = nome;
	        this.idade = idade;
	        this.salario = salario;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public int getIdade() {
	        return idade;
	    }

	    public void setIdade(int idade) {
	        this.idade = idade;
	    }

	    public Double getSalario() {
	        return salario;
	    }

	    public void setSalario(Double salario) {
	        this.salario = salario;
	    }

	}

