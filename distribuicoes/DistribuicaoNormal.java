package distribuicoes;

import java.util.Random;

public class DistribuicaoNormal extends Distribuicao {

    private double mi = 0;
    private double sigma = 1;
    private double[] entrada;

    public DistribuicaoNormal(float mi, float sigma) { // Constructor da classe
        this.mi = mi;
        this.sigma = sigma;
    }

    public double[] getRandomlyGeneratedInput() { // Retorna os valores que foram gerados alaetóriamente
        if (this.entrada != null)
            return this.entrada;
        return null;
    }

    public double[] gerarValores(int qtd) {
        double[] arr = new double[qtd]; // Cria array de doubles
        Random rand = new Random(); // Cria instâncida de Random

        int limiteinferior = -4;
        int limitesuperior = 4;

        for (int i = 0; i < qtd; i++) {
            arr[i] = limiteinferior + rand.nextDouble() * (limitesuperior - limiteinferior); // Atribui ao array valores
                                                                                             // double aleatórios
        }

        this.entrada = arr; // Salva as entradas na variável entrada

        double[] outputs = new double[qtd]; // Cria o array de saída

        for (int i = 0; i < qtd; i++) { // Processa os valores aleatórios de acordo com a fórmula
            double x = arr[i];
            double z = (x - mi) / sigma; // Calcula o valor z
            double exponent = -0.5 * Math.pow(z, 2); // Valor antes da exponenciação
            double resultado = (1 / (sigma * Math.sqrt(2 * Math.PI))) * Math.exp(exponent); // Calcula F(x)
            outputs[i] = resultado;
        }
        return outputs;
    }

    public double gerarMedia() {
        return mi;
    }

    public double gerarVariancia() {
        return Math.pow(sigma, 2);
    }
}
