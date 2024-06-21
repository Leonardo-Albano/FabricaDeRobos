package Fabrica;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Esteira implements Runnable {
    public List<Grupo> grupos;
    public Semaphore semaforo;

    public Esteira(List<Grupo> grupos, Semaphore semaforo) {
        this.grupos = grupos;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        System.out.println("AOBA");

    }
}
