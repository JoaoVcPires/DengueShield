package controller;

import java.util.ArrayList;

import dao.BairroDAO;
import model.Bairro;

public class BairroController {
  BairroDAO bairroDAO;

  public BairroController() {
    bairroDAO = new BairroDAO();
  }

  public boolean validarBairroEscolhido(int idBairro) {
    ArrayList<Bairro> listaDeBairro = bairroDAO.buscarListaDeBairros();

    for (Bairro bairro : listaDeBairro) {
      if (bairro.getIdBairro() == idBairro) {
        return true;
      }
    }

    return false;
  }

  public void mostrarListaDeBairros() {
    ArrayList<Bairro> listaDeBairro = bairroDAO.buscarListaDeBairros();

    for (Bairro bairro : listaDeBairro) {
      System.out.println(bairro.getIdBairro() + " - " + bairro.getDescricao());
    }
  }
}
