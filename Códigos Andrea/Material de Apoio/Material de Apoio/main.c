#include<stdio.h>
#include<stdlib.h>
#include"pilha.h"

int main(void){

    element a;
    stack *pilha = InitStack();

    a.id = 5;
    push(pilha, a);
    printStack(pilha);
    //////////
    a.id = 3;
    push(pilha, a);
    printStack(pilha);
    //////////
    printf("tamanho da pilha: %d elementos\n",size(pilha));
    //////////
    printf("pop(): %d\n", pop(pilha).id);
    printStack(pilha);
    //////////
    printf("a pilha esta vazia? %d\n", isEmpty(pilha));
    printStack(pilha);
    //////////
    printf("pop(): %d\n", pop(pilha).id);
    printStack(pilha);
    //////////
    printf("a pilha esta vazia? %d\n", isEmpty(pilha));
    printStack(pilha);
    //////////
    printf("pop(): %d\n", pop(pilha).id);
    printStack(pilha);
    //////////
    a.id = 7;
    push(pilha, a);
    printStack(pilha);
    //////////
    a.id = 9;
    push(pilha, a);
    printStack(pilha);
    //////////
    printf("peek(): %d\n", peek(pilha).id);
    printStack(pilha);
    //////////
    a.id = 4;
    push(pilha, a);
    printStack(pilha);
    //////////
    printf("tamanho da pilha: %d elementos\n",size(pilha));
    //////////
    printf("pop(): %d\n", pop(pilha).id);
    printStack(pilha);
    //////////
    a.id = 6;
    push(pilha, a);
    printStack(pilha);
    return 0;

}
