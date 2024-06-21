import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import Fabrica.*;

public class App {
    public static void main(String[] args) throws Exception {
        

        esteira01();
        esteira02();
        esteira03();
        esteira04();
    }

    private static List<Funcionario> criaFuncionarios(String esteira, int quantidadeFuncionarios){
        List<Semaphore> listaSemaforos = new ArrayList<>();
        for (int i = 0; i < quantidadeFuncionarios; i++) {
            listaSemaforos.add(new Semaphore(1));
        }
        
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        for (int i = 0; i < quantidadeFuncionarios; i++) {
            Semaphore ferramenta_esq; 
            Semaphore ferramenta_dir;

            if(i != quantidadeFuncionarios){
                ferramenta_esq = listaSemaforos.get(i);
                ferramenta_dir = listaSemaforos.get(i+1);
            }else{
                ferramenta_dir = listaSemaforos.get(0);
                ferramenta_esq = listaSemaforos.get(quantidadeFuncionarios);
            }

            listaFuncionarios.add(new Funcionario((esteira + "_" + i), ferramenta_esq, ferramenta_dir));
        }

        return listaFuncionarios;
    }

    /**
     * Responsável por gerar braço direito, braço esquerdo, perna direita e perna esquerda
     * 
     * @return void 
     */
    private static void esteira01() {
        Semaphore esteira_01_sem = new Semaphore(1);
        Grupo g1 = new Grupo(criaFuncionarios("", 12));
        Grupo g2 = new Grupo(criaFuncionarios(12));
        Grupo g3 = new Grupo(criaFuncionarios(12));
        Grupo g4 = new Grupo(criaFuncionarios(12));

        List<Grupo> listaDeGrupos = new ArrayList<>();
        listaDeGrupos.add(g1);
        listaDeGrupos.add(g2);
        listaDeGrupos.add(g3);
        listaDeGrupos.add(g4);

        Esteira esteira_01 = new Esteira(listaDeGrupos, esteira_01_sem);
    }

    /**
     * Responsável p
abrac a rareg r
     * 
     * 
     */
    private static void esteira02() {
        Semaphore esteira_02_sem = new Semaphore(1);
        Grupo g1 = new Grupo(criaFuncionarios(9));
        Grupo g2 = new Grupo(criaFuncionarios(9));

        List<Grupo> listaDeGrupos = new ArrayList<>();

        listaDeGrupos.add(g1);
        listaDeGrupos.add(g2);

        Esteira esteira_02 = new Esteira(listaDeGrupos, esteira_02_sem);

    }

    private static void esteira03() {
        Semaphore esteira_03_sem = new Semaphore(1);
        Grupo g1 = new Grupo(null);
        Grupo g2 = new Grupo(null);
        Grupo g3 = new Grupo(null);

        List<Grupo> listaDeGrupos = new ArrayList<>();

        listaDeGrupos.add(g1);
        listaDeGrupos.add(g2);
        listaDeGrupos.add(g3);

        Esteira esteira_03 = new Esteira(listaDeGrupos, esteira_03_sem);
    }

    private static void esteira04() {
        Semaphore esteira_04_sem = new Semaphore(1);
        Grupo g4 = new Grupo(null);
    }
}
