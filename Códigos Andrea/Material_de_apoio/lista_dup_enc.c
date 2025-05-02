#include<stdlib.h>
#include<stdio.h>
#include"lista_dup_enc.h"

/* Cria uma nova lista encadeada vazia */
Lista *InitList(){
    return NULL;
}

/* Adiciona um novo nó em uma determinada posicao da lista */
Lista *insere(Lista *prim, int info, int pos){

}

/* Imprime todos os nós da lista */
void imprime(Lista *prim){
    Lista *p = prim;
    printf("[");
    while(p != NULL){
        printf("%d", p->info); // imprime o valor da posição atual da lista
        p = p->prox; // avança para o proximo nó
        if(p != NULL) printf(", "); // se ele for diferente de NULL coloca uma ','
    }
    printf("]\n");
    return;
}

/* Retorna TRUE se a lista está vazia */
int vazia(Lista *prim){
    return (prim == NULL);
}

/* Busca um nó que contém um determinado valor na lista */
Lista* busca(Lista* l, int valor){
    Lista *p;
    for(p = l; p != NULL; p=p->prox){
        if(p->info == valor)
            return p;
    }
    return NULL;
}

/* Remove um elemento de uma determinada posição da lista */
Lista* remover(Lista *prim, int pos){

}

/* Libera toda a lista */
void libera(Lista* prim){
    Lista* p = prim;
    while (p != NULL) {
        Lista* temp = p->prox; // guarda referência para o próximo nó
        free(p); // libera a memória apontada por p 
        p = temp; // faz p apontar para o temporario
    }
}
