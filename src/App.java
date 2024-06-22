import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

import Fabrica.*;

public class App {

    

    public static void main(String[] args) throws Exception {
       
        // teste();
        iniciar();
        


    }

    private static Esteira instanciarEsteiras(
                                    int idEsteira, 
                                    int idInicialGrupo, List<String> tiposComponentes, int qtdGrupos,
                                    int qtdFuncionarios, int idInicialFuncionarios
                                    ){

                                        
        List<Thread> threads = new ArrayList<>();
        List<Grupo> listaGrupos = new ArrayList<>();
        Esteira esteira = new Esteira(idEsteira);
        for (int indexGrupo = 0; indexGrupo < qtdGrupos; indexGrupo++) {

            int idGrupo = indexGrupo + idInicialGrupo; //Lógica para não criar ids duplicados
            Grupo grupo = new Grupo(idGrupo, esteira);

            List<Semaphore> listaFerramentas = new ArrayList<>();
            for (int indexFerramenta = 0; indexFerramenta < qtdFuncionarios; indexFerramenta++) {  
                listaFerramentas.add(new Semaphore(1));
            }

            List<Funcionario> listaFuncionarios = new ArrayList<>();
            String tipoComponente = tiposComponentes.get(indexGrupo);
            for (int indexFuncionario = 0; indexFuncionario < qtdFuncionarios; indexFuncionario++) {  

                int idFuncionario = indexFuncionario + idInicialFuncionarios; //Lógica para não criar ids duplicados
                int indexFerramentaEsq = indexFuncionario != qtdFuncionarios-1 ? indexFuncionario : qtdFuncionarios-1;
                int indexFerramentaDir = indexFuncionario != qtdFuncionarios-1 ? indexFuncionario + 1 : 0;

                Semaphore ferramentaEsq = listaFerramentas.get(indexFerramentaEsq);
                Semaphore ferramentaDir = listaFerramentas.get(indexFerramentaDir);

                Funcionario funcionario = new Funcionario(idFuncionario, grupo, tipoComponente, ferramentaEsq, ferramentaDir);

                threads.add(new Thread(funcionario));
                listaFuncionarios.add(funcionario);
            }
            idInicialFuncionarios += qtdFuncionarios;

            grupo.setFuncionarios(listaFuncionarios);
            listaGrupos.add(grupo);
        }

        esteira.setGrupos(listaGrupos);
        
        for (Thread thread : threads) {
            thread.start();
        }
        return esteira;
    }

    private static void iniciar() throws InterruptedException{
        //Argumentos necessários para instanciar os objetos:
        int idEsteira;
        int idInicialGrupo;
        int idInicialFuncionarios;
        List<String> tiposComponentes;
        int qtdGrupos;
        int qtdFuncionarios;

        // Instanciar a primeira esteira
        idEsteira = 1;
        idInicialGrupo = 1;
        
        tiposComponentes = new ArrayList<>(
            Arrays.asList(Componente.PERNA_ESQUERDA, Componente.PERNA_DIREITA, Componente.BRACO_ESQUERDO, Componente.BRACO_DIREITO)
        );
        qtdGrupos = tiposComponentes.size();
        qtdFuncionarios = 12;
        idInicialFuncionarios = 1;

        Esteira esteira1 = instanciarEsteiras(idEsteira, idInicialGrupo, tiposComponentes, qtdGrupos, qtdFuncionarios,
                idInicialFuncionarios);

        // Instanciar a segunda esteira
        idEsteira = 2;
        idInicialGrupo = qtdGrupos + 1;
        idInicialFuncionarios += qtdFuncionarios * qtdGrupos;
        qtdFuncionarios = 9;

        tiposComponentes = new ArrayList<>(
            Arrays.asList(Componente.CARCACA, Componente.CABECA)
        );
        qtdGrupos = tiposComponentes.size();
        
        Esteira esteira2 = instanciarEsteiras(idEsteira, idInicialGrupo, tiposComponentes, qtdGrupos, qtdFuncionarios, idInicialFuncionarios);
    }

    private static void teste() throws InterruptedException {
        // Argumentos para instanciar um teste 
        int idEsteira = 1;
        int idInicialGrupo = 1;
        int idInicialFuncionarios = 1;

        List<String> tiposComponentes = new ArrayList<>(
                Arrays.asList(Componente.PERNA_ESQUERDA)
        );
        int qtdGrupos = 1;
        int qtdFuncionarios = 2;

        Esteira esteira = instanciarEsteiras(idEsteira, idInicialGrupo, tiposComponentes, qtdGrupos, qtdFuncionarios, idInicialFuncionarios);
    }
}
