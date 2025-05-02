#include<stdlib.h>
#include<stdio.h>
#include"fila.h"

/* Cria uma nova queue */
queue *InitQueue(){
    queue *myQueue = (queue*)malloc(sizeof(queue));
    myQueue->head = 0;
    myQueue->tail = 0;
    myQueue->total = 0;
}
/* Adiciona um elemento no final da fila */
void insertQueue(queue *myQueue, element e){
    // verifica se há espaço na fila
    if(size(myQueue) < QUEUE_MAX_SIZE){
        myQueue->elements[myQueue->tail] = e; // adiciona o elemento no final da fila
        myQueue->total++;   // incrementa o tamanho da fila

        // avança o apontador do final da fila (tail)...
        if(myQueue->tail == QUEUE_MAX_SIZE-1) myQueue->tail = 0;
        else  myQueue->tail++;
    }
    return;
}

/* Remove o primeiro elemento da fila */
element removeQueue(queue *myQueue){
    element retorno;
    if(!isEmpty(myQueue)){
        retorno = myQueue->elements[myQueue->head]; // pega o elemento que esta na frente da fila
        myQueue->total--; // decrementa o tamanho da fila

        // avança o apontador do inicio da fila...
        if(myQueue->head == QUEUE_MAX_SIZE-1) myQueue->head = 0;
        else  myQueue->head++;
    }
    return retorno;
}

/* Retorna o tamanho atual da fila */
int size(queue *myQueue){
    return myQueue->total;
}

/* Retorna TRUE se a fila está vazia */
int isEmpty(queue *myQueue){
    if(myQueue->total == 0) return 1;
    else return 0;
}

/* Retorna (sem remover) o primeiro elemento da fila */
element front(queue *myQueue){
    return myQueue->elements[myQueue->head];
}

/* Imprime todos os elementos da fila */
void printQueue(queue *myQueue){
    int i;
    int aux = myQueue->head;
    printf("[");
    for(i = 0; i < size(myQueue); i++){
        // imrpime o valor da fila
        printf("%d",myQueue->elements[aux].id);
        if(i != size(myQueue)-1)  printf(", ");
                
        // avança o apontador auxiliar...
        if(aux == QUEUE_MAX_SIZE-1) aux = 0;
        else aux++;
    }
    printf("]\n");
    return;
}
