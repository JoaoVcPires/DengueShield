package view;

import java.util.Scanner;

import controller.AgenteController;
import model.Agente;

public class AgenteView {
  AgenteController agenteController;
  Scanner scanner;
  AgenteLogadoView agenteLogadoView;

  public AgenteView() {
    agenteController = new AgenteController();
    scanner = new Scanner(System.in);
  }

  public void interfaceInicial() {
    int escolha = 0;

    while (escolha != 2) {
      System.out.println("******AGENTE******");
      System.out.println("1 - Login");
      System.out.println("2 - Voltar");
      System.out.print("Escolha uma das opções acima: ");
      escolha = scanner.nextInt();

      switch (escolha) {
        case 1:
          login();
          break;
        case 2:
          break;
        default:
          System.out.println("Opção inválida!");
      }
    }
  }

  public void login() {
    System.out.print("Usuário: ");
    String usuario = scanner.next();

    System.out.print("Senha: ");
    String senha = scanner.next();

    Agente agenteLogado = agenteController.realizarLogin(usuario, senha);

    if (agenteLogado != null) {
      agenteLogadoView = new AgenteLogadoView(agenteLogado);
      agenteLogadoView.exibirMenuPrincipal();
    }
  }
}
