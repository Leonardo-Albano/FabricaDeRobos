import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// import java.util.concurrent.Semaphore;

import Fabrica.*;

public class App {
    
    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Argumentos necessários para instanciar os objetos:
        int idEsteira;
        int idInicialGrupo;
        int idInicialFuncionarios;
        List<String> tiposComponentes;
        int qtdGrupos;
        int qtdFuncionarios;

        // Instanciar a primeira esteira
        idEsteira = 1;
        idInicialGrupo = idEsteira;
        tiposComponentes = new ArrayList<>(
                Arrays.asList("Perna Esquerda", "Perna Direita", "Braco Esquerdo", "Braco Direito"));
        qtdGrupos = tiposComponentes.size();
        qtdFuncionarios = 12;
        idInicialFuncionarios = 1;

        Esteira esteira1 = instanciarEsteira(idEsteira, idInicialGrupo, tiposComponentes, qtdGrupos, qtdFuncionarios,
                idInicialFuncionarios);

        // Instanciar a segunda esteira
        idEsteira = 2;
        idInicialGrupo = qtdGrupos + 1;
        idInicialFuncionarios += qtdFuncionarios * qtdGrupos;
        qtdFuncionarios = 9;
        tiposComponentes = new ArrayList<>(Arrays.asList("Carcaca", "Cabeca"));
        qtdGrupos = tiposComponentes.size();

        Esteira esteira2 = instanciarEsteira(idEsteira, idInicialGrupo, tiposComponentes, qtdGrupos, qtdFuncionarios,
                idInicialFuncionarios);

        System.out.println(esteira1);
        System.out.println(esteira2);
    }

    /**
     * Função responsável por instanciar as esteiras.
     * 
     * @param idEsteira
     * @param idInicialGrupo
     * @param tiposComponentes
     * @param qtdGrupos
     * @param qtdFuncionarios
     * @param idInicialFuncionarios
     * @return
     */
    private static Esteira instanciarEsteira(int idEsteira, int idInicialGrupo, List<String> tiposComponentes,
            int qtdGrupos, int qtdFuncionarios, int idInicialFuncionarios) {

        Esteira esteira = new Esteira(idEsteira);

        List<Grupo> listaGrupos = criarGrupos(idInicialGrupo, tiposComponentes, qtdGrupos, qtdFuncionarios,
                idInicialFuncionarios, esteira);

        esteira.setGrupos(listaGrupos);

        return esteira;
    }

    /**
     * Função responsável por criar os grupos e depois instanciar os funcionários responsáveis pelos grupos.
     * 
     * @param idInicialGrupo
     * @param tiposComponentes
     * @param qtdGrupos
     * @param qtdFuncionarios
     * @param idInicialFuncionarios
     * @param esteira
     * @return
     */
    private static List<Grupo> criarGrupos(int idInicialGrupo, List<String> tiposComponentes, int qtdGrupos,
            int qtdFuncionarios, int idInicialFuncionarios, Esteira esteira) {

        List<Grupo> listaGrupos = new ArrayList<>();

        for (int indexGrupo = 0; indexGrupo < qtdGrupos; indexGrupo++) {
            int idGrupo = indexGrupo + idInicialGrupo; // Lógica para não criar ids duplicados
            Grupo grupo = new Grupo(idGrupo, esteira);
            String tipoComponente = tiposComponentes.get(indexGrupo);
            List<Funcionario> listaFuncionarios = criarFuncionarios(qtdFuncionarios, idInicialFuncionarios, grupo,
                    tipoComponente);
            idInicialFuncionarios += qtdFuncionarios;
            grupo.setFuncionarios(listaFuncionarios);
            listaGrupos.add(grupo);
        }

        return listaGrupos;
    }

    /**
     * Função responsável por instanciar todos os funcionários usando um id unico.
     * 
     * @param qtdFuncionarios
     * @param idInicialFuncionarios
     * @param grupo
     * @param tipoComponente
     * @return
     */
    private static List<Funcionario> criarFuncionarios(int qtdFuncionarios, int idInicialFuncionarios, Grupo grupo,
            String tipoComponente) {
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        for (int indexFuncionario = 0; indexFuncionario < qtdFuncionarios; indexFuncionario++) {
            int idFuncionario = indexFuncionario + idInicialFuncionarios;
            Funcionario funcionario = new Funcionario(idFuncionario, grupo, tipoComponente);
            listaFuncionarios.add(funcionario);
        }

        return listaFuncionarios;
    }
}
