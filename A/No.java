import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class No implements Comparable<No> {
    private static int contador = 0;
    public int id;
    public No raiz = null;
    public List<Aresta> vizinho;
    public double f = Double.MAX_VALUE;
    public double g = Double.MAX_VALUE;
    public double h;

    No(double h) {
        this.h = h;
        this.id = contador++;
        this.vizinho = new ArrayList<>();
    }

    public void AdicionarNo(int peso, No No) {
        Aresta novaAresta = new Aresta(peso, No);
        vizinho.add(novaAresta);
    }

    public static class Aresta {
        public int peso;
        public No No;
        Aresta(int peso, No No) {
            this.peso = peso;
            this.No = No;
        }
    }

    public double heuristica(No objetivo) {
        return this.h;
    }

    public static No Aestrela(No inicio, No objetivo) {
        PriorityQueue<No> lista1 = new PriorityQueue<>();
        PriorityQueue<No> lista2 = new PriorityQueue<>();

        inicio.f = inicio.g + inicio.heuristica(objetivo);
        lista2.add(inicio);

        while (!lista2.isEmpty()) {
            No n = lista2.peek();
            if (n == objetivo) {
                return n;
            }

            for (No.Aresta a : n.vizinho) {
                No m = a.No;
                double pesototal = n.g + a.peso;

                if (!lista2.contains(m) && !lista1.contains(m)) {
                    m.raiz = n;
                    m.g = pesototal;
                    m.f = m.g + m.heuristica(objetivo);
                    lista2.add(m);
                } else {
                    if (pesototal < m.g) {
                        m.raiz = n;
                        m.g = pesototal;
                        m.f = m.g + m.heuristica(objetivo);

                        if (lista1.contains(m)) {
                            lista1.remove(m);
                            lista2.add(m);
                        }
                    }
                }
            }
            lista1.add(n);
            lista2.remove(n);
        }
        return null;
    }

    @Override
    public int compareTo(No n) {
        return Double.compare(this.f, n.f);
    }
}