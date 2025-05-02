#include<stdlib.h>
#include<stdio.h>
#include"fila_naoCircular.h"

/* Cria uma nova queue */
queue *InitQueue(){
    queue *myQueue = (queue*)malloc(sizeof(queue));
    myQueue->tail = 0;
    // aqui nao precisamos fazer o controle de quantos elementos há na fila!!
}

/* Adiciona um elemento no final da fila */
void insertQueue(queue *myQueue, element e){
    // verifica se há espaço na fila
    if(size(myQueue) < QUEUE_MAX_SIZE){
        myQueue->elements[myQueue->tail] = e; // adiciona o elemento no final da fila
        myQueue->tail++;    // avança o apontados de cauda para proxima posicao da fila
    }
    return;
}

/* Remove o primeiro elemento da fila */
element removeQueue(queue *myQueue){
    element retorno; retorno.id = -1;
    int i;
    if(!isEmpty(myQueue)){
        retorno = myQueue->elements[0]; // pega o elemento que esta na frente da fila
        
        // move todos os elementos que estao na fila
        for(i = 0; i < myQueue->tail; i++){
            myQueue->elements[i] = myQueue->elements[i+1];
        }
        
        // ajusta o apontados do ultimo elemento uma para uma posicao a menos
        myQueue->tail--;
    }
    return retorno;
}

/* Retorna o tamanho atual da fila */
int size(queue *myQueue){
    return myQueue->tail;
}

/* Retorna TRUE se a fila está vazia */
int isEmpty(queue *myQueue){
    if(myQueue->tail == 0) return 1;
    else return 0;
}

/* Retorna (sem remover) o primeiro elemento da fila */
element front(queue *myQueue){
    return myQueue->elements[0];
}

/* Imprime todos os elementos da fila */
void printQueue(queue *myQueue){
    int i;
    int aux = 0;
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
