package model;

public class Caso {
    private int idCaso;
    private String descricao;
    private int idEndereco;

    public Caso(String descricao, int idEndereco, int idCaso) {
        this.descricao = descricao;
        this.idEndereco = idEndereco;
        this.idCaso = idCaso;
    }

    public Caso(String descricao, int idEndereco) {
        this.descricao = descricao;
        this.idEndereco = idEndereco;
    }

    public Caso(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(int idCaso) {
        this.idCaso = idCaso;
    }

}
