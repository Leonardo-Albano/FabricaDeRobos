package Fabrica;

import java.util.concurrent.Semaphore;

public class Funcionario implements Runnable{
    public String id;
    public Semaphore ferramenta_esq;
    public Semaphore ferramenta_dir;
    public Componente componente;

    public Funcionario(String id, Semaphore ferramenta_esq, Semaphore ferramenta_dir) {
        this.id = id;
        this.ferramenta_esq = ferramenta_esq;
        this.ferramenta_dir = ferramenta_dir;
    }

    @Override
    public void run() {
        System.out.println("AOBA");    
        
    }

}
