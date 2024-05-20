package model;

import java.util.Scanner;

public class Endereco {
    private String logradouro;
    private int numCasa;
    private int quantCaso;
    private Proprietario dono;
    private boolean focoDengue; // atributo que ao ser true, soma mais 1 caso no bairro desse endereço

    public Endereco(String logradouro, int numCasa, int quantCaso, Proprietario dono) {
        this.logradouro = logradouro;
        this.numCasa = numCasa;
        this.quantCaso = quantCaso;
        this.dono = dono;
        this.focoDengue = false;

        this.dono.addEndDono(this);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    public int getQuantCaso() {
        return quantCaso;
    }

    public void setQuantCaso(int quantCaso) {
        this.quantCaso = quantCaso;
    }

    public Proprietario getDono() {
        return dono;
    }

    public void setDono(Proprietario dono) {
        this.dono = dono;
    }

    public boolean getfocoDengue() {
        return this.focoDengue;
    }

    public void setfocoDengue(boolean x) {
        this.focoDengue = x;
    }

    public void alterarDados() {// função básica de alterar dados do objeto endereço
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.println("Alterar informações do endereço");
        System.out.println("Escolha a opção de alteração:0-Encerrar\n1-Logradouro\n2-Numero");
        op = sc.nextInt();
        do {
            if (op == 1) {
                System.out.println("Entre com o logradouro correto");
                this.setLogradouro(sc.next());
                System.out.println("Logradouro alterado para: " + this.getLogradouro());
                break;
            } else if (op == 2) {
                System.out.println("Entre com o numero correto");
                this.setNumCasa(sc.nextInt());
                System.out.println("Numero da casa alterado para: " + this.getNumCasa());
                break;
            } else if (op == 0) {
                System.out.println("Encerrando...");
                return;
            } else {
                System.out.println("Opcao inválida!");
            }
            sc.close();
        } while (op != 0);
    }

    public void dadosEnd() {// imprimir dados do endereço, no momento não está sendo utilizado
        System.out.println("Informações de endereço:");
        System.out.println("Logradouro: " + this.getLogradouro() + "   N° " + this.getNumCasa()
                + "   Proprietario do imóvel: " + this.getDono().getNome());
        System.out.println("Numero de casos registrados no local: " + this.getQuantCaso());
    }

}
