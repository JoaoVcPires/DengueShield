package model;

public class Endereco {
    private int idEndereco;
    private String logradouro;
    private int numCasa;
    private boolean focoDengue;
    private int idBairro;

    public Endereco(String logradouro, int numCasa, int idBairro) {
        this.logradouro = logradouro;
        this.numCasa = numCasa;
        this.focoDengue = false;
        this.idBairro = idBairro;
    }

    public Endereco(int idEndereco, String logradouro, int numCasa, int idBairro, boolean focoDengue) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.numCasa = numCasa;
        this.focoDengue = focoDengue;
        this.idBairro = idBairro;
    }

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    public boolean isFocoDengue() {
        return focoDengue;
    }

    public void setFocoDengue(boolean focoDengue) {
        this.focoDengue = focoDengue;
    }

}
