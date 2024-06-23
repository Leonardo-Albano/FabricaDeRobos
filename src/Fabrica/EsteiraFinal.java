package Fabrica;

import java.util.ArrayList;
import java.util.List;

public class EsteiraFinal {
    private List<Robo> robos;
    private int posicaoUltimoRobo;

    public EsteiraFinal() {
        this.robos = new ArrayList<>();
        this.posicaoUltimoRobo = 0;
    }

    public synchronized void adicionarRobo(Robo robo) {
        robos.add(robo);
        System.out.println("______________________________________________________________\n");
        System.out.println("Robo adicionado na esteira final:\n" + robo.getLog());
        posicaoUltimoRobo++;
    }

    public int getPosicaoUltimoRobo() {
        return posicaoUltimoRobo;
    }
}
