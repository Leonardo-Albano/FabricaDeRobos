package Fabrica;

public class Componente {
    public String tipo; //Braço Esquerdo -> BE, Braço direito ->BD, Perna Esquerda -> PE ...
    public Funcionario funcionario;
    public int posicaoEsteira;
    
    public Componente(String tipo, Funcionario funcionario, int posicaoEsteira) {
        this.tipo = tipo;
        this.funcionario = funcionario;
        this.posicaoEsteira = posicaoEsteira;
    }
}
