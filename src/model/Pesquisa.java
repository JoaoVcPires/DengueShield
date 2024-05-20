package model;

import java.util.ArrayList;

public class Pesquisa {
    private ArrayList<Bairro> pesquisaGeral;// Essa é a lista para a principal função do sistema, que é
    // o comparativo de número de casos entre os bairros. Nela, são adicionados os
    // bairros cadastrados

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

    public void exibirPesquisa() {// função para exibir essa pesquisa
        System.out.println("Pesquisa entre os bairros:");
        for (Bairro b : pesquisaGeral) {
            b.somarCasos();// Com esse laço de repetição eu passo por todos os bairros que fazem parte
            // da pesquisa e com a função somarCasos(), definida na classe Bairro, é exibido
            // o total de casos
            // em cada bairro
        }
    }
}
