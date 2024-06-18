package controller;

import dao.AgenteDAO;

public class AgenteController {
  AgenteDAO agenteDAO;

  public AgenteController() {
    agenteDAO = new AgenteDAO();
  }

  public boolean validarLogin(String usuario, String senha) {
    boolean loginInvalido = agenteDAO.buscarAgenteParaValidarLogin(usuario, senha) == null;

    if (loginInvalido) {
      System.out.println("Usuário ou senha inválidos!");
      return false;
    }
    return true;
  }

  public void realizarLogin(String usuario, String senha) {
    if (validarLogin(usuario, senha)) {
      System.out.println("Seja Bem-vindo Agente " + usuario);
    }
  }
}
