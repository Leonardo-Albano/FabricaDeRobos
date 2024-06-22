package Fabrica;

public class Robo {
    private Componente bracoEsquerdo;
    private Componente bracoDireito;
    private Componente pernaEsquerda;
    private Componente pernaDireita;
    private Componente carcaca;
    private Componente cabeca;
    private String log;

    public Robo(Componente bracoEsquerdo, Componente bracoDireito, Componente pernaEsquerda, Componente pernaDireita,
            Componente carcaca, Componente cabeca, String log) {
        this.bracoEsquerdo = bracoEsquerdo;
        this.bracoDireito = bracoDireito;
        this.pernaEsquerda = pernaEsquerda;
        this.pernaDireita = pernaDireita;
        this.carcaca = carcaca;
        this.cabeca = cabeca;
        this.log = log;
    }

    public String getLog() {
        return log;
    }
}
