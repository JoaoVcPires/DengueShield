package model;

public class Agente extends Pessoa {
    private int idAgente;
    private String status;
    private int idBairro;

    public Agente(String nome, String cpf, String nomeUsuario, String senha, int idBairro) {
        super(nome, cpf, nomeUsuario, senha);
        this.idBairro = idBairro;
    }

    public Agente(String nome, String cpf, String nomeUsuario, String senha, int idAgente, int idBairro) {
        super(nome, cpf, nomeUsuario, senha);
        this.idBairro = idBairro;
        this.idAgente = idAgente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(int idAgente) {
        this.idAgente = idAgente;
    }

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

}
