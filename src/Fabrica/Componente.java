package Fabrica;

public class Componente {

    public static final String PERNA_ESQUERDA = "Perna Esquerda";
    public static final String PERNA_DIREITA = "Perna Direita";
    public static final String BRACO_ESQUERDO = "Braço Esquerdo";
    public static final String BRACO_DIREITO = "Braço Direito";
    public static final String CABECA = "Cabeça";
    public static final String CARCACA = "Carcaça";

    private int posicaoEsteira;
    private String tipoDoComponente;
    private Funcionario funcionarioQueProduziu;

    public String getTipoDoComponente() {
        return tipoDoComponente;
    }

    public void setTipoDoComponente(String tipoDoComponente) {
        this.tipoDoComponente = tipoDoComponente;
    }

    public Componente(String tipoDoComponente, Funcionario funcionarioQueProduziu) {
        this.tipoDoComponente = tipoDoComponente;
        this.funcionarioQueProduziu = funcionarioQueProduziu;
    }

    public void setPosicaoEsteira(int posicaoEsteira) {
        this.posicaoEsteira = posicaoEsteira;
    }

    public int getPosicaoEsteira() {
        return posicaoEsteira;
    }

    public Funcionario getFuncionarioQueProduziu() {
        return funcionarioQueProduziu;
    }

    @Override
    public String toString() {
        return "Componente {" +
                "\n\tposicaoEsteira: " + posicaoEsteira +
                ",\n\ttipoDoComponente: " + tipoDoComponente +
                ",\n\tfuncionarioQueProduziu: " + funcionarioQueProduziu.getId() +
                ",\n\tgrupo: " + funcionarioQueProduziu.getGrupoId() +
                "\n}";
    }

}
