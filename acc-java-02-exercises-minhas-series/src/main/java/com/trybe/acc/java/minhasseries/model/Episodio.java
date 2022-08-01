package com.trybe.acc.java.minhasseries.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Episodio {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private Integer numero;
  private Integer duracaoEmMinutos;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "serie_id", nullable = false)
  @JsonBackReference
  private Serie serie;

  /**
   * construtor basico.
   */
  public Episodio(Integer episodio, Integer duracao) {
    this.numero = episodio;
    this.duracaoEmMinutos = duracao;
  }

  /**
   * construtor com todos atributos.
   */
  public Episodio(Integer id, Integer episodio, Integer duracao, Serie serie) {
    this.id = id;
    this.numero = episodio;
    this.duracaoEmMinutos = duracao;
    this.serie = serie;
  }

  /**
   * construtor 3 atributo.
   */
  public Episodio(Integer episodio, Integer duracao, Serie serie) {
    this.numero = episodio;
    this.duracaoEmMinutos = duracao;
    this.serie = serie;
  }

  public Episodio() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public Integer getDuracaoEmMinutos() {
    return duracaoEmMinutos;
  }

  public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
    this.duracaoEmMinutos = duracaoEmMinutos;
  }

  public Serie getSerie() {
    return serie;
  }

  public void setSerie(Serie serie) {
    this.serie = serie;
  }

}
