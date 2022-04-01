import java.util.ArrayList;

public class Fila {

     private ArrayList<String> fila;
     
     public Fila(int size) {
         fila = new ArrayList<>(size);
     }
     
     public boolean isEmpty() {
         return fila.isEmpty();
     }
     
     public booan isFull() {
         return (fila.size() == 1000);
     }
     
     public void push(String s) {
         if (fila.size() < 1000) {
             fila.add(s);
         }
     }
     
     public String pop() {
         int tamanho = fila.size();
         String s = fila.get(0);
         fila.remove(0);
         return s;
     }
}