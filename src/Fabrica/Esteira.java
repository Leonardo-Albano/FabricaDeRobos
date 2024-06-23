package Fabrica;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Esteira {

    private int id;
    private List<Grupo> grupos;

    private List<Componente> listaComponentes;
    // private int posicaoPrimeiroComponenteLista;
    private int posicaoUltimoComponenteLista;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Semaphore semaforoListaComponentes;
    private Semaphore semaforoInserirRetirar;

    public Esteira(int id) {
        this.id = id;

        this.posicaoUltimoComponenteLista = 0;

        this.listaComponentes = new ArrayList<>();
        this.semaforoListaComponentes = new Semaphore(1);
        this.semaforoInserirRetirar = new Semaphore(1);
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public int inserirComponenteNoEstoque(Componente componente) throws InterruptedException {
        this.semaforoInserirRetirar.acquire();
        this.semaforoListaComponentes.acquire();

        int posicaoEsteira = this.posicaoUltimoComponenteLista;
        componente.setPosicaoEsteira(posicaoEsteira);
        this.posicaoUltimoComponenteLista++;

        this.listaComponentes.add(componente);
        // System.out.println(componente.toString());

        this.semaforoListaComponentes.release();
        this.semaforoInserirRetirar.release();

        return posicaoEsteira;
    }

    public boolean hasComponentes(String tipoComponente) {
        this.semaforoListaComponentes.acquireUninterruptibly();
        boolean found = this.listaComponentes.stream().anyMatch(c -> c.getTipoDoComponente().equals(tipoComponente));
        this.semaforoListaComponentes.release();
        return found;
    }

    public Componente retirarComponenteDoEstoque(String tipoComponente) throws InterruptedException {
        this.semaforoInserirRetirar.acquire();
        this.semaforoListaComponentes.acquire();

        Grupo grupo;

        switch (tipoComponente) {
            case Componente.PERNA_ESQUERDA:
            case Componente.CABECA:
                grupo = this.grupos.get(0);
                break;

            case Componente.PERNA_DIREITA:
            case Componente.CARCACA:
                grupo = this.grupos.get(1);
                break;

            case Componente.BRACO_ESQUERDO:
                grupo = this.grupos.get(2);
                break;

            case Componente.BRACO_DIREITO:
                grupo = this.grupos.get(3);
                break;
            default:
                System.out.println("Grupo não encontrado.");
                throw new IllegalArgumentException("Tipo de componente desconhecido: " + tipoComponente);
        }

        int indexParaRetirarDaLista;
        try {
            indexParaRetirarDaLista = grupo.retirarComponenteDoEstoque();
        } catch (IndexOutOfBoundsException e) {
            semaforoListaComponentes.release();
            semaforoInserirRetirar.release();
            throw e;
        }

        if (indexParaRetirarDaLista >= this.listaComponentes.size() || indexParaRetirarDaLista < 0) {
            semaforoListaComponentes.release();
            semaforoInserirRetirar.release();
            throw new IndexOutOfBoundsException("Índice fora dos limites: " + indexParaRetirarDaLista);
        }

        Componente componente = this.listaComponentes.remove(indexParaRetirarDaLista);

        semaforoListaComponentes.release();
        semaforoInserirRetirar.release();

        return componente;
    }
}
