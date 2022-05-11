import java.io.*;

public class InterfaceTesteA {
	public static void main(String[] args) {
		 int dado;
		    	        
	      ArvoreBinaria oArvore = new ArvoreBinaria();

	//ENTRADA DE DADOS 
	     
	/*     BufferedReader input = new BufferedReader ( new InputStreamReader(System.in));
	     String s = input.readLine();
	     dado = Integer.valueOf(s.trim()).intValue();*/
	    
	      
	    // oArvore.InsOrd(dado);

	     oArvore.InsOrd(10);
	     oArvore.InsOrd(20); 
	     oArvore.InsOrd(5);
	     oArvore.InsOrd(7);
	     oArvore.InsOrd(19);
	     oArvore.InsOrd(45);
	     
	     
	     int nivel =   oArvore.CalculaNivel (20);
	     System.out.println("O nivel do no 20 é: "+nivel);

	     System.out.println("Ordem Crescente:");
	     oArvore.ImprimirCrescente(oArvore.ObtemRaiz());
	     System.out.println();

	   /*  System.out.println("Ordem Decrescente:");
	     oArvore.ImprimirDecrescente(oArvore.ObtemRaiz());
	     System.out.println();

	 /*    int conta = oArvore.ContaElementos(oArvore.ObtemRaiz());
	     System.out.println("Elementos: " + conta);

	     int soma = oArvore.SomaElementos(oArvore.ObtemRaiz());
	     System.out.println("Soma dos Elementos: " + soma);
	     
	     int maior = oArvore.MaiorElemento(oArvore.ObtemRaiz());
	     System.out.println("Elemento Maior: " + maior);

	     int menor = oArvore.MenorElemento(oArvore.ObtemRaiz());
	     System.out.println("Elemento Menor: " + menor); */
	}

}
