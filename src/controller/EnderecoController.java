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

  public Endereco buscarEnderecoPorIdEndereco(int idEndereco) {
    return enderecoDAO.buscarEnderecoPorIdEndereco(idEndereco);
  }

  public Endereco buscarEnderecoPorIdEnderecoEIdBairro(int idEnderecoEscolhido, int idBairroDoAgente) {
    return enderecoDAO.buscarEnderecoPorIdEnderecoEIdBairro(idEnderecoEscolhido, idBairroDoAgente);
  }

  public boolean validarDadosDoEndereco(Endereco endereco) {
    bairroController = new BairroController();

    if (!bairroController.validarBairroEscolhido(endereco.getIdBairro())) {
      System.out.println("Bairro escolhido inválido!");
      return false;
    }

    if (endereco.getLogradouro().isBlank() || endereco.getLogradouro().length() < 5) {
      System.out.println("Logradouro inválido!");
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

  public ArrayList<Endereco> buscarListaDeEnderecoPorBairro(int idBairro) {
    return enderecoDAO.buscarListaDeEnderecoPorBairro(idBairro);
  }

  public void mostrarListaDeEnderecosPorBairro(int idBairro) {
    ArrayList<Endereco> listaDeEnderecoPorBairro = buscarListaDeEnderecoPorBairro(idBairro);

    for (Endereco endereco : listaDeEnderecoPorBairro) {
      System.out.println(endereco.getIdEndereco() + " - " + endereco.getLogradouro() + ", N° " + endereco.getNumCasa());
    }
  }
}
