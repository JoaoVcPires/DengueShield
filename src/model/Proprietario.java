package model;

public class Proprietario extends Pessoa {
    private int idProprietario;
    private int idEndereco;

    public Proprietario(String nome, String cpf, String nomeUsuario, String senha) {
        super(nome, cpf, nomeUsuario, senha);
    }

    public Proprietario(String nome, String cpf, String nomeUsuario, String senha, int idProprietario, int idEndereco) {
        super(nome, cpf, nomeUsuario, senha);
        this.idProprietario = idProprietario;
        this.idEndereco = idEndereco;
    }

    public Proprietario(String nome, String cpf, String nomeUsuario, String senha, int idEndereco) {
        super(nome, cpf, nomeUsuario, senha);
        this.idEndereco = idEndereco;
    }

    public int getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(int idProprietario) {
        this.idProprietario = idProprietario;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

}