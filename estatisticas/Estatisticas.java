package estatisticas;
import distribuicoes.*;

public class Estatisticas<T extends Distribuicao> {
    private T distribuicao;

    private double[] valores;

    public Estatisticas(T distribuicao){ //Construtor das estatísticas
        this.distribuicao = distribuicao;
    }

    public void imprimirValoresGerados(int qtd){
        double[] valores = distribuicao.gerarValores(qtd);
        
        this.valores = valores; //Atribui os valores gerados ao atriburo da classe

        System.out.print("["); // Imprime os valores em formmato de listas
        for (int i = 0; i < qtd; i++){
            if (i == qtd-1){
                System.out.print(valores[i]);
            }else{
                System.out.print(valores[i] + ", ");
            }
        }
        System.out.println("]");
    }

    public void imprimirMedia(){
        double media = distribuicao.gerarMedia();
        System.out.print("Média:");
        System.out.println(media);
    }

    public void imprimirVariancia(){
        double variancia = distribuicao.gerarVariancia();
        System.out.print("Variancia:");
        System.out.print(variancia);
    }
}
