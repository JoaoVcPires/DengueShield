package controller;

import model.Proprietario;

public class ProprietarioController {
  ProprietarioController proprietarioController;

  public ProprietarioController() {
    proprietarioController = new ProprietarioController();
  }

  public boolean validarDados() {

    return true;
  }

  public void cadastrarProprietarioNoBD(Proprietario proprietario) {
    String nome = proprietario.getNome();
    String cpf = proprietario.getCpf();
    String nomeUsuario = proprietario.getNomeUsuario();
    String senha = proprietario.getSenha();
    int idEndereco = proprietario.getIdEndereco();
  }
}