package model;

//import StatusDeDenuncia.selectStatus;

public class Denuncia {
    private String descDenuncia;
    private Endereco endDenunciado;
    private Proprietario usuarioDenuncia;
    private StatusDeDenuncia.SelectStatus statusDenuncia;

    public Denuncia(String descDenuncia, Endereco endDenunciado, Proprietario usuarioDenuncia) {
        this.descDenuncia = descDenuncia;
        this.endDenunciado = endDenunciado;
        this.usuarioDenuncia = usuarioDenuncia;
        this.statusDenuncia = StatusDeDenuncia.SelectStatus.PENDENTE;

        this.getUsuarioDenuncia().addDenuncia(this);// Ao criar uma denuncia, o usuário que a realizou
        // automaticamente recebe ela em sua lista de denuncias
    }

    public String getDescDenuncia() {
        return descDenuncia;
    }

    public void setDescDenuncia(String descDenuncia) {
        this.descDenuncia = descDenuncia;
    }

    public Endereco getEndDenunciado() {
        return endDenunciado;
    }

    public void setEndDenunciado(Endereco endDenunciado) {
        this.endDenunciado = endDenunciado;
    }

    public Proprietario getUsuarioDenuncia() {
        return usuarioDenuncia;
    }

    public void setUsuarioDenuncia(Proprietario usuarioDenuncia) {
        this.usuarioDenuncia = usuarioDenuncia;
    }

    public StatusDeDenuncia.SelectStatus getStatusDenuncia() {
        return statusDenuncia;
    }

    public void setStatusDenuncia(StatusDeDenuncia.SelectStatus statusDenuncia) {
        this.statusDenuncia = statusDenuncia;
    }

    public void dadosDenuncia() {
        System.out.println("Informações da denuncia:");
        System.out.println("Descrição: " + this.descDenuncia);
        System.out.println(
                "Endereço denunciado: " + this.endDenunciado.getLogradouro() + "  " + this.endDenunciado.getNumCasa());
        System.out.println("Emissor: " + this.getUsuarioDenuncia().getNomeUsuario());
        System.out.println("Status: " + this.getStatusDenuncia());
    }

}