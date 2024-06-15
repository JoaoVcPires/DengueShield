package Controller;

import java.util.ArrayList;

import DAO.BairroDAO;
import model.Bairro;

public class BairroController {
  BairroDAO bairroDAO;

  public BairroController() {
    bairroDAO = new BairroDAO();
  }

  public void mostrarListaDeBairros() {
    ArrayList<Bairro> listaDeBairro = bairroDAO.buscarBairros();

    for (Bairro bairro : listaDeBairro) {
      System.out.println(bairro.getIdBairro() + " - " + bairro.getDescricao());
    }
  }
}
