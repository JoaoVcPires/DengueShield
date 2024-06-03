package model;

public class Caso {
    private Agente responsavel;
    private String descricao;
    private Endereco enderecoDoCaso;

    public Caso(String descricao, Endereco enderecoDoCaso, Agente responsavel) {
        this.descricao = descricao;
        this.enderecoDoCaso = enderecoDoCaso;
        this.responsavel = responsavel;

        if (this.enderecoDoCaso != null) {
            enderecoDoCaso.setfocoDengue(true);
            this.responsavel.meusCasos(this);
        }
    }

    public Agente getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Agente responsavel) {
        this.responsavel = responsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEnderecoDoCaso() {
        return enderecoDoCaso;
    }

    public void setEnderecoDoCaso(Endereco endCaso) {
        this.enderecoDoCaso = endCaso;
    }

}
