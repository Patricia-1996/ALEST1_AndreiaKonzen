
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
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Retorna a referencia para o nodo da posicao index.
     * @param index
     * @return 
     */
    private Node getNodeIndex(int index) {
        Node aux = null;
        
        if (index < count/2) { // caminha do inicio para o meio
            aux = header.next;
            for (int i=0; i<index; i++) {
                aux = aux.next;
            }
        }
        else { // caminha do fim para o meio
            aux = trailer.prev;
            for (int i=count-1; i>index; i--) {
                aux = aux.prev;
            }
        }
        
        return aux;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {
        // Primeiro verifica se o indice eh valido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        return aux.element;
    }

    /**
    * Substitui o elemento armanzenado em uma determinada posicao da lista pelo elemento indicado
    * @param index a posicao da lista
    * @param element o elemento a ser armazenado na lista
    * @return o elemento armazenado anteriormente na posicao da lista
    * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
    */
    public Integer set(int index, Integer element) {
        // Primeiro verifica se index eh valido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        Integer elem = aux.element;
        aux.element = element;
        return elem;
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        // Primeiro cria o nodo
        Node n = new Node(element);
        // Conecta o nodo criado na lista
        n.prev = trailer.prev;
        n.next = trailer;
        // Atualiza os encadeamentos
        trailer.prev.next = n;
        trailer.prev = n;
        // Atualiza count
        count++;      
    }


    /**
     * Adiciona um elemento no inicio lista
     * @param element elemento a ser adicionado no inicio da lista
     */
    public void addI(Integer element) {
        // Primeiro cria o nodo
        Node n = new Node(element);
        // Conecta o nodo criado na lista
        n.prev = header;
        n.next = header.next;
        // Atualiza os encadeamentos
        header.next = n;
        // Atualiza count
        count++;      
    }
    
    
    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count;i++) {
            if (aux.element.equals(element)) { 
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;               
                return true;
            }
            aux = aux.next;
        }
        return false;	
    }

    public void imprimirReverse(){
        Node aux = trailer.prev;
        for (int i = 0; i < count; i++) {
            System.out.println(aux.element);
            aux = aux.prev;
        }
    } 
    

    /**
     * Retorna true se a lista não contem elementos
     * @return true se a lista não contem elementos
     */
    public boolean isEmpty() {
        return (count == 0);
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
