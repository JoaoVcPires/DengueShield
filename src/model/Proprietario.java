package model;

import java.util.ArrayList;

public class Proprietario extends Pessoa {
    private ArrayList<Endereco> listaEnd;
    private ArrayList<Denuncia> minhaDenuncias;

    public Proprietario(String nome, String cpf, String nomeUsuario, String senha) {
        super(nome, cpf, nomeUsuario, senha);
        this.listaEnd = new ArrayList<>();// Lista de endereços desse proprietário
        this.minhaDenuncias = new ArrayList<>();
    }

    public ArrayList<Endereco> getListaEnd() {
        return listaEnd;
    }

    public void setListaEnd(ArrayList<Endereco> listaEnd) {
        this.listaEnd = listaEnd;
    }

    public void addEndDono(Endereco myEnd) {
        this.listaEnd.add(myEnd);// função de adicionar endereços na lista do proprietário
    }

    public void addDenuncia(Denuncia y) {// função para adicionar denuncias no nome desse proprietario
        this.minhaDenuncias.add(y);
    }

    public void consultarMeusEnd() {// função para mostrar os endereços desse proprietário
        System.out.println("Endereços de " + this.getNomeUsuario());
        for (Endereco g : listaEnd) {
            System.out.println(g.getLogradouro() + " " + g.getNumCasa());
        }
    }

    @Override
    public void infoPessoa() {

    }

    public ArrayList<Denuncia> getMinhaDenuncias() {
        return minhaDenuncias;
    }

    public void setMinhaDenuncias(ArrayList<Denuncia> minhaDenuncias) {
        this.minhaDenuncias = minhaDenuncias;
    }

}