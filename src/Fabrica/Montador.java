package Fabrica;

public class Montador implements Runnable {
    private int id;
    private Grupo grupo;
    private Esteira esteira1;
    private Esteira esteira2;
    private EsteiraFinal esteiraFinal;

    public Montador(int id, Grupo grupo, Esteira esteira1, Esteira esteira2, EsteiraFinal esteiraFinal) {
        this.id = id;
        this.grupo = grupo;
        this.esteira1 = esteira1;
        this.esteira2 = esteira2;
        this.esteiraFinal = esteiraFinal;
    }

    private void montarRobo() throws InterruptedException {
        while (!esteira1.hasComponentes(Componente.BRACO_ESQUERDO) ||
                !esteira1.hasComponentes(Componente.BRACO_DIREITO) ||
                !esteira1.hasComponentes(Componente.PERNA_ESQUERDA) ||
                !esteira1.hasComponentes(Componente.PERNA_DIREITA) ||
                !esteira2.hasComponentes(Componente.CARCACA) ||
                !esteira2.hasComponentes(Componente.CABECA)) {
            Thread.sleep(1000); // Espera 1 segundo antes de verificar novamente
        }

        // Pegar componentes da esteira 1
        Componente bracoEsquerdo = esteira1.retirarComponenteDoEstoque(Componente.BRACO_ESQUERDO);
        Componente bracoDireito = esteira1.retirarComponenteDoEstoque(Componente.BRACO_DIREITO);
        Componente pernaEsquerda = esteira1.retirarComponenteDoEstoque(Componente.PERNA_ESQUERDA);
        Componente pernaDireita = esteira1.retirarComponenteDoEstoque(Componente.PERNA_DIREITA);

        // Pegar componentes da esteira 2
        Componente cabeca = esteira2.retirarComponenteDoEstoque(Componente.CABECA);
        Componente carcaca = esteira2.retirarComponenteDoEstoque(Componente.CARCACA);

        Thread.sleep(3000);

        // Criar log
        String log = String.format(
                "Membro da Esteira 1:\n" +
                        "Posição: %d\nGrupo: %d\nFuncionário: %d\n" +
                        "Cabeça/Corpo da Esteira 2:\n" +
                        "Posição: %d\nGrupo: %d\nFuncionário: %d\n" +
                        "Montagem:\nGrupo: %d\nFuncionário: %d\n" +
                        "Posição na Esteira Final: %d",
                bracoEsquerdo.getPosicaoEsteira(), bracoEsquerdo.getFuncionarioQueProduziu().getGrupoId(),
                bracoEsquerdo.getFuncionarioQueProduziu().getId(),
                cabeca.getPosicaoEsteira(), cabeca.getFuncionarioQueProduziu().getGrupoId(),
                cabeca.getFuncionarioQueProduziu().getId(),
                grupo.getId(), id, esteiraFinal.getPosicaoUltimoRobo());

        // Criar o robô
        Robo robo = new Robo(bracoEsquerdo, bracoDireito, pernaEsquerda, pernaDireita, carcaca, cabeca, log);

        // Colocar o robô na esteira final
        esteiraFinal.adicionarRobo(robo);
    }

    @Override
    public void run() {
        while (true) {
            try {
                montarRobo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
