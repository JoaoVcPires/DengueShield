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

        public static SelectStatus getStatus(String descricao) {
            switch (descricao) {
                case "Pendente":
                    return SelectStatus.PENDENTE;
                case "Em análise":
                    return SelectStatus.EM_ANÁLISE;
                case "Arquivada":
                    return SelectStatus.ARQUIVADA;
                default:
                    return SelectStatus.PENDENTE;
            }
        }
    }
}
