package distribuicoes;

public class DistribuicaoUniforme extends Distribuicao {
    
    private double[] entrada;

    public double[] getRandomlyGeneratedInput(){ // Retorna os valores que foram gerados alaetóriamente
        if (this.entrada != null)
            return this.entrada;
        return null;
    }

    public double[] gerarValores(int qtd){
        return null; //Implementar aqui
    }
}
