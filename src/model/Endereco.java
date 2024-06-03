package model;

import java.util.Scanner;

public class Endereco {
    private int idEndereco;
    private String logradouro;
    private int numCasa;
    private Proprietario proprietario;
    private boolean focoDengue;

    public Endereco(int idEndereco, String logradouro, int numCasa, int quantCaso, Proprietario proprietario) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.numCasa = numCasa;
        this.proprietario = proprietario;
        this.focoDengue = false;

        this.proprietario.addEndDono(this);
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
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

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setPropriet(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public boolean getfocoDengue() {
        return this.focoDengue;
    }

    public void setfocoDengue(boolean x) {
        this.focoDengue = x;
    }

    public void alterarDados() {
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

    public void dadosEnd() {
        System.out.println("Informações de endereço:");
        System.out.println("Logradouro: " + this.getLogradouro() + "   N° " + this.getNumCasa()
                + "   Proprietario do imóvel: " + this.getProprietario().getNome());
    }

}
