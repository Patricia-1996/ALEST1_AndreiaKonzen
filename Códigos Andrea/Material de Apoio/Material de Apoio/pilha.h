#define STACK_MAX_SIZE 100

typedef struct element{
    int id;
    /* outros componentes do elemento */
} element;

typedef struct stack{
    element elements[STACK_MAX_SIZE];
    int top;
} stack;

/* Cria um novo stack */
stack *InitStack();
/* Adiciona um elemento ao topo da pilha */
void push(stack *myStack, element e);
/* Remove o primeiro elemento do topo da pilha */
element pop(stack *myStack);
/* Retorna o tamanho atual da pilha */
int size(stack *myStack);
/* Retorna TRUE se a pilha está vazia */
int isEmpty(stack *myStack);
/* Retorna (sem remover) o primeiro elemento do topo da pilha */
element peek(stack *myStack);
/* Imprime todos os elementos da pilha */
void printStack(stack *myStack);
