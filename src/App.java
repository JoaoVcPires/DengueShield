import java.util.Scanner;

import controller.BairroController;
import dao.EnderecoDAO;
import view.ProprietarioView;

public class App {

    public static void main(String[] args) throws Exception {
        ProprietarioView proprietarioView;
        int escolha = 0;
        Scanner scanner = new Scanner(System.in);

        while (escolha != 3) {
            System.out.println("1 - Agente");
            System.out.println("2 - Proprietário");
            System.out.println("3 - Sair");
            System.out.print("Escolha qual tipo de usuário você é: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    break;
                case 2:
                    proprietarioView = new ProprietarioView();
                    break;
                case 3:
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        }

    }
}
