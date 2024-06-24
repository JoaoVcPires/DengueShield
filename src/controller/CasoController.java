package controller;

import java.util.ArrayList;

import dao.CasoDAO;
import model.Caso;
import model.Endereco;
import model.InformacaoDetalhadaDeCaso;
import model.Vistoria;

public class CasoController {
  private CasoDAO casoDAO;
  private EnderecoController enderecoController;

  public CasoController() {
    casoDAO = new CasoDAO();
    enderecoController = new EnderecoController();
  }

  public boolean validarCaso(Caso caso, int idBairroDoAgente) {
    Endereco enderecoEscolhido = enderecoController.buscarEnderecoPorIdEnderecoEIdBairro(caso.getIdEndereco(),
        idBairroDoAgente);

    if (enderecoEscolhido == null) {
      System.out.println("Endereço escolhido inválido!");
      return false;
    } else if (caso.getDescricao().length() < 5) {
      System.out.println("Descrição inválida. Escreva uma descrição do caso adequada!");
      return false;
    }

    return true;
  }

  public void cadastrarNovoCaso(Caso caso, int idBairroDoAgente) {
    if (validarCaso(caso, idBairroDoAgente)) {
      casoDAO.inserirCaso(caso);
      casoDAO.atualizarQuantidadeDeCasosTotalNoBairro(idBairroDoAgente);
    }
  }

  public ArrayList<InformacaoDetalhadaDeCaso> buscarListaDeCasos() {
    return casoDAO.buscarListaDeCasos();
  }

  public void mostrarListaDeCasos() {
    ArrayList<InformacaoDetalhadaDeCaso> listaDeCasos = buscarListaDeCasos();

    if (listaDeCasos.isEmpty()) {
      System.out.println("Não há nenhum caso cadastrado!");
      return;
    }

    for (InformacaoDetalhadaDeCaso caso : listaDeCasos) {
      System.out.println(caso.getIdCaso() + " - " + caso.getDescricao());
      System.out.println(
          "Endereço: " + caso.getLogradouro() + ", " + caso.getBairroNome() + " - N°" + caso.getNumeroDaCasa());
      System.out.println("\n");
    }
  }
}
