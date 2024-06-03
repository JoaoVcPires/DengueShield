package model;

import java.util.ArrayList;

public class Proprietario extends Pessoa {
    private int idProprietario;
    private Endereco endereco;

    private ArrayList<Endereco> listaEnd;
    private ArrayList<Denuncia> minhaDenuncias;

    public Proprietario(String nome, String cpf, String nomeUsuario, String senha, int idProprietario,
            Endereco endereco) {
        super(nome, cpf, nomeUsuario, senha);
        this.idProprietario = idProprietario;
        this.endereco = endereco;
    }

    public Proprietario(String nome, String cpf, String nomeUsuario, String senha) {
        super(nome, cpf, nomeUsuario, senha);
        this.listaEnd = new ArrayList<>();
        this.minhaDenuncias = new ArrayList<>();
    }

    public int getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(int idProprietario) {
        this.idProprietario = idProprietario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Endereco> getListaEnd() {
        return listaEnd;
    }

    public void setListaEnd(ArrayList<Endereco> listaEnd) {
        this.listaEnd = listaEnd;
    }

    public void addEndDono(Endereco myEnd) {
        this.listaEnd.add(myEnd);
    }

    public void addDenuncia(Denuncia y) {
        this.minhaDenuncias.add(y);
    }

    public void consultarMeusEnd() {
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