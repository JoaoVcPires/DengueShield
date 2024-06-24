package model;

public class InformacaoDetalhadaDeCaso {
  private int idCaso;
  private String descricao;
  private String logradouro;
  private String bairroNome;
  private int numeroDaCasa;

  public InformacaoDetalhadaDeCaso(int idCaso, String descricao, String logradouro, String bairroNome,
      int numeroDaCasa) {
    this.idCaso = idCaso;
    this.descricao = descricao;
    this.logradouro = logradouro;
    this.bairroNome = bairroNome;
    this.numeroDaCasa = numeroDaCasa;
  }

  public int getIdCaso() {
    return idCaso;
  }

  public void setIdCaso(int idCaso) {
    this.idCaso = idCaso;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getBairroNome() {
    return bairroNome;
  }

  public void setBairroNome(String bairroNome) {
    this.bairroNome = bairroNome;
  }

  public int getNumeroDaCasa() {
    return numeroDaCasa;
  }

  public void setNumeroDaCasa(int numeroDaCasa) {
    this.numeroDaCasa = numeroDaCasa;
  }

}
