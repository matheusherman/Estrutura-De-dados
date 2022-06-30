//Matheus Herman Bernardim Andrade

/*
O Algoritmo A* é um método de busca heurístico (em que se conhece o objetivo do problema),
semelhante ao dijkstra e outros algoritmos de busca (seja produndidade ou largura), ele busca encontrar o melhor caminho (ou melhor escolha) dentro de um grafo.
Ele utiliza funções as heurísticas (como a heurística admissível, em que nunca se superestima o custo de atingir o objetivo)
para diminuir os passos para encontrar a solução do problema, sendo essa solução a melhor possível, tornando assim
o A* um algoritmo completo e ótimo (encontra a solução e a melhor solução respectivamente).
Ele avalia os nós através da combinação de g(n), o custo para alcançar o nó, e h(n), o custo para ir do nó ao objetivo: f(n) = g(n) + h(n).
Uma vez que g(n) dá o custo do caminho desde o nó inicial até o nó n e h(n) é o custo estimado do caminho de menor custo de n até o objetivo,
temos que f (n) é o custo estimado da solução de menor custo.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        No grafo = new No(4); //cria um grafo de 5 nos
        grafo.g = 0; //define o inicio 

      //instancia nós e seus pesos
        No n1 = new No(2);
        No n2 = new No(2);
        No n3 = new No(2);
        No n4 = new No(2);
        No objetivo = new No(5);

      //adiciona os nós no grago
        grafo.AdicionarNo(6, n1);
        grafo.AdicionarNo(4, n2);
        grafo.AdicionarNo(1, n3);
        grafo.AdicionarNo(5, n4);

      //cria as arestas dos grafo
        n1.AdicionarNo(1, n2);
        n1.AdicionarNo(3, n4);
        n2.AdicionarNo(5, n3);
        n2.AdicionarNo(2, n1);
        n2.AdicionarNo(4, objetivo);
        n3.AdicionarNo(5, n1);
        n3.AdicionarNo(1, n4);
        n4.AdicionarNo(3, objetivo);
        No.Aestrela(grafo, objetivo); //executa o algoritmo de busca
        No n = objetivo;
      
        //funcao para printar o caminho
        List<Integer> ids = new ArrayList<>();
      
        while (n.raiz != null) {
            ids.add(n.id);
            n = n.raiz;
        }
        ids.add(n.id);
        Collections.reverse(ids);

        for (int id : ids) {
            System.out.print(id + " ");
        }

    }
}