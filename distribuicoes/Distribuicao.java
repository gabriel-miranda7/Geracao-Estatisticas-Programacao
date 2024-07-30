package distribuicoes;

public abstract class Distribuicao {
    abstract public double[] gerarValores(int qtd);
    abstract public double[] getRandomlyGeneratedInput();
    abstract public double gerarMedia();
    abstract public double gerarVariancia();
}
