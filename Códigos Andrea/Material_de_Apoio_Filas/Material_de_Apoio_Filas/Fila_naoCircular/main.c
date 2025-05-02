#include<stdio.h>
#include<stdlib.h>
#include"fila_naoCircular.h"

int main(void){

    element a;
    queue *fila = InitQueue();

    a.id = 5;
    insertQueue(fila, a);
    printQueue(fila);
    //////////
    a.id = 3;
    insertQueue(fila, a);
    printQueue(fila);
    //////////
    printf("tamanho da fila: %d elementos\n",size(fila));
    //////////
    printf("removeQueue(): %d\n", removeQueue(fila).id);
    printQueue(fila);
    //////////
    printf("a fila esta vazia? %d\n", isEmpty(fila));
    printQueue(fila);
    //////////
    printf("removeQueue(): %d\n", removeQueue(fila).id);
    printQueue(fila);
    //////////
    printf("a fila esta vazia? %d\n", isEmpty(fila));
    printQueue(fila);
    //////////
    printf("removeQueue(): %d\n", removeQueue(fila).id);
    printQueue(fila);
    //////////
    a.id = 7;
    insertQueue(fila, a);
    printQueue(fila);
    //////////
    a.id = 9;
    insertQueue(fila, a);
    printQueue(fila);
    //////////
    printf("front(): %d\n", front(fila).id);
    printQueue(fila);
    //////////
    a.id = 4;
    insertQueue(fila, a);
    printQueue(fila);
    //////////
    printf("tamanho da fila: %d elementos\n",size(fila));
    //////////
    printf("removeQueue(): %d\n", removeQueue(fila).id);
    printQueue(fila);
    //////////
    a.id = 6;
    insertQueue(fila, a);
    printQueue(fila);
    //////////
    a.id = 12;
    insertQueue(fila, a);
    printQueue(fila);
    return 1;
}
