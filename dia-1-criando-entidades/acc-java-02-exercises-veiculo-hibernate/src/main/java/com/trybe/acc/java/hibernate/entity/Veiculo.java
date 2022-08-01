package com.trybe.acc.java.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade Veículo.
 *
 */
@Entity
@Table
public class Veiculo {

  public long getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public long getAno() {
    return ano;
  }

  public void setAno(Integer ano) {
    this.ano = ano;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getQuilometragem() {
    return quilometragem;
  }

  public void setQuilometragem(String quilometragem) {
    this.quilometragem = quilometragem;
  }

  @Column
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column
  private long ano;

  @Column
  private String modelo;

  @Column
  private String quilometragem;
}
