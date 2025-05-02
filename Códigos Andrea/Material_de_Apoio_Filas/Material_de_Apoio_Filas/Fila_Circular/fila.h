#define QUEUE_MAX_SIZE 10

typedef struct element{
    int id;
    /* outros componentes do elemento */
} element;

typedef struct queue{
    element elements[QUEUE_MAX_SIZE];
    int head;
    int tail;
    int total;
} queue;

/* Cria uma nova queue */
queue *InitQueue();
/* Adiciona um elemento no final da fila */
void insertQueue(queue *myQueue, element e);
/* Remove o primeiro elemento da fila */
element removeQueue(queue *myQueue);
/* Retorna o tamanho atual da fila */
int size(queue *myQueue);
/* Retorna TRUE se a fila está vazia */
int isEmpty(queue *myQueue);
/* Retorna (sem remover) o primeiro elemento da fila */
element front(queue *myQueue);
/* Imprime todos os elementos da fila */
void printQueue(queue *myQueue);
