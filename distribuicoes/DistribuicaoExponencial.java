package distribuicoes;

import java.util.Random;

public class DistribuicaoExponencial extends Distribuicao {

    private double lambda = 1;
    private double[] entrada;

    public DistribuicaoExponencial(float lambda) { // Constructor da classe
        this.lambda = lambda;
    }

    public double[] getRandomlyGeneratedInput() { // Retorna os valores que foram gerados alaetóriamente
        if (this.entrada != null)
            return this.entrada;
        return null;
    }

    /**
     * @param qtd um inteiro será a quantidade de números de entrada
     * @return Retorna a o array outputs com as saídas da distribuição exponencial
     */
    public double[] gerarValores(int qtd) {
        double[] arr = new double[qtd]; // Cria array de doubles
        Random rand = new Random(); // Cria instâncida de Random

        int limiteinferior = 1;
        int limitesuperior = 100;

        for (int i = 0; i < qtd; i++) {
            arr[i] = limiteinferior + rand.nextDouble() * (limitesuperior - limiteinferior); // Atribui ao array valores
                                                                                            // double aleatórios
        }

        this.entrada = arr; // Salva as entradas na variável entrada

        double[] outputs = new double[qtd]; // Cria o array de saída

        for (int i = 0; i < qtd; i++) { // Processa os valores aleatórios de acordo com a fórmula
            if (arr[i] < 0) {
                outputs[i] = 0;
            } else {
                double resultado = lambda * Math.exp(-1 * lambda * arr[i]);
                outputs[i] = resultado;
            }
        }
        return outputs;
    }

    /**
     * @return Retorna a média da distribuição exponencial
     */
    public double gerarMedia() {
        return 1/lambda;
    }

    /**
     * @return Retorna a variância da distribuição exponencial
     */
    public double gerarVariancia() {
        return 1/(lambda*lambda);
    }
}
