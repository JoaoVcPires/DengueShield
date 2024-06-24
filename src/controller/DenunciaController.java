package controller;

import java.util.ArrayList;

import dao.DenunciaDAO;
import model.Denuncia;

public class DenunciaController {
  DenunciaDAO denunciaDAO;

  public DenunciaController() {
    denunciaDAO = new DenunciaDAO();
  }

  public boolean validarDenuncia(Denuncia denuncia) {
    if (denuncia.getDescricao().isBlank() || denuncia.getDescricao().length() < 5) {
      System.out.println("Descrição da denúncia inválida!");
      return false;
    }

    return true;
  }

  public void arquivarDenuncia(int idDenuncia) {
    denunciaDAO.atualizarStatusDaDenuncia(idDenuncia);
  }

  public void cadastrarDenuncia(Denuncia denuncia) {
    if (validarDenuncia(denuncia)) {
      denunciaDAO.insereDenuncia(denuncia);
    }
  }

  public ArrayList<Denuncia> buscarListaDeDenunciaPorIdBairro(int idBairro) {
    return denunciaDAO.buscarListaDeDenunciaPorIdBairro(idBairro);
  }

  public Denuncia buscarDenunciaPorIdDenuncia(int idDenuncia, int idBairroDoAgente) {
    return denunciaDAO.buscarDenunciaPorIdDenuncia(idDenuncia, idBairroDoAgente);
  }

  public ArrayList<Denuncia> buscarListaDeDenunciasPorProprietario(int idProprietario) {
    return denunciaDAO.buscarListaDeDenunciasPorProprietario(idProprietario);
  }

  public void mostrarListaDeDenuncias(int idProprietario) {
    ArrayList<Denuncia> listaDeDenuncias = buscarListaDeDenunciasPorProprietario(idProprietario);

    if (listaDeDenuncias.isEmpty()) {
      System.out.println("Nenhuma denúncia realizada!");
      return;
    }

    for (Denuncia denuncia : listaDeDenuncias) {
      System.out.println(denuncia.getDescricao() + " - " + denuncia.getStatusDenuncia().getDescricao());
    }
  }

  public void mostrarListaDeDenunciasPorIdBairro(int idBairro) {
    ArrayList<Denuncia> listaDeDenuncias = buscarListaDeDenunciaPorIdBairro(idBairro);

    if (listaDeDenuncias.isEmpty()) {
      System.out.println("Nenhuma denúncia realizada nesse bairro!");
      return;
    }

    for (Denuncia denuncia : listaDeDenuncias) {
      System.out.println(denuncia.getIdDenuncia() + " - " + denuncia.getDescricao() + " - "
          + denuncia.getStatusDenuncia().getDescricao());
    }
  }
}
