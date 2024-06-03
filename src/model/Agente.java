package model;

import java.util.ArrayList;

public class Agente extends Pessoa {
    private String status;
    private ArrayList<Caso> casosAgente;

    public Agente(String status, String nome, String cpf, String nomeUsuario, String senha) {
        super(nome, cpf, nomeUsuario, senha);
        this.status = status;
        this.casosAgente = new ArrayList<>();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void meusCasos(Caso c1) {
        this.casosAgente.add(c1);
    }

    public void mostraCasos() {
        System.out.println("Casos registrado pelo usuario: " + this.getNomeUsuario());
        for (Caso i : casosAgente) {
            System.out.println(i.getDescricao() + "  Endereço: " + i.getEnderecoDoCaso().getLogradouro() + " "
                    + i.getEnderecoDoCaso().getNumCasa());
        }
    }

}
