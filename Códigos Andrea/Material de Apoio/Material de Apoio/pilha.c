#include<stdlib.h>
#include<stdio.h>
#include"pilha.h"

/* Cria um novo stack */
stack *InitStack(){
    stack *myStack = (stack*)malloc(sizeof(stack));
    myStack->top = -1;
    return myStack;
}

/* Adiciona um elemento ao topo da pilha */
void push(stack *myStack, element e){
    if(myStack->top < STACK_MAX_SIZE){
        myStack->top++;
        myStack->elements[myStack->top] = e;
    }
}

/* Remove o primeiro elemento do topo da pilha */
element pop(stack *myStack){
    if(myStack->top >= 0){
        myStack->top--;
        return myStack->elements[myStack->top+1];
    }
}

/* Retorna o tamanho atual da pilha */
int size(stack *myStack){
    return myStack->top+1;
}

/* Retorna TRUE se a pilha está vazia */
int isEmpty(stack *myStack){
    if(myStack->top >= 0)
        return 0;
    else
        return 1;
}

/* Retorna (sem remover) o primeiro elemento do topo da pilha */
element peek(stack *myStack){
    if(myStack->top >= 0){
        return myStack->elements[myStack->top];
    }
}

/* Imprime todos os elementos da pilha */
void printStack(stack *myStack){
    printf("Pilha: [");
    for(int i = 0; i <= myStack->top; i++){
        printf("%d ", myStack->elements[i].id);
    }
    printf("]\n");
}