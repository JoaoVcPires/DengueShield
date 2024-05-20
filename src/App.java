//import StatusDeDenuncia.SelectStatus;

import model.*;

public class App {
    public static void main(String[] args) throws Exception {
        Pesquisa pesq1 = new Pesquisa();
        Proprietario p1 = new Proprietario("João", "13794765931", "joaopires", "123456");
        Endereco end1 = new Endereco("Rua Mônaco", 1151, 0, p1);
        Endereco end2 = new Endereco("R São João", 115, 0, p1);
        Endereco end3 = new Endereco("Rua Maria Clara", 82, 0, p1);
        Bairro b1 = new Bairro(pesq1, "Vila Industrial");
        Bairro b2 = new Bairro(pesq1, "Panorama");
        Agente ag1 = new Agente("Ativo", "Pedro", "1324543213", "PedroSaude", "123123123");
        b1.addEnd(end1);
        b2.addEnd(end2);
        b1.addEnd(end3);
        Caso c1 = new Caso("Água parada em pneus descartados no terreno", end1, ag1);
        Caso c2 = new Caso("Caso teste", end2, ag1);
        Caso c3 = new Caso("Calha com folhas", end3, ag1);
        b1.somarCasos();
        b2.somarCasos();

        ag1.mostraCasos();

        pesq1.exibirPesquisa();
        // end1.alterarDados();
        // c1.setDescCaso("pneus com agua");

        Denuncia d1 = new Denuncia("Vi meu vizinho jogando pneus no terreno baudio", end3, p1);
        System.out.println();
        d1.dadosDenuncia();
        d1.setStatusDenuncia(StatusDeDenuncia.SelectStatus.ATENDENDO);
        System.out.println();
        d1.dadosDenuncia();
        d1.setStatusDenuncia(StatusDeDenuncia.SelectStatus.ATENDIDO);
        System.out.println();
        d1.dadosDenuncia();
    }
}
