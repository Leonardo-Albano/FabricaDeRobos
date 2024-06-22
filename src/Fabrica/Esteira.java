package Fabrica;

import java.util.List;

public class Esteira {
    
    private int id;
    private List<Grupo> grupos;

    public Esteira(int id) {
        this.id = id;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
}
