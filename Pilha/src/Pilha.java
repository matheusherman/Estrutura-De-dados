import java.util.ArrayList;

public class Pilha {

    private ArrayList<String> pilha;

    public Pilha(int size) {
        pilha = new ArrayList<>(size);
    }

    public boolean isEmpty() {
        return pilha.isEmpty();
    }

    public boolean isFull() {
        return (pilha.size() == 1000);
    }

    public void push(String s) {
        if (pilha.size() < 1000) {
            pilha.add(s);
        }
    }

    public String pop() {
        int tamanho = pilha.size();
        String s = pilha.get(tamanho-1);
        pilha.remove(tamanho-1);
        return s;
    }
}