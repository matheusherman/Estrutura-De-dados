import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcao;
        int tamanhopilha = 0;
        Pilha p  = new Pilha(tamanhopilha);
        Scanner teclado = new Scanner(System.in);

        do {

            System.out.println("\n:: Menu");
            System.out.println("   0 - Sair");
            System.out.println("   1 - Mostrar tamanho");
            System.out.println("   2 - Adicionar dado" );
            System.out.println("   3 - Remover dado" );
            System.out.print("\n   Opcao? ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("\n   Tmj patrao");
                    break;
                case 1:
                    if (p.isEmpty() == true) {
                        System.out.println("A pilha esta vazia");
                    } else if (p.isFull() == true) {
                        System.out.println("A pilha esta cheia");
                    } else {
                        System.out.print("A pilha tem " + tamanhopilha + " posicoes");
                    }
                    break;
                case 2:

                    if (p.isFull() == false) {
                        tamanhopilha++;
                        System.out.println("Digite a String? ");
                        String texto = teclado.nextLine();
                        p.push(texto);
                    } else {System.out.println("A pilha esta cheia ");}
                    break;
                case 3:
                    if (p.isEmpty() == true) {
                        System.out.println("A pilha esta vazia");
                    } else {
                        p.pop();
                        tamanhopilha--;
                    }
                    break;
                default:
                    System.out.println("\n   Opa, errou fera!");
                    break;
            }
        } while (opcao != 0);
    }
}