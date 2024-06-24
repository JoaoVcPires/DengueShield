package statusEnum;

public class StatusDeDenuncia {
    public enum SelectStatus {
        PENDENTE("Pendente"),
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
                case "Arquivada":
                    return SelectStatus.ARQUIVADA;
                default:
                    return SelectStatus.PENDENTE;
            }
        }
    }
}
