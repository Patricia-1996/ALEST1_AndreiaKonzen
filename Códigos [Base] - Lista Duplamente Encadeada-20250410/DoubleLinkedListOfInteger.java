public class DoubleLinkedListOfInteger {
    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Referencia para a posicao corrente.
    private Node current;
    // Contador do numero de elementos da lista.
    private int count;

    private class Node {
        public Integer element;
        public Node next;
        public Node prev;
        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Retorna true se a lista não contem elementos
     * @return true se a lista não contem elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }


    /**
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    public void add(int element) {
        Node newNode = new Node(element); // Cria um novo nó com o valor recebido
        newNode.prev = trailer.prev; // O novo nó aponta para o último nó da lista antes do trailer
        newNode.next = trailer; // O novo nó aponta para o trailer, indicando que é o último da lista
        trailer.prev.next = newNode; // O antigo último nó passa a apontar para o novo nó como próximo
        trailer.prev = newNode; // O trailer passa a apontar para o novo nó como anterior
        count++; // Incrementa o número total de elementos na lista
    }
    
    public void add(int index, int element) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Índice fora dos limites"); // Verifica se o índice é válido
        }
    
        Node newNode = new Node(element); // Cria um novo nó com o elemento fornecido
        Node aux = header.next; // Começa a busca pelo nó onde a inserção ocorrerá
    
        for (int i = 0; i < index; i++) {
            aux = aux.next; // Avança até encontrar o nó na posição desejada
        }
    
        newNode.next = aux; // O novo nó aponta para o nó que antes ocupava essa posição
        newNode.prev = aux.prev; // O novo nó aponta para o nó anterior ao encontrado
        aux.prev.next = newNode; // O nó anterior ao encontrado passa a apontar para o novo nó como próximo
        aux.prev = newNode; // O nó na posição original agora aponta para o novo nó como anterior
    
        count++; // Incrementa o número total de elementos na lista
    }
    

    public boolean remove(int element) {
        Node aux = header.next; // Começa a busca pelo nó que contém o elemento
    
        while (aux != trailer) { // Percorre a lista até encontrar o nó ou chegar ao final
            if (aux.element.equals(element)) { // Verifica se o nó atual contém o elemento
                aux.prev.next = aux.next; // Ajusta o ponteiro do nó anterior para pular o nó atual
                aux.next.prev = aux.prev; // Ajusta o ponteiro do nó seguinte para pular o nó atual
                count--; // Reduz o número de elementos na lista
                return true; // Retorna verdadeiro indicando que a remoção ocorreu
            }
            aux = aux.next; // Avança para o próximo nó
        }
        return false; // Retorna falso caso o elemento não tenha sido encontrado
    }
    


    public int removeByIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Índice fora dos limites"); // Verifica se o índice é válido
        }
    
        Node aux = header.next; // Começa a busca pelo nó na posição desejada
    
        for (int i = 0; i < index; i++) {
            aux = aux.next; // Avança até encontrar o nó a ser removido
        }
    
        int removedElement = aux.element; // Guarda o valor do elemento removido
        aux.prev.next = aux.next; // Ajusta o ponteiro do nó anterior para pular o nó atual
        aux.next.prev = aux.prev; // Ajusta o ponteiro do nó seguinte para pular o nó atual
    
        count--; // Reduz o número total de elementos na lista
    
        return removedElement; // Retorna o elemento removido
    }
    

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }

}

