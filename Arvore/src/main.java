import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main(String[] args) {

        Random gerador = new Random(); //gerador de numeros aleatorios
        long tempoInicial, deltaS, somabusca = 0, somabin = 0;

        ArvoreBin ArvoreBin = new ArvoreBin();                  //instancia da arvore binaria
        ArvoreBusca ArvoreBusca = new ArvoreBusca();            //instancia da arvore binaria de busca
        ArrayList<Integer> guardarDados = new ArrayList<>();    //array dinamico para guardar os dados gerados
        ArrayList<Long> dp1 = new ArrayList<>();
        ArrayList<Long> dp2 = new ArrayList<>();

        while (guardarDados.size() < 10000) {                               //gera 10.000 numeros
            int Dados = gerador.nextInt(1, 100000);                 //range de geracao de 1 - 100.000
            guardarDados.add(Dados);                                        //guarda o valor gerado no array

            //calculo do tempo arvore de busca
            tempoInicial = System.currentTimeMillis();
            ArvoreBusca.Adicionar(Dados);                                   //insere o valor gerado na arvore de busca
            deltaS = System.currentTimeMillis() - tempoInicial;
            somabusca = deltaS + somabusca;

            //calculo do tempo arvore binaria
            tempoInicial = System.currentTimeMillis();
            ArvoreBin.Adicionar(Dados);                                     //insere o valor gerado na arvore binaria
            deltaS = System.currentTimeMillis() - tempoInicial;
            somabin = deltaS + somabin;

            //printar somente uma vez o valor total
            if (guardarDados.size() == 10000) {
                System.out.printf("Tempo de construcao arvore busca: %.3f ms%n", (somabusca) / 1000d);
                System.out.printf("Tempo de construcao arvore binaria: %.3f ms%n", (somabin) / 1000d);
            }
        }

        //busca valores nas arvores
        for (int i = 0; i < 100; i++) {
            int busca = gerador.nextInt(1, 100000);

            //calculo do tempo arvore de busca
            tempoInicial = System.currentTimeMillis();
            ArvoreBusca.Buscar(busca);  //busca na arvore de busca
            deltaS = System.currentTimeMillis() - tempoInicial;
            somabusca = deltaS + somabusca;
            dp1.add(deltaS);

            //printar valores encontrados na arvore
            System.out.println("BUSCA NA ARVORE DE BUSCA");
            System.out.println("Valor a buscar: " + busca);
            if (ArvoreBusca.Buscar(busca) != null)
                System.out.println("Valor encontrado: " + ArvoreBusca.Buscar(busca));
            else
                System.out.println("Valor não existente na arvore");

            //calculo do tempo arvore binaria
            tempoInicial = System.currentTimeMillis();
            ArvoreBin.Busca(busca); //busca na arvore binaria
            deltaS = System.currentTimeMillis() - tempoInicial;
            somabin = deltaS + somabin;
            dp2.add(deltaS);

            //printar valroes encontrados na arvore
            System.out.println("\nBUSCA NA ARVORE BINARIA");
            System.out.println("Valor a buscar: " + busca);
            if (ArvoreBin.Busca(busca) != null)
                System.out.println("Valor encontrado: " + ArvoreBin.Busca(busca));
            else
                System.out.println("Valor não existente na arvore");
            System.out.println();

            //calculo desvio padrao
            int n1 = dp1.size();
            int n2 = dp2.size();
            long media1 = somabusca / (n1);
            long media2 = somabin / (n2);
            double desvio1 =  0, desvio2 = 0 ;

            //printar somente uma vez o valor do tempo total
            if (i == 99) {
                System.out.printf("Tempo de busca arvore busca: %.3f ms%n", (somabusca) / 1000d);
                System.out.printf("Tempo de busca arvore binaria: %.3f ms%n", (somabin) / 1000d);

                for (long valor : dp1) {
                    desvio1 = desvio1 + Math.pow((valor - media1), 2);
                }
                double resultado1 = Math.sqrt((desvio1 / n1));
                System.out.printf("Desvio Padrao da busca na arvore de busca: %.3f ms%n", (resultado1) / 1000d);

                for (long valor : dp2) {
                    desvio2 = desvio2 + Math.pow((valor - media2), 2);
                }
                double resultado2 = Math.sqrt((desvio2 / n2));
                System.out.printf("Desvio Padrao da busca na arvore de busca: %.3f ms%n", (resultado2) / 1000d);
            }
        }
    }
}
