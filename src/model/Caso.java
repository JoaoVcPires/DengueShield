package model;

public class Caso {
    private Agente responsavel;
    private String descCaso;
    private Endereco endCaso;

    public Caso(String descCaso, Endereco endCaso, Agente responsavel) {
        this.descCaso = descCaso;
        this.endCaso = endCaso;
        this.responsavel = responsavel;

        if (this.endCaso != null) {
            endCaso.setfocoDengue(true);// ao criar um caso e informar seu endereço, o atributo
            // de foco dengue desse endereço, automaticamento se torna verdadeiro (boleano,
            // pois é possível
            // apenas 1 caso por endereço)
            this.responsavel.meusCasos(this);// meus casos é a função para adicionar o caso na lista de casos
            // do responsável
        }
    }

    public Agente getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Agente responsavel) {
        this.responsavel = responsavel;
    }

    public String getDescCaso() {
        return descCaso;
    }

    public void setDescCaso(String descCaso) {
        this.descCaso = descCaso;
    }

    public Endereco getEndCaso() {
        return endCaso;
    }

    public void setEndCaso(Endereco endCaso) {
        this.endCaso = endCaso;
    }

}
