//MATHEUS HERMAN BERNARDIM ANDRADE
//LEANDRO RICARDO GUIMARÃES
//GABRIELLE BATISTA GARCIA

import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main(String[] args) {

        Random gerador = new Random(); //gerador de numeros aleatorios

        ArvoreBin ArvoreBin = new ArvoreBin();          //instancia da arvore binaria
        ArvoreBusca ArvoreBusca = new ArvoreBusca();    //instancia da arvore binaria de busca


        ArrayList<Integer> guardarDados = new ArrayList<>(); //array dinamico para guardar os dados gerados

        while (guardarDados.size() < 10) {                        //gera 10.000 numeros
            int Dados = gerador.nextInt(1, 10);     //range de geracao de 1 - 100.000
            guardarDados.add(Dados);                                //guarda o valor gerado no array
            ArvoreBusca.Adicionar(Dados);                                 //insere o valor gerado na arvore binaria
            ArvoreBin.Adicionar(Dados);                                   //insere o valor gerado na arvore binaria
        }
    }
}
