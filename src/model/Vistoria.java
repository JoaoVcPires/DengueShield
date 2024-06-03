package model;

import java.sql.Date;

public class Vistoria {
  private int idVistoria;
  private int idAgente;
  private int idEndereco;
  private Date dataDaVisita;
  private String descricao;

  public Vistoria(int idVistoria, int idAgente, int idEndereco, Date dataDaVisita, String descricao) {
    this.idVistoria = idVistoria;
    this.idAgente = idAgente;
    this.idEndereco = idEndereco;
    this.dataDaVisita = dataDaVisita;
    this.descricao = descricao;
  }

  public int getIdVistoria() {
    return idVistoria;
  }

  public void setIdVistoria(int idVistoria) {
    this.idVistoria = idVistoria;
  }

  public int getIdAgente() {
    return idAgente;
  }

  public void setIdAgente(int idAgente) {
    this.idAgente = idAgente;
  }

  public int getIdEndereco() {
    return idEndereco;
  }

  public void setIdEndereco(int idEndereco) {
    this.idEndereco = idEndereco;
  }

  public Date getDataDaVisita() {
    return dataDaVisita;
  }

  public void setDataDaVisita(Date dataDaVisita) {
    this.dataDaVisita = dataDaVisita;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}
