package model;

import statusEnum.StatusDeDenuncia;
import statusEnum.StatusDeDenuncia.SelectStatus;

public class Denuncia {
    private int idDenuncia;
    private String descricao;
    private int idEndereco;
    private int idProprietario;

    private StatusDeDenuncia.SelectStatus statusDenuncia;

    public Denuncia(int idDenuncia, String descricao, int idEndereco, int idProprietario, SelectStatus statusDenuncia) {
        this.idDenuncia = idDenuncia;
        this.descricao = descricao;
        this.idEndereco = idEndereco;
        this.idProprietario = idProprietario;
        this.statusDenuncia = statusDenuncia;
    }

    public Denuncia(String descricao, int idEndereco, int idProprietario) {
        this.descricao = descricao;
        this.idEndereco = idEndereco;
        this.idProprietario = idProprietario;

        this.statusDenuncia = StatusDeDenuncia.SelectStatus.PENDENTE;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(int idProprietario) {
        this.idProprietario = idProprietario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusDeDenuncia.SelectStatus getStatusDenuncia() {
        return statusDenuncia;
    }

    public void setStatusDenuncia(StatusDeDenuncia.SelectStatus statusDenuncia) {
        this.statusDenuncia = statusDenuncia;
    }

    public void dadosDenuncia() {
        System.out.println("Informações da denuncia:");
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Status: " + this.getStatusDenuncia());
    }

    public int getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(int idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

}