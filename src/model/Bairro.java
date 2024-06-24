package model;

public class Bairro {
    private int idBairro;
    private String descricao;
    private int casosTotal;

    public Bairro(int idBairro, String descricao, int casosTotal) {
        this.idBairro = idBairro;
        this.descricao = descricao;
        this.casosTotal = casosTotal;
    }

    public Bairro(String descricao, int casosTotal) {
        this.descricao = descricao;
        this.casosTotal = casosTotal;
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

    public void mostrarDados() {
        System.out.println("Nome: " + this.descricao);
    }

}
