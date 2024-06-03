package model;

import java.util.ArrayList;

public class Pesquisa {
    private ArrayList<Bairro> pesquisaGeral;

    public Pesquisa() {
        this.pesquisaGeral = new ArrayList<>();
    }

    public ArrayList<Bairro> getPesquisaGeral() {
        return pesquisaGeral;
    }

    public void setPesquisaGeral(ArrayList<Bairro> pesquisaGeral) {
        this.pesquisaGeral = pesquisaGeral;
    }

    public void formarPesquisa(Bairro b) {
        this.pesquisaGeral.add(b);
    }

    public void exibirPesquisa() {
        System.out.println("Pesquisa entre os bairros:");
        for (Bairro b : pesquisaGeral) {
            b.somarCasos();
        }
    }
}
