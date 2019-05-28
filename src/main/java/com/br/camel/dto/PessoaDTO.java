package com.br.camel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/* DTO Pessoa
* @author Thiago Hernandes de Souza
* @since 23-05-2019
*/
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"id","nome","idade","salario"})
public class PessoaDTO {

   @JsonProperty(value = "id")
   private int id;
   @JsonProperty(value = "nome")
   private String nome;
   @JsonProperty(value = "idade")
   private int idade;
   @JsonProperty(value = "salario")
   private Double salario;

   public PessoaDTO(){}

   public PessoaDTO(int id, String nome, int idade, Double salario) {
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

