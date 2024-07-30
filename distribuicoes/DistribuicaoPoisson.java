package distribuicoes;

import java.util.Random;

public class DistribuicaoPoisson extends Distribuicao {

    private int[] entrada;
    private double lambda = 2;

    private static long fatorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public DistribuicaoPoisson(double lambda) {
        this.lambda = lambda;
    }

    public double[] getRandomlyGeneratedInput() { // Retorna os valores que foram gerados alaetóriamente
        if (this.entrada != null) {
            double[] doubleArray = new double[entrada.length]; // Cria um array de double com o mesmo tamanho

            // Converte cada elemento de int para double
            for (int i = 0; i < entrada.length; i++) {
                doubleArray[i] = (double) entrada[i];
            }
            return doubleArray;
        }
        return null;
    }

    /**
     * @param qtd um inteiro será a quantidade de números de entrada
     * @return Retorna a o array outputs com as saídas da distribuição uniforme
     */
    public double[] gerarValores(int qtd) {
        int[] arr = new int[qtd]; // Cria array de int
        Random rand = new Random(); // Cria instâncida de Random

        int limiteinferior = 0;
        int limitesuperior = 20;

        for (int i = 0; i < qtd; i++) {
            arr[i] = limiteinferior + rand.nextInt(limitesuperior);
        }

        this.entrada = arr;

        double[] outputs = new double[qtd]; // Cria o array de saída

        for (int i = 0; i < qtd; i++) { // Processa os valores aleatórios de acordo com a fórmula
            int x = arr[i];
            double resultado = (Math.exp(-1 * lambda) * Math.pow(lambda, x)) / fatorial(x);
            outputs[i] = resultado;
        }

        return outputs;

    }

    /**
     * @return Retorna a média da distribuição de Poisson
     */
    public double gerarMedia() {
        return lambda;
    }

    /**
     * @return Retorna a variância da distribuição de Poisson
     */
    public double gerarVariancia() {
        return lambda;
    }

}
