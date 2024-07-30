package distribuicoes;

import java.util.Random;

public class DistribuicaoUniforme extends Distribuicao {

    private double[] entrada;
    private double a, b;

    public DistribuicaoUniforme(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double[] getRandomlyGeneratedInput() { // Retorna os valores que foram gerados alaetóriamente
        if (this.entrada != null)
            return this.entrada;
        return null;
    }

    /**
     * @param qtd um inteiro será a quantidade de números de entrada
     * @return Retorna a o array outputs com as saídas da distribuição uniforme
     */
    public double[] gerarValores(int qtd) {
        double[] arr = new double[qtd]; // Cria array de doubles
        Random rand = new Random(); // Cria instâncida de Random

        int limiteinferior = 1000;
        int limitesuperior = -1000;

        for (int i = 0; i < qtd; i++) {
            arr[i] = limiteinferior + rand.nextDouble() * (limitesuperior - limiteinferior); // Atribui ao array valores
                                                                                             // double aleatórios
        }

        this.entrada = arr;

        double[] outputs = new double[qtd]; // Cria o array de saída

        for (int i = 0; i < qtd; i++) { // Processa os valores aleatórios de acordo com a fórmula
            double resultado = 1 / (b - a); // Distribição uniforme apenas depende de a e b
            outputs[i] = resultado;
        }

        return outputs;

    }

    /**
     * @return Retorna a média da distribuição uniforme
     */
    public double gerarMedia() {
        return (a + b / 2);
    }

    /**
     * @return Retorna a variância da distribuição uniforme
     */
    public double gerarVariancia() {
        double desvioPadrao = (b - a) / Math.sqrt(12);
        return Math.pow(desvioPadrao, 2);
    }
}
