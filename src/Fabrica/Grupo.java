package Fabrica;

import java.util.ArrayList;
import java.util.List;

public class Grupo {

    private int id;

    public int getId() {
        return id;
    }

    private List<Funcionario> funcionarios;

    private List<Integer> listaPonteirosComponentes;
    private int posicaoPrimeiroPonteiro;
    private int posicaoUltimoPonteiro;

    private Esteira esteira;

    public Grupo(int id, Esteira esteira) {
        this.id = id;
        this.esteira = esteira;

        this.listaPonteirosComponentes = new ArrayList<>();
        this.posicaoPrimeiroPonteiro = 0;
        this.posicaoUltimoPonteiro = 0;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void inserirComponenteNoEstoque(Componente componente) throws InterruptedException {
        int posicaoNoEstoque = this.esteira.inserirComponenteNoEstoque(componente);
        this.listaPonteirosComponentes.add(posicaoNoEstoque);
        this.posicaoUltimoPonteiro++;
    }

    public int retirarComponenteDoEstoque() throws InterruptedException {
        if (this.listaPonteirosComponentes.isEmpty()) {
            return -1;
        }

        int posicaoDoComponenteNoEstoque = this.listaPonteirosComponentes.remove(this.posicaoPrimeiroPonteiro);
        this.posicaoPrimeiroPonteiro = this.listaPonteirosComponentes.isEmpty() ? 0 : this.posicaoPrimeiroPonteiro + 1;
        return posicaoDoComponenteNoEstoque;
    }
}
