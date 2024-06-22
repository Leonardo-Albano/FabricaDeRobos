import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

import Fabrica.*;

public class App {

    public static void main(String[] args) throws Exception {
       
        //Argumentos necessários para instanciar os objetos:
        int idEsteira;
        
        int idInicialGrupo;
        int idInicialFuncionarios;
        
        List<String> tiposComponentes;
        
        int qtdGrupos;
        int qtdFuncionarios;

        //Instanciar a primeira esteira
        idEsteira = 1;
        idInicialGrupo = idEsteira;
        
        tiposComponentes = new ArrayList<>(
            Arrays.asList("Perna Esquerda", "Perna Direita", "Braco Esquerdo", "Braco Direito")
        );
        qtdGrupos = tiposComponentes.size();

        qtdFuncionarios = 12;
        idInicialFuncionarios = 1;

        Esteira esteira1 = instanciarEsteiras(idEsteira, idInicialGrupo, tiposComponentes, qtdGrupos, qtdFuncionarios, idInicialFuncionarios);
        
        //Instanciar a segunda esteira
        idEsteira = 2;
        idInicialGrupo = qtdGrupos + 1;
        
        idInicialFuncionarios = idInicialFuncionarios + (qtdFuncionarios*qtdGrupos);
        qtdFuncionarios = 9;

        tiposComponentes = new ArrayList<>(
            Arrays.asList("Carcaca", "Cabeca")
        );

        qtdGrupos = tiposComponentes.size();
        

        Esteira esteira2 = instanciarEsteiras(idEsteira, idInicialGrupo, tiposComponentes, qtdGrupos, qtdFuncionarios, idInicialFuncionarios);
    }

    private static Esteira instanciarEsteiras(
                                    int idEsteira, 
                                    int idInicialGrupo, List<String> tiposComponentes, int qtdGrupos,
                                    int qtdFuncionarios, int idInicialFuncionarios
                                    ){

        Esteira esteira = new Esteira(idEsteira);

        List<Grupo> listaGrupos = new ArrayList<>();
        for (int indexGrupo = 0; indexGrupo < qtdGrupos; indexGrupo++) {

            int idGrupo = indexGrupo + idInicialGrupo; //Lógica para não criar ids duplicados
            Grupo grupo = new Grupo(idGrupo, esteira);


            List<Funcionario> listaFuncionarios = new ArrayList<>();
            String tipoComponente = tiposComponentes.get(indexGrupo);
            for (int indexFuncionario = 0; indexFuncionario < qtdFuncionarios; indexFuncionario++) {  

                int idFuncionario = indexFuncionario + idInicialFuncionarios;

                Funcionario funcionario = new Funcionario(idFuncionario, grupo, tipoComponente);
                
                listaFuncionarios.add(funcionario);
            }
            idInicialFuncionarios += qtdFuncionarios;

            grupo.setFuncionarios(listaFuncionarios);
            listaGrupos.add(grupo);
        }

        esteira.setGrupos(listaGrupos);
        
        return esteira;
    }
}
