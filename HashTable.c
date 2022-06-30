//Matheus Herman Bernardim Andrade

/*
Hash table é uma estrutura de dados em formato de container (ele armazena várias intancias de outros objetos, nesse caso as chaves)
que permite pesquisar rapidamente uma chave (geralmente uma string) para encontrar seu valor correspondente (qualquer tipo de dado).
É basicamente um array (ou um vetor) que é indexado por uma função de hash da chave e armazena N chaves.
Função de hash é um algoritmo (matemático pode-se dizer) que transforma dados em uma série de letras aleatórias com um tamanho setado.
(uma espécie de criptografia).
Uma função de hash transforma uma chave em um número de aparência aleatória e deve sempre retornar o mesmo número com a mesma chave.
A tabela hash é conhecida como uma tabela de dispersão, e as suas funções de hash (hashing ou espalhamento) são amplamente utilizadas para
armazenamento de senhas com segurança, busca de elementos em bases de dados e verificação de integridade de dados grandes

 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

#define TAM 20

struct Dados {
   int dado;   
   int chave;
};

struct Dados* ArraydeHash[TAM]; 
struct Dados* ItemTemp;
struct Dados* item;

int hashCode(int chave) {
   return chave % TAM;
}

struct Dados *buscar(int chave) {

   //pega o hash
   int IndexdoHash = hashCode(chave);  
	
   //itera pelo array ate ser vazio
   while(ArraydeHash[IndexdoHash] != NULL) {
	
      if(ArraydeHash[IndexdoHash]->chave == chave)
         return ArraydeHash[IndexdoHash]; 
			
      //pula pra proxima posicao
      ++IndexdoHash;
      IndexdoHash %= TAM;
   }        
	
   return NULL;        
}

void adicionar(int chave,int dado) {

   struct Dados *item = (struct Dados*) malloc(sizeof(struct Dados));
   item->dado = dado;  
   item->chave = chave;

   int IndexdoHash = hashCode(chave);

   //itera pelo array ate encontrar um espaco vazio
   while(ArraydeHash[IndexdoHash] != NULL && ArraydeHash[IndexdoHash]->chave != -1) {
      ++IndexdoHash;
      IndexdoHash %= TAM;
   }
	
   ArraydeHash[IndexdoHash] = item;
}

struct Dados* deletar(struct Dados* item) {
   int chave = item->chave;
 
   int IndexdoHash = hashCode(chave);

   while(ArraydeHash[IndexdoHash] != NULL) {
	
      if(ArraydeHash[IndexdoHash]->chave == chave) {
         struct Dados* temp = ArraydeHash[IndexdoHash]; 
			
         //atribui um item temporario na posição de deletar
         ArraydeHash[IndexdoHash] = ItemTemp; 
         return temp;
      }
		
      ++IndexdoHash;
      IndexdoHash %= TAM;
   }      
	
   return NULL;        
}

void printar() {
   int i = 0;
	
   for(i = 0; i<TAM; i++) {
	
      if(ArraydeHash[i] != NULL)
         printf(" (%d,%d)",ArraydeHash[i]->chave,ArraydeHash[i]->dado);
      else
         printf(" ~~ ");
   }
	
   printf("\n");
}

int main() {
   ItemTemp = (struct Dados*) malloc(sizeof(struct Dados));
   ItemTemp->dado = -1;  
   ItemTemp->chave = -1; 

   adicionar(1, 20);
   adicionar(2, 70);
   adicionar(42, 80);
   adicionar(4, 25);
   adicionar(12, 44);
   adicionar(14, 32);
   adicionar(17, 11);
   adicionar(13, 78);
   adicionar(37, 97);

   printar();
   item = buscar(37);
   deletar(item);

   if(item != NULL) {
      printf("Elemento encontrado: %d\n", item->dado);
   } else {
      printf("Elemento nao encontrado\n");
   }

   deletar(item);
   item = buscar(37);

   if(item != NULL) {
      printf("Elemento encontrado: %d\n", item->dado);
   } else {
      printf("Elemento nao encontrado\n");
   }
}
