package view;

import java.util.Scanner;

import controller.BairroController;
import controller.DenunciaController;
import controller.EnderecoController;
import model.Denuncia;
import model.Proprietario;

public class ProprietarioLogadoView {
  Proprietario proprietarioLogado;
  BairroController bairroController;
  EnderecoController enderecoController;
  DenunciaController denunciaController;

  public ProprietarioLogadoView(Proprietario proprietarioLogado) {
    this.proprietarioLogado = proprietarioLogado;
    bairroController = new BairroController();
    enderecoController = new EnderecoController();
    denunciaController = new DenunciaController();
  }

  public void denunciarEndereco() {
    Scanner scanner = new Scanner(System.in);

    bairroController.mostrarListaDeBairros();
    System.out.print("Escolha um dos bairros acima: ");
    int idBairro = scanner.nextInt();

    enderecoController.mostrarListaDeEnderecosPorBairro(idBairro);

    if (!enderecoController.buscarListaDeEnderecoPorBairro(idBairro).isEmpty()) {
      System.out.print("Escolha um dos endereços acima: ");
      int idEndereco = scanner.nextInt();

      scanner.nextLine();

      System.out.println("Descrição da denúncia: ");
      String descricao = scanner.nextLine();

      Denuncia denuncia = new Denuncia(descricao, idEndereco, proprietarioLogado.getIdProprietario());
      denunciaController.cadastrarDenuncia(denuncia);
    } else {
      System.out.println("Nesse bairro não possui nenhum endereço cadastrado. Por favor, selecione outro bairro.");
      denunciarEndereco();
    }
  }

  public void exibirMenuDeDenuncias() {
    Scanner scanner = new Scanner(System.in);
    int escolha = 0;

    while (escolha != 3) {
      System.out.println("******MENU DE DENÚNCIAS - PROPRIETÁRIO******");
      System.out.println("1 - Denunciar endereço");
      System.out.println("2 - Minhas denúncias");
      System.out.println("3 - Voltar");
      System.out.print("Escolha uma das opções acima: ");
      escolha = scanner.nextInt();

      scanner.nextLine();

      switch (escolha) {
        case 1:
          denunciarEndereco();
          break;
        case 2:
          denunciaController.mostrarListaDeDenuncias(proprietarioLogado.getIdProprietario());
          break;
        case 3:
          break;
        default:
          System.out.println("Opção inválida!");
      }
    }
  }

  public void exibirMenuPrincipal() {
    Scanner scanner = new Scanner(System.in);

    int escolha = 0;

    while (escolha != 3) {
      System.out.println("******MENU PRINCIPAL - PROPRIETÁRIO******");
      System.out.println("1 - Denúncias");
      System.out.println("2 - Visualizar casos de cada bairro");
      System.out.println("3 - Sair da conta");
      System.out.print("Escolha uma das opções acima: ");
      escolha = scanner.nextInt();

      switch (escolha) {
        case 1:
          exibirMenuDeDenuncias();
          break;
        case 2:
          bairroController.mostrarQuantidadeDeCasosDeCadaBairro();
          break;
        case 3:
          break;
        default:
          System.out.println("Opção inválida!");
      }
    }
  }
}
