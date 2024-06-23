package Fabrica;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Funcionario implements Runnable {

    private int id;

    public int getId() {
        return id;
    }

    public int getGrupoId() {
        return this.grupo.getId();
    }

    private Grupo grupo;
    private String tipoDeComponenteProduzido;
    private Semaphore ferramentaEsq;
    private Semaphore ferramentaDir;

    public Funcionario(int id, Grupo grupo, String tipoDeComponenteProduzido, Semaphore ferramentaEsq,
            Semaphore ferramentaDir) {
        this.id = id;
        this.grupo = grupo;
        this.tipoDeComponenteProduzido = tipoDeComponenteProduzido;
        this.ferramentaEsq = ferramentaEsq;
        this.ferramentaDir = ferramentaDir;
    }

    public Componente produzirComponente() throws InterruptedException {
        Thread.sleep(new Random().nextInt(10000));

        boolean adquiriuFerramentas = false;
        while (!adquiriuFerramentas) {
            if (ferramentaEsq.tryAcquire(1, TimeUnit.SECONDS) && ferramentaDir.tryAcquire(1, TimeUnit.SECONDS)) {
                adquiriuFerramentas = true;
            } else {
                ferramentaEsq.release(); // Libera a ferramenta esquerda se não conseguiu adquirir ambas
                Thread.sleep(100); // Aguarda um curto período antes de tentar novamente
            }
        }

        Componente componente = new Componente(this.tipoDeComponenteProduzido, this);
        this.grupo.inserirComponenteNoEstoque(componente);

        ferramentaEsq.release(); // Libera as ferramentas após o uso
        ferramentaDir.release();

        return componente;
    }

    @Override
    public void run() {
        while (true) {
            try {
                produzirComponente();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Funcionario {" +
                "\n\tid: " + id +
                ",\n\tgrupo: " + grupo.getId() +
                ",\n\ttipoDeComponenteProduzido: " + tipoDeComponenteProduzido +
                "\n}";
    }
}
