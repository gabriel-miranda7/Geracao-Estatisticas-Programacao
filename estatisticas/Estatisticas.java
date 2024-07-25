package estatisticas;
import distribuicoes.*;

public class Estatisticas<T extends Distribuicao> {
    private T distribuicao;

    private double[] valores;
    private double media;

    public Estatisticas(T distribuicao){ //Construtor das estatísticas
        this.distribuicao = distribuicao;
    }

    public void imprimirValoresGerados(int qtd){
        double[] valores = distribuicao.gerarValores(qtd);
        double[] entradas = distribuicao.getRandomlyGeneratedInput();
        
        this.valores = valores; //Atribui os valores gerados ao atriburo da classe

        for (int i = 0; i < qtd; i++){
            System.out.print("Entrada: ");
            System.out.print(entradas[i]);
            System.out.print(" Saída: ");
            System.out.println(valores[i]);
        }
    }

    public void imprimirMedia(){
        double sum = 0;
        double qtd = valores.length;
        for (int i = 0; i < qtd; i++){ // Calcula o somatório da média
            sum += valores[i];
        }
        double media = sum/qtd; // Divide pela quantidade de itens
        this.media = media;
        System.out.println("Média");
        System.out.println(media);
    }

    public void imprimirVariancia(){
        double variancia;
        double qtd = valores.length;
        double sum = 0;
        for (int i = 0; i < qtd; i++){ //Calcula o somatório da variância
            sum += Math.pow((valores[i] - media), 2);
        }
        variancia = sum/qtd; //Divide pela quantidade de elementos
        System.out.println("Variancia");
        System.out.print(variancia);
    }
}
