package model;

public class Bairro {
    private int idBairro;
    private String descricao;
    private int casosTotal;
    private int idAgente;

    public Bairro(int idBairro, String descricao, int casosTotal, int idAgente) {
        this.idBairro = idBairro;
        this.descricao = descricao;
        this.casosTotal = casosTotal;
        this.idAgente = idAgente;
    }

    public Bairro(String descricao, int casosTotal, int idAgente) {
        this.descricao = descricao;
        this.casosTotal = casosTotal;
        this.idAgente = idAgente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    public int getCasosTotal() {
        return casosTotal;
    }

    public void setCasosTotal(int casosTotal) {
        this.casosTotal = casosTotal;
    }

    public int getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(int idAgente) {
        this.idAgente = idAgente;
    }

    public void mostrarDados() {
        System.out.println("Nome: " + this.descricao);
    }

}
