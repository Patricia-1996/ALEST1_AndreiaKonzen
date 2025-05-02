typedef struct lista_dup_enc{
    int info;
    struct lista_dup_enc *prox;
    struct lista_dup_enc *ant;
} Lista;

/* Cria uma nova lista */
Lista *InitList();
/* Adiciona um novo nó em uma determinada posicao da lista */
Lista *insere(Lista *prim, int info, int pos);
/* Remove um elemento de uma determinada posição da lista */
Lista* remover(Lista *prim, int pos);
/* Imprime todos os elementos da lista */
void imprime(Lista *prim);
/* Retorna TRUE se a lista está vazia */
int vazia(Lista *prim);
/* Busca um elemento na lista, retornando o ponteiro do nó */
Lista* busca(Lista* l, int valor);
/* Libera toda a lista */
void libera(Lista* l);