package distribuicoes;
import java.util.Random;

public class DistribuicaoNormal extends Distribuicao {

    private float[] valores; //Array de valores
    private float mi, sigma;

    public DistribuicaoNormal(float mi, float sigma){
        this.mi = mi; this.sigma = sigma;
    }

    protected float[] gerarValores(int qtd) {
        float[] arr = new float[qtd]; //Cria array de floats
        Random rand = new Random(); // Cria instâncida de Random

        for (int i = 0; i < qtd; i++){
            arr[i] = rand.nextFloat(); // Atribui ao array valores float aleatórios
        }
        return arr; // Retorna o array preenchido
    }

    public float[] imprimirValoresGerados(int qtd){
        float[] valoresBrutos = gerarValores(qtd);
        //Continuar daqui

    }
}
