#include<stdio.h>
#include<stdlib.h>
#include"lista_dup_enc.h"

int main(void){

    Lista *primeiro;
    
    // inicializa a lista
    primeiro = InitList();
    imprime(primeiro);
    printf("A lista esta vazia? %d\n", vazia(primeiro));

    return 1;
}
