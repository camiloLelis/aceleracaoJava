package com.trybe.acc.java.datacenter.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Aplicacao {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private String descricao;

  @ManyToMany(mappedBy = "aplicacoes")
  private Set<Servidor> servidores;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setNome(String string) {
    this.nome = string;
  }
  
  public String getNome() {
    return this.nome;
  }
  
  public void setDescricao(String string) {
    this.descricao = string;
  }

  public String getDescricao() {
    return this.descricao;
  }

}
