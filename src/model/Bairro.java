package model;

import java.util.ArrayList;
import java.util.List;

public class Bairro {
    private Pesquisa pesquisaAtual;// atributo que relaciona esse bairro na pesquisa de dengue
    private String descricao;
    private ArrayList<Endereco> listaEndereco;// lista para incluir os endereços desse bairro

    public Bairro(Pesquisa pesquisaAtual, String descricao) {
        this.pesquisaAtual = pesquisaAtual;
        this.descricao = descricao;
        this.listaEndereco = new ArrayList<>();

        this.pesquisaAtual.formarPesquisa(this);// ao criar um bairro ele automaticamente é incluido na pesquisa

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(ArrayList<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

    public void addEnd(Endereco end) {
        this.listaEndereco.add(end); // função de adicionar um endereço no bairro
    }

    public void somarCasos() {// função para somar os casos desse bairro, essa lista percorre os endereços do
                              // bairro
        // e soma caso o atributo foco de dengue for true
        List<Endereco> listaCasos = this.getListaEndereco().stream().filter(i -> i.getfocoDengue()).toList();
        System.out.println("Quantidade de casos no bairro " + this.getDescricao() + ": " + listaCasos.size());
        // List<Endereco> forma uma nova lista apenas com casos verdadeiros da lista de
        // endereços desse bairro
        // ao formar essa lista apenas com os verdadeiro, eu retorno o tamanho dela que
        // vai ser igual a quantidade de
        // casos desse bairo(listaCasos.size())
    }

}
