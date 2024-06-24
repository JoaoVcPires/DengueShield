package controller;

import dao.AgenteDAO;
import model.Agente;

public class AgenteController {
  AgenteDAO agenteDAO;

  public AgenteController() {
    agenteDAO = new AgenteDAO();
  }

  public Agente buscarAgentePorUsuarioESenha(String usuario, String senha) {
    return agenteDAO.buscarAgenteParaValidarLogin(usuario, senha);
  }

  public boolean validarLogin(String usuario, String senha) {
    boolean loginInvalido = buscarAgentePorUsuarioESenha(usuario, senha) == null;

    if (loginInvalido) {
      System.out.println("Usuário ou senha inválidos!");
      return false;
    }
    return true;
  }

  public Agente realizarLogin(String usuario, String senha) {
    if (validarLogin(usuario, senha)) {
      Agente agente = buscarAgentePorUsuarioESenha(usuario, senha);
      System.out.println("Seja Bem-vindo Agente " + agente.getNome());
      return agente;
    }

    return null;
  }
}
