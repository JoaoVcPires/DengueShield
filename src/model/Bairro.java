package model;

import java.util.ArrayList;
import java.util.List;

public class Bairro {
    private int idBairro;
    private String descricao;
    private int casosTotal;
    private Agente agente;
    private Endereco endereco;

    private Pesquisa pesquisaAtual;
    private ArrayList<Endereco> listaEndereco;

    public Bairro(int idBairro, String descricao, int casosTotal, Agente agente, Endereco endereco) {
        this.idBairro = idBairro;
        this.descricao = descricao;
        this.casosTotal = casosTotal;
        this.agente = agente;
        this.endereco = endereco;
    }

    // public Bairro(Pesquisa pesquisaAtual, String descricao) {
    // this.pesquisaAtual = pesquisaAtual;
    // this.descricao = descricao;
    // this.listaEndereco = new ArrayList<>();

    // this.pesquisaAtual.formarPesquisa(this);

    // }

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

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    public int getCasosTotal() {
        return casosTotal;
    }

    public void setCasosTotal(int casosTotal) {
        this.casosTotal = casosTotal;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Pesquisa getPesquisaAtual() {
        return pesquisaAtual;
    }

    public void setPesquisaAtual(Pesquisa pesquisaAtual) {
        this.pesquisaAtual = pesquisaAtual;
    }

    public void addEnd(Endereco end) {
        this.listaEndereco.add(end);
    }

    public void somarCasos() {
        List<Endereco> listaCasos = this.getListaEndereco().stream().filter(i -> i.getfocoDengue()).toList();
        System.out.println("Quantidade de casos no bairro " + this.getDescricao() + ": " + listaCasos.size());
    }

}
