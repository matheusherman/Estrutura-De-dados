import java.util.Scanner
        
public class Main {
    public static void main(String[] arg) {
        
        int opcao;
        int tamanho = 0;
        Fila f = new Fila(tamanho);
        Scanner teclado = new Scanner(System.in);
        
        do{
            System.out.println("\n Menu");
            System.out.println("0 - Sair");
            System.out.println("1 - Mostrar tamanho");
            System.out.println("2 - Adicionar item");
            System.out.println("3 - Remover item");
            System.out.println("\n Opcao:");
            opcao = teclado.nextInt();
            teclado.nextLine(); //limpar buffer do telado
           
            switch (opcao) {
                case 0:
                    System.out.println("\n Tmj patrao");
                    break;
                case 1:
                    if (f.isEmpty() == true) {
                        System.out.println("A fila esta vazia");
                    } else if (f.isFull() == true) {
                        System.out.println("A fila esta cheia");
                    } else {
                        System.out.println("A fila tem " + tamanho + " posicoes");
                    }
                    break;
                case 2:
                    if (f.isFull() == false) {
                        tamanho++;
                        System.out.println("Digite a string:");
                        String texto = teclado.nextLine();
                        f.push(texto);
                    } else {
                        System.out.println("A fila esta cheia");
                    }
                    break;
                case 3:
                    if (f.isEmpty() == true) {
                        System.out.println("A pilha esta vazia");
                    } else {
                        f.pop();
                        tamanho--;
                    }
                    break;
                default:
                    System.out.println("\n Opa, errou fera!");
                    break;
            }
        } while(opcao != 0);
    }
}