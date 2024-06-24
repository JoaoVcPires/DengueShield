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
    if (proprietarioDAO.buscarProprietarioPorNomeDeUsuario(nomeUsuario) != null) {
      return false;
    }

    return true;
  }

  public Proprietario validarLogin(String nomeUsuario, String senha) {
    Proprietario proprietario = proprietarioDAO.buscarProprietarioParaValidarLogin(nomeUsuario, senha);
    boolean loginInvalido = proprietario == null;

    if (loginInvalido) {
      System.out.println("Usuário ou senha inválidos!");
      return null;
    }

    return proprietario;
  }

  public Proprietario realizarLogin(String nomeUsuario, String senha) {
    Proprietario proprietario = validarLogin(nomeUsuario, senha);

    if (proprietario != null) {
      System.out.println("Seja Bem-vindo ao DengueShield " + nomeUsuario);
      return proprietario;
    }

    return null;
  }

  public boolean validarDadosDoProprietario(Proprietario proprietario) {
    if (!verificarSeNomeUsuarioEstaDisponivel(proprietario.getNomeUsuario())) {
      System.out.println("Nome de usuário indisponível!");
      return false;
    }
    if (proprietario.getNome().length() < 3) {
      System.out.println("Digite um nome com mais de 3 caracteres!");
      return false;
    }
    if (proprietario.getSenha().length() <= 5) {
      System.out.println("Digite uma senha com mais de 5 caracteres!");
      return false;
    }
    if (proprietario.getCpf().replaceAll("[^\\d]", "").length() != 11) {
      System.out.println("Digite um CPF válido!");
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
      System.out.println("Cadastro realizado com sucesso!");
    }
  }
}