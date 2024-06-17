package controller;

import dao.EnderecoDAO;
import model.Endereco;

public class EnderecoController {
  EnderecoDAO enderecoDAO;

  public EnderecoController() {
    enderecoDAO = new EnderecoDAO();
  }

  public boolean validarDados(String logradouro, int numCasa, int idBairro) {
    // Validar logradouro e numCasa

    // Verificar se o idBairro escolhido é algum dos bairros cadastrados
    return true;
  }

  public void cadastrarEndereco(Endereco endereco) {
    String logradouro = endereco.getLogradouro();
    int numCasa = endereco.getNumCasa();
    int focoDengue = endereco.getfocoDengue() == true ? 1 : 0;
    int idBairro = endereco.getIdBairro();

    System.out.println("Dados validados!");

    if (validarDados(logradouro, numCasa, idBairro)) {
      enderecoDAO.insereEndereco(logradouro, numCasa, focoDengue, idBairro);
    } else {
      System.out.println("Dados do endereço inválidos. Por favor preencha novamente com atenção!");
    }

  }

}
