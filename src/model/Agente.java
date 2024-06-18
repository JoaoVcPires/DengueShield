package model;

public class Agente extends Pessoa {
    private int idAgente;
    private String status;

    public Agente(String nome, String cpf, String nomeUsuario, String senha) {
        super(nome, cpf, nomeUsuario, senha);
    }

    public Agente(String nome, String cpf, String nomeUsuario, String senha, int idAgente) {
        super(nome, cpf, nomeUsuario, senha);
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

}
