package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import dao.VistoriaDAO;
import model.Denuncia;
import model.Endereco;
import model.Vistoria;

public class VistoriaController {
  private VistoriaDAO vistoriaDAO;
  private EnderecoController enderecoController;
  private DenunciaController denunciaController;

  public VistoriaController() {
    vistoriaDAO = new VistoriaDAO();
    enderecoController = new EnderecoController();
    denunciaController = new DenunciaController();
  }

  public boolean validarVistoria(Vistoria vistoria, int idBairroDoAgente) {
    Endereco enderecoEscolhido = enderecoController.buscarEnderecoPorIdEnderecoEIdBairro(vistoria.getIdEndereco(),
        idBairroDoAgente);

    if (enderecoEscolhido == null) {
      System.out.println("Endereço escolhido inválido!");
      return false;
    } else if (vistoria.getDescricao().length() < 10) {
      System.out.println("Descrição inválida. Escreva uma descrição da vistoria adequada!");
      return false;
    }

    return true;
  }

  public Denuncia validarDenunciaEscolhidaParaFazerVistoria(int idDenuncia, int idBairroDoAgente) {
    Denuncia denunciaEscolhida = denunciaController.buscarDenunciaPorIdDenuncia(idDenuncia, idBairroDoAgente);

    if (denunciaEscolhida == null) {
      System.out.println("Denúncia escolhida inválida!");
      return denunciaEscolhida;
    }

    return denunciaEscolhida;
  }

  public void cadastrarNovaVistoria(Vistoria vistoria, int idBairroDoAgente) {
    boolean vistoriaValida = validarVistoria(vistoria, idBairroDoAgente);

    if (vistoriaValida) {
      vistoriaDAO.inserirVistoria(vistoria);
    }
  }

  public void cadastrarNovaVistoria(Vistoria vistoria, int idBairroDoAgente, int idDenuncia) {
    boolean vistoriaValida = validarVistoria(vistoria, idBairroDoAgente);

    if (vistoriaValida) {
      vistoriaDAO.inserirVistoria(vistoria);
      denunciaController.arquivarDenuncia(idDenuncia);
    }
  }

  public ArrayList<Vistoria> buscarListaDeVistoriasPorIdAgente(int idAgente) {
    return vistoriaDAO.buscarListaDeVistoriasPorIdAgente(idAgente);
  }

  public void mostrarListaDeVistoriasPorAgente(int idAgente) {
    ArrayList<Vistoria> listaDeVistorias = buscarListaDeVistoriasPorIdAgente(idAgente);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    if (listaDeVistorias.isEmpty()) {
      System.out.println("Você não possui nenhuma vistoria!");
      return;
    }

    for (Vistoria vistoria : listaDeVistorias) {
      Endereco endereco = enderecoController.buscarEnderecoPorIdEndereco(vistoria.getIdEndereco());
      System.out.println("Descrição: " + vistoria.getDescricao());
      System.out.println("Data: " + dateFormat.format(vistoria.getDataDaVisita()));
      System.out.println("Endereço: " + endereco.getLogradouro() + " - " + "N°" + endereco.getNumCasa());
      System.out.println("\n");
    }
  }

}
