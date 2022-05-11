
public class ArvoreBinaria {
	private No raiz;
    int conta, soma;
   

     public ArvoreBinaria() //construtor
          {
            this.raiz = null;
          }

     public No ObtemRaiz()
       {
         return this.raiz;
        }
     public void InsOrd(int novo)
       {
        No n = new No(novo);
        this.raiz = this.Insere(n, this.raiz);
      }

     private No Insere(No novo, No inicio)
      {
        if (inicio != null)
          {
            if (novo.getValor() < inicio.getValor())
               inicio.p_Esq=this.Insere(novo, inicio.p_Esq);
              else
            inicio.p_Dir=this.Insere(novo, inicio.p_Dir);
           return inicio;
         }
        else
     return novo;
    }
// Ordem crescente
    public void ImprimirCrescente(No raiz)
         {
          if (raiz != null)
             {
               this.ImprimirCrescente(raiz.p_Esq);
               System.out.print(raiz.getValor() + ", ");
                this.ImprimirCrescente(raiz.p_Dir);
             }
           }
    
    
//Calcula Nivel dos nos    

    public int CalculaNivel (int noproc)
    {
    	No elemaux = this.raiz; 
    	int nivel;
    	 
      	if (this.raiz != null) 
      	{	
           if (noproc == elemaux.valor)
    		 return 1;
    		else 
    		{
    			nivel = 2;
    			while (noproc != elemaux.valor)
    			{	
    			  if (noproc < elemaux.valor)
    				elemaux = elemaux.p_Esq;
    			  else
    				  elemaux = elemaux.p_Dir; 
    			  nivel ++;
              	}   
    	  return nivel;		
      	}
      	}     
      	else 
      	   return 0;
    }      	
     	    
 // Ordem decrescente
    public void ImprimirDecrescente(No raiz)
       {
    if (raiz != null)
    {
        this.ImprimirDecrescente(raiz.p_Dir);
        System.out.print(raiz.getValor() + ", ");
        this.ImprimirDecrescente(raiz.p_Esq);
    }
    }
    
}
