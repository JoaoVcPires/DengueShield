package statusEnum;

public class StatusDeDenuncia {
    public enum SelectStatus {
        PENDENTE("Pendente"),
        EM_ANÁLISE("Em análise"),
        ARQUIVADA("Arquivada");

        private String descricao;

        SelectStatus(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}
