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
    private Semaphore semaforoListaComponentes;

    public Esteira(int id) {
        this.id = id;
        
        // this.posicaoPrimeiroComponenteLista = 0;
        this.posicaoUltimoComponenteLista = 0;
        
        this.listaComponentes = new ArrayList<>();
        this.semaforoListaComponentes = new Semaphore(1);

    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public int inserirComponenteNoEstoque(Componente componente) throws InterruptedException{
        
        this.semaforoListaComponentes.acquire();
        
        int posicaoEsteira = this.posicaoUltimoComponenteLista;
        componente.setPosicaoEsteira(posicaoEsteira);
        this.posicaoUltimoComponenteLista++;

        this.listaComponentes.add(componente);
        System.out.println(componente.toString());

        this.semaforoListaComponentes.release();

        return posicaoEsteira;
    }

    public Componente retirarComponenteDoEstoque(String tipoComponente) throws InterruptedException{
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

        int indexParaRetirarDaLista = grupo.retirarComponenteDoEstoque();

        Componente componente = this.listaComponentes.remove(indexParaRetirarDaLista);
        
        this.semaforoListaComponentes.release();
        
        return componente;
    }
}
