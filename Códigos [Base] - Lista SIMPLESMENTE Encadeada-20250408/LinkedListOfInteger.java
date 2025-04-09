public class LinkedListOfInteger {

    // Classe interna Node
    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }

        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }
    }


    // Referência para o primeiro elemento da lista encadeada.
    private Node head;
    // Referência para o último elemento da lista encadeada.
    private Node tail;
    // Contador para a quantidade de elementos que a lista contem.
    private int count;


    /**
     * Construtor da lista.
     */
    public LinkedListOfInteger() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista.
     *
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }
    /*Add com index */

    public void add(Integer element, int index){
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException("Índice invalido!");
         }

         Node n = new Node(element);
//se colocar novo nodo no inicio, o indice será 0, e o nodo se tornará o novo head
         if(index == 0){
            n.next = head;
            head = n;
//se não tinha nenhum nodo, o novo vagão também é o último
            if(count == 0){
                tail = head;
            }
         }
//se quiser que o novo vagão seja o ultimo, index será igual o count
//e também será o novo tail
         else if (index == count){
            tail.next = n;
            tail = n;
         }
//se quiser colocar nodo no meio
         else{
            Node current = head; //um novo nodo auxiliar chamado current aponta p/ 1º nodo 
//andaremos até chegar no lugar certo
//vai até index -1 porque queremos colocar antes do lugar certo
            for(int i = 0; i < index-1; i++){
                current = current.next; // vai para o próximo nodo
            }
         }
    }

    

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }

    ///////////////////////////////////////////////////
    //// EXERCICIOS - VEJA SLIDES E ENUNCIADO
    ///////////////////////////////////////////////////

    // 1 - implemente o método isEmpty
    /*
     * Retorna true se a lista nao contem elementos.
     *
     * @return true se a lista nao contem elementos
     */
    //assinatura do metodo
    //public boolean isEmpty()

    public boolean isEmpty(){
        if(tail == null && head == null && count == 0){
            return true;
        }

        return false;
    }


    // 2 - implemente o método size
    /*
     * Retorna o numero de elementos da lista.
     *
     * @return o numero de elementos da lista
     */
    ////assinatura do metodo
    //public int size()

    public int size(){
        return count;
    }


    // 3 - implemente o método get
    /*
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posição da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */

    /* Exemplo - veja o main
    Lista:
        2
        4
        8
        lista.get(1)
        Elemento na segunda posicao da lista: 4
     */

    //assinatura do metodo
    //public Integer get(int index)

    public Integer get(int index){
    //verifica indice
    if(index < 0 || index >= count){
        throw new IndexOutOfBoundsException("Índice invalido!");
    
    }
    Node current = head;

    for(int i = 0; i<index ; i++){
        current = current.next;
    }
    return current.element;
}

}
