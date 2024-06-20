package view;

import java.util.Scanner;

import controller.BairroController;
import controller.ProprietarioController;
import model.Endereco;
import model.Proprietario;

public class ProprietarioView {
  Scanner scanner;
  BairroController bairroController;
  ProprietarioController proprietarioController;
  ProprietarioLogadoView proprietarioLogadoView;

  public ProprietarioView() {
    bairroController = new BairroController();
    proprietarioController = new ProprietarioController();
    scanner = new Scanner(System.in);
  }

  public void interfaceInicial() {
    int escolha = 0;

    while (escolha != 3) {
      System.out.println("******PROPRIETÁRIO******");
      System.out.println("1 - Criar uma conta");
      System.out.println("2 - Login");
      System.out.println("3 - Voltar");
      System.out.print("Escolha uma das opções acima: ");
      escolha = scanner.nextInt();

      switch (escolha) {
        case 1:
          cadastroDeProprietario();
          break;
        case 2:
          login();
          break;
        case 3:
          break;
        default:
          System.out.println("Opção inválida!");
      }
    }
  }

  public void login() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Usuario: ");
    String usuario = scanner.next();

    System.out.print("Senha: ");
    String senha = scanner.next();

    Proprietario proprietario = proprietarioController.realizarLogin(usuario, senha);

    if (proprietario != null) {
      proprietarioLogadoView = new ProprietarioLogadoView(proprietario);
      proprietarioLogadoView.exibirMenuPrincipal();
    }
  }

  public void cadastroDeProprietario() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Nome: ");
    String nome = scanner.next();

    System.out.print("CPF: ");
    String cpf = scanner.next();

    System.out.print("Usuário: ");
    String usuario = scanner.next();

    System.out.print("Senha: ");
    String senha = scanner.next();

    System.out.println("Escolha o número do bairro que você reside: ");
    bairroController.mostrarListaDeBairros();
    int idBairro = scanner.nextInt();

    System.out.print("Logradouro: ");
    String logradouro = scanner.next();

    System.out.print("Número da casa: ");
    int numeroDaCasa = scanner.nextInt();

    Proprietario proprietario = new Proprietario(nome, cpf, usuario, senha);
    Endereco endereco = new Endereco(logradouro, numeroDaCasa, idBairro);

    proprietarioController.cadastrarProprietarioNoBD(proprietario, endereco);
  }
}
