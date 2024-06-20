package controller;

import dao.DenunciaDAO;
import model.Denuncia;

public class DenunciaController {
  DenunciaDAO denunciaDAO;

  public DenunciaController() {
    denunciaDAO = new DenunciaDAO();
  }

  public boolean validarDenuncia(Denuncia denuncia) {
    // if (denuncia.getDescricao().isBlank() || denuncia.getDescricao().length() >
    // 5) {
    // System.out.println("Descrição da denúncia inválida!");
    // return false;
    // }

    return true;
  }

  public void cadastrarDenuncia(Denuncia denuncia) {
    if (validarDenuncia(denuncia)) {
      denunciaDAO.insereDenuncia(denuncia);
    }
  }
}
