package model;

public class Denuncia {
    private int idDenuncia;
    private String descricao;
    private Endereco enderecoDoProprietarioDenunciado;
    private Proprietario proprietarioQueEstaRealizandoDenuncia;
    private StatusDeDenuncia.SelectStatus statusDenuncia;

    public Denuncia(String descricao, Endereco enderecoDoProprietarioDenunciado,
            Proprietario proprietarioQueEstaRealizandoDenuncia) {
        this.descricao = descricao;
        this.enderecoDoProprietarioDenunciado = enderecoDoProprietarioDenunciado;
        this.proprietarioQueEstaRealizandoDenuncia = proprietarioQueEstaRealizandoDenuncia;
        this.statusDenuncia = StatusDeDenuncia.SelectStatus.PENDENTE;

        this.getProprietarioQueEstaRealizandoDenuncia().addDenuncia(this);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEnderecoDoProprietarioDenunciado() {
        return enderecoDoProprietarioDenunciado;
    }

    public void setEnderecoDoProprietarioDenunciado(Endereco enderecoDoProprietarioDenunciado) {
        this.enderecoDoProprietarioDenunciado = enderecoDoProprietarioDenunciado;
    }

    public Proprietario getProprietarioQueEstaRealizandoDenuncia() {
        return proprietarioQueEstaRealizandoDenuncia;
    }

    public void setProprietarioQueEstaRealizandoDenuncia(Proprietario proprietarioQueEstaRealizandoDenuncia) {
        this.proprietarioQueEstaRealizandoDenuncia = proprietarioQueEstaRealizandoDenuncia;
    }

    public StatusDeDenuncia.SelectStatus getStatusDenuncia() {
        return statusDenuncia;
    }

    public void setStatusDenuncia(StatusDeDenuncia.SelectStatus statusDenuncia) {
        this.statusDenuncia = statusDenuncia;
    }

    public void dadosDenuncia() {
        System.out.println("Informações da denuncia:");
        System.out.println("Descrição: " + this.descricao);
        System.out.println(
                "Endereço denunciado: " + this.enderecoDoProprietarioDenunciado.getLogradouro() + "  "
                        + this.enderecoDoProprietarioDenunciado.getNumCasa());
        System.out.println("Emissor: " + this.getProprietarioQueEstaRealizandoDenuncia().getNomeUsuario());
        System.out.println("Status: " + this.getStatusDenuncia());
    }

    public int getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(int idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

}