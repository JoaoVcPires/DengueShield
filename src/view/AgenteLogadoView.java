package view;

import java.util.Date;
import java.util.Scanner;

import controller.CasoController;
import controller.DenunciaController;
import controller.EnderecoController;
import controller.VistoriaController;
import model.Agente;
import model.Caso;
import model.Denuncia;
import model.Vistoria;

public class AgenteLogadoView {
  private Agente agenteLogado;
  private EnderecoController enderecoController;
  private VistoriaController vistoriaController;
  private CasoController casoController;
  private DenunciaController denunciaController;

  public AgenteLogadoView(Agente agenteLogado) {
    this.agenteLogado = agenteLogado;
    this.enderecoController = new EnderecoController();
    this.vistoriaController = new VistoriaController();
    this.casoController = new CasoController();
    this.denunciaController = new DenunciaController();
  }

  public void realizarNovaVistoria() {
    Scanner scanner = new Scanner(System.in);
    enderecoController.mostrarListaDeEnderecosPorBairro(agenteLogado.getIdBairro());
    System.out.print("Escolha qual endereço irá realizar a vistoria: ");
    int idEndereco = scanner.nextInt();

    scanner.nextLine();

    System.out.println("Descrição da vistoria: ");
    String descricao = scanner.nextLine();

    Vistoria vistoria = new Vistoria(agenteLogado.getIdAgente(), idEndereco, new Date(), descricao);
    vistoriaController.cadastrarNovaVistoria(vistoria, agenteLogado.getIdBairro());
  }

  public void realizarNovaVistoria(Denuncia denuncia) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Descrição da vistoria: ");
    String descricao = scanner.nextLine();

    Vistoria vistoria = new Vistoria(agenteLogado.getIdAgente(), denuncia.getIdEndereco(), new Date(), descricao);
    vistoriaController.cadastrarNovaVistoria(vistoria, agenteLogado.getIdBairro(), denuncia.getIdDenuncia());
  }

  public void exibirMenuDeVistorias() {
    Scanner scanner = new Scanner(System.in);
    int escolha = 0;

    while (escolha != 3) {
      System.out.println("******MENU DE VISTORIAS - AGENTE******");
      System.out.println("1 - Realizar nova vistoria");
      System.out.println("2 - Visualizar vistorias");
      System.out.println("3 - Voltar");

      System.out.print("Escolha uma das opções acima: ");
      escolha = scanner.nextInt();

      switch (escolha) {
        case 1:
          realizarNovaVistoria();
          break;
        case 2:
          vistoriaController.mostrarListaDeVistoriasPorAgente(agenteLogado.getIdAgente());
          break;
        case 3:
          break;
        default:
          System.out.println("Opção inválida!");
      }
    }
  }

  public void cadastrarNovoCaso() {
    Scanner scanner = new Scanner(System.in);

    enderecoController.mostrarListaDeEnderecosPorBairro(agenteLogado.getIdBairro());
    System.out.print("Escolha qual endereço está o novo caso: ");
    int idEndereco = scanner.nextInt();

    scanner.nextLine();

    System.out.println("Descrição do caso: ");
    String descricao = scanner.nextLine();

    Caso caso = new Caso(descricao, idEndereco);
    casoController.cadastrarNovoCaso(caso, agenteLogado.getIdBairro());
  }

  public void exibirMenuDeCasos() {
    Scanner scanner = new Scanner(System.in);
    int escolha = 0;

    while (escolha != 3) {
      System.out.println("******MENU DE CASOS - AGENTE******");
      System.out.println("1 - Cadastrar novo caso");
      System.out.println("2 - Visualizar casos GERAL");
      System.out.println("3 - Voltar");

      System.out.print("Escolha uma das opções acima: ");
      escolha = scanner.nextInt();

      switch (escolha) {
        case 1:
          cadastrarNovoCaso();
          break;
        case 2:
          casoController.mostrarListaDeCasos();
          break;
        case 3:
          break;
        default:
          System.out.println("Opção inválida!");
      }
    }
  }

  public void realizarVistoriaApartirDeUmaDenuncia() {
    Scanner scanner = new Scanner(System.in);

    denunciaController.mostrarListaDeDenunciasPorIdBairro(agenteLogado.getIdBairro());
    System.out
        .print("Escolha uma denúncia para realizar uma vistoria a partir dela(IRÁ MUDAR O STATUS PARA ARQUIVADA): ");
    int idDenuncia = scanner.nextInt();

    Denuncia denunciaEscolhida = vistoriaController.validarDenunciaEscolhidaParaFazerVistoria(idDenuncia,
        agenteLogado.getIdBairro());

    if (denunciaEscolhida != null) {
      if (denunciaEscolhida.getStatusDenuncia().getDescricao() == "Arquivada") {
        System.out.println("Essa denúncia ja foi arquivada. Não é possível realizar uma vistoria a partir dela!");
        return;
      }

      realizarNovaVistoria(denunciaEscolhida);
    }
  }

  public void exibirMenuDeDenuncias() {
    Scanner scanner = new Scanner(System.in);
    int escolha = 0;

    while (escolha != 3) {
      System.out.println("******MENU DE DENÚNCIAS - AGENTE******");
      System.out.println("1 - Visualizar denúncias do bairro");
      System.out.println("2 - Realizar vistoria a partir de uma denúncia");
      System.out.println("3 - Voltar");

      System.out.print("Escolha uma das opções acima: ");
      escolha = scanner.nextInt();

      switch (escolha) {
        case 1:
          denunciaController.mostrarListaDeDenunciasPorIdBairro(agenteLogado.getIdBairro());
          break;
        case 2:
          realizarVistoriaApartirDeUmaDenuncia();
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

    while (escolha != 4) {
      System.out.println("******MENU PRINCIPAL - AGENTE******");
      System.out.println("1 - Vistorias");
      System.out.println("2 - Casos de dengue");
      System.out.println("3 - Denúncias");
      System.out.println("4 - Sair");

      System.out.print("Escolha uma das opções acima: ");
      escolha = scanner.nextInt();

      switch (escolha) {
        case 1:
          exibirMenuDeVistorias();
          break;
        case 2:
          exibirMenuDeCasos();
          break;
        case 3:
          exibirMenuDeDenuncias();
          break;
        case 4:
          break;
        default:
          System.out.println("Opção inválida!");
      }
    }
  }
}
