import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main(String[] args) {

        Random gerador = new Random(); //gerador de numeros aleatorios
        long tempoInicial, deltaS, somabusca = 0, somabin = 0;

        ArvoreBin ArvoreBin = new ArvoreBin();                  //instancia da arvore binaria
        ArvoreBusca ArvoreBusca = new ArvoreBusca();            //instancia da arvore binaria de busca
        ArrayList<Integer> guardarDados = new ArrayList<>();    //array dinamico para guardar os dados gerados
        ArrayList<Integer> guardarBusca = new ArrayList<>();

        while (guardarDados.size() < 10000) {                               //gera 10.000 numeros
            int Dados = gerador.nextInt(1, 10);                 //range de geracao de 1 - 100.000
            guardarDados.add(Dados);                                        //guarda o valor gerado no array
            tempoInicial = System.currentTimeMillis();
            ArvoreBusca.Adicionar(Dados);                                   //insere o valor gerado na arvore binaria
            deltaS = System.currentTimeMillis() - tempoInicial;
            somabusca = deltaS + somabusca;
            tempoInicial = System.currentTimeMillis();
            ArvoreBin.Adicionar(Dados);                                     //insere o valor gerado na arvore binaria
            deltaS = System.currentTimeMillis() - tempoInicial;
            somabin = deltaS + somabin;
            if (guardarDados.size() == 10000) {
                System.out.printf("Tempo de construcao arvore busca: %.3f ms%n", (somabusca) / 1000d);
                System.out.printf("Tempo de construcao arvore binaria: %.3f ms%n", (somabin) / 1000d);
            }
        }
        //busca valores nas arvores
        for (int i = 0; i < 100; i++) {
            int busca = gerador.nextInt(1, 10);



        }
    }
}