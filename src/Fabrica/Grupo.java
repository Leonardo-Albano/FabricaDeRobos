package Fabrica;

import java.util.List;

public class Grupo {
    public List<Funcionario> funcionarios;
    public int countFuncionarios;

    public Grupo(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
        this.countFuncionarios = funcionarios.size();
    } 
}