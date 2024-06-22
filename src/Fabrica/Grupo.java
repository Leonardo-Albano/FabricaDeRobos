package Fabrica;

import java.util.List;

public class Grupo {

    private int id;

    private List<Funcionario> funcionarios;
    
    private Esteira esteira;
    
    public Grupo(int id, Esteira esteira) {
        this.id = id;
        this.esteira = esteira;
    }
    
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
