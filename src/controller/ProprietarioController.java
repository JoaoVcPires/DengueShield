package controller;

import dao.ProprietarioDAO;
import model.Endereco;
import model.Proprietario;

public class ProprietarioController {
  ProprietarioDAO proprietarioDAO;
  EnderecoController enderecoController;

  public ProprietarioController() {
    proprietarioDAO = new ProprietarioDAO();
  }

  public boolean verificarSeNomeUsuarioEstaDisponivel(String nomeUsuario) {
    return true;
  }

  public boolean validarDadosDoProprietario(Proprietario proprietario) {
    // Validação dos dados

    if (!verificarSeNomeUsuarioEstaDisponivel(proprietario.getNomeUsuario())) {
      System.out.println("Nome de usuário indisponível!");
      return false;
    }

    return true;
  }

  public void cadastrarProprietarioNoBD(Proprietario proprietario, Endereco endereco) {
    enderecoController = new EnderecoController();

    if (validarDadosDoProprietario(proprietario) && enderecoController.validarDadosDoEndereco(endereco)) {
      enderecoController.cadastrarEndereco(endereco);
      Endereco ultimoEnderecoCadastrado = enderecoController.buscarUltimoEnderecoCadastrado();
      proprietario.setIdEndereco(ultimoEnderecoCadastrado.getIdEndereco());
      proprietarioDAO.inserirProprietario(proprietario);
    }
  }
}