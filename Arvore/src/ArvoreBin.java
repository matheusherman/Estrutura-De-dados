import java.util.LinkedList;
import java.util.List;

public class ArvoreBin {

    private List<No> arvore;

    public ArvoreBin() { //construtor
        arvore = new LinkedList<>();
    }

    public No ObtemRaiz() {
        return arvore.get(0);
    }

    public void Adicionar(int novo) {
        No n = new No(novo);
        arvore.add(n);
    }

    public Integer Busca(int busca) {
        for (int i = 0; i < arvore.size(); i++) {
            if (busca == arvore.get(i).valor)
                return busca;
        }
        return null;
    }

    public String imprime() {
        StringBuilder sb = new StringBuilder();
        int nivel = 0;
        int lastIndex = 0;
        while (lastIndex < arvore.size()) {
            int maxIndex = lastIndex + (int) Math.pow(2, nivel) - 1;
            if (maxIndex >= arvore.size()) {
                maxIndex = arvore.size() - 1;
            }
            sb.append("Nível " + nivel + "\n");
            for (; lastIndex <= maxIndex; lastIndex++) {
                sb.append(arvore.get(lastIndex).valor + "\t");
            }
            sb.append("\n");
            nivel++;
        }
        return sb.toString();
    }
}

