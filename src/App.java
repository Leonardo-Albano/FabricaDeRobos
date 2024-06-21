import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import Fabrica.*;

public class App {

    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Esteira esteira01 = createEsteira01();
        Esteira esteira02 = createEsteira02();
        Esteira esteira03 = createEsteira03();
        // createEsteira04(); // Comentado, pois não está implementado
    }

    /**
     * Cria uma lista de funcionários com semáforos associados.
     * 
     * @param esteira                Nome da esteira
     * @param grupo                  Nome do grupo
     * @param quantidadeFuncionarios Número de funcionários
     * @return Lista de funcionários
     */
    private static List<Funcionario> criaFuncionarios(String esteira, String grupo, int quantidadeFuncionarios) {
        List<Semaphore> listaSemaforos = new ArrayList<>();
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        for (int i = 0; i < quantidadeFuncionarios; i++) {
            listaSemaforos.add(new Semaphore(1));
        }

        for (int i = 0; i < quantidadeFuncionarios; i++) {
            Semaphore ferramentaEsq = listaSemaforos.get(i);
            // Isso substitui o seu else.
            Semaphore ferramentaDir = listaSemaforos.get((i + 1) % quantidadeFuncionarios);

            listaFuncionarios.add(new Funcionario(esteira + "_" + grupo + "_" + i, ferramentaEsq, ferramentaDir));
        }

        return listaFuncionarios;
    }

    /**
     * Cria a esteira responsável por gerar braço direito, braço esquerdo, perna
     * direita e perna esquerda.
     * 
     * @return Esteira
     */
    private static Esteira createEsteira01() {
        Semaphore esteiraSem = new Semaphore(1);

        List<Grupo> listaDeGrupos = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            listaDeGrupos.add(new Grupo(criaFuncionarios("01", "0" + i, 12)));
        }

        return new Esteira(listaDeGrupos, esteiraSem);
    }

    /**
     * Cria a esteira responsável por gerar a carcaça e a cabeça do robô.
     * 
     * @return Esteira
     */
    private static Esteira createEsteira02() {
        Semaphore esteiraSem = new Semaphore(1);

        List<Grupo> listaDeGrupos = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            listaDeGrupos.add(new Grupo(criaFuncionarios("02", "0" + i, 9)));
        }

        return new Esteira(listaDeGrupos, esteiraSem);
    }

    /**
     * Cria a esteira responsável por montar o robô com todos os componentes.
     * 
     * @return Esteira
     */
    private static Esteira createEsteira03() {
        Semaphore esteiraSem = new Semaphore(1);

        List<Grupo> listaDeGrupos = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            listaDeGrupos.add(new Grupo(criaFuncionarios("03", "0" + i, 5)));
        }

        return new Esteira(listaDeGrupos, esteiraSem);
    }

    // private static void esteira04() {
    // Semaphore esteira_04_sem = new Semaphore(1);
    // Grupo g4 = new Grupo(null);
    // }
}
