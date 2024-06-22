package Fabrica;

public class Funcionario {
    
    private int id;
    private Grupo grupo;

    public Funcionario(int id, Grupo grupo, String produzTipoDoComponente) {
        this.id = id;
        this.grupo = grupo;
        this.produzTipoDoComponente = produzTipoDoComponente;
    }
    private String produzTipoDoComponente;
    //0 - braço esquerdo / 1 - braço direito / 2 - perna esquerda / 3 - perna direita
    //4 - carcaça / 5 - cabeça
}
