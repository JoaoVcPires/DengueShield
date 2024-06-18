package controller;

import java.util.ArrayList;

import dao.EnderecoDAO;
import model.Endereco;

public class EnderecoController {
  EnderecoDAO enderecoDAO;
  BairroController bairroController;

  public EnderecoController() {
    enderecoDAO = new EnderecoDAO();
  }

  public boolean validarDadosDoEndereco(Endereco endereco) {
    bairroController = new BairroController();
    // Validar logradouro e numCasa

    if (!bairroController.validarBairroEscolhido(endereco.getIdBairro())) {
      System.out.println("Bairro escolhido inválido!");
      return false;
    }

    return true;
  }

  public ArrayList<Endereco> buscarListaDeEndereco() {
    return enderecoDAO.buscarListaDeEndereco();
  }

  public Endereco buscarUltimoEnderecoCadastrado() {
    ArrayList<Endereco> listaDeEnderecos = buscarListaDeEndereco();
    return listaDeEnderecos.get(listaDeEnderecos.size() - 1);
  }

  public void cadastrarEndereco(Endereco endereco) {
    enderecoDAO.insereEndereco(endereco);
  }

}
