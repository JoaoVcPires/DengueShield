import java.util.Scanner;

import controller.BairroController;
import dao.EnderecoDAO;

public class App {
    private static BairroController bairroController;

    public static void cadastroDeProprietario() {
        bairroController = new BairroController();
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

    }

    public static void main(String[] args) throws Exception {
        // int escolha = 0;
        // Scanner scanner = new Scanner(System.in);

        // while (escolha != 4) {
        // System.out.println("Escolha uma das opções abaixo");
        // System.out.println("1 - Realizar cadastro");
        // System.out.println("2 - Entrar como proprietário");
        // System.out.println("3 - Entrar como agente");
        // System.out.println("4 - Sair");
        // escolha = scanner.nextInt();

        // switch (escolha) {
        // case 1:
        // cadastroDeProprietario();
        // break;
        // case 2:
        // System.out.println("Realizando login");
        // break;
        // case 3:
        // System.out.println("Realizando login");
        // break;
        // case 4:
        // System.out.println("Flw");
        // break;

        // default:
        // System.out.println("Opção inválida!");
        // break;
        // }

        // }

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.insereEndereco("Testando", 123, 0, 2);
    }
}
