public class ListArrayOfInteger {
    // Atributos
    private static final int INITIAL_SIZE = 10;
    private Integer[] data;
    private int count;

    // Construtor da lista
    public ListArrayOfInteger() {
        this(INITIAL_SIZE);
    }

    /*Construtor da lista.
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ListArrayOfInteger(int tam) {
        if (tam <= 0) {
            tam = INITIAL_SIZE;
        }
        data = new Integer[tam];
        count = 0;
    }

    //Esvazia a lista.
    public void clear() { // O(1)
        data = new Integer[INITIAL_SIZE];
        count = 0;
    }

    /* @return true se a lista nao contem elementos
     */
    public boolean isEmpty() { // O(1)
        return (count == 0);
    }

    // @return o numero de elementos da lista
    public int size() { // O(1)
        return count;
    }


    /* Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) { // O(n)
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }
    //set
    public boolean set(int index, Integer newElement) {
        if (index < 0 || index >= count) {
            return false;
        }
        // Atualiza o valor na posição especificada
        data[index] = newElement;
        return true;
    }

    //Contains
    public boolean contains(Integer element) {
        for (int i = 0; i < count; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /* Retorna o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int get(int index) { // O(1)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }

    @Override
    public String toString() { // O(n)
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(data[i]);
            if (i != (count - 1)) {
                s.append(",");
            }
        }
        s.append("\n");
        return s.toString();
    }

    private void setCapacity(int newCapacity) {
        if (newCapacity != data.length) {
            int min = 0;
            Integer[] newData = new Integer[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }


    /* Remove um elemento da lista.
     * @param element elemento a ser removido
     * @return true se o elemento foi removido, false se o elemento não foi encontrado
     */
    public boolean remove(Integer element) { // complexidade O(n)
        // Encontrar o índice do elemento
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (data[i].equals(element)) {
                index = i;
                break;
            }
        }
        // Se o elemento não foi encontrado, retorna false
        if (index == -1) {
            return false;
        }
        // Deslocar os elementos subsequentes para a esquerda
        for (int j = index; j < count - 1; j++) {
            data[j] = data[j + 1];
        }
        // Reduzir o contador e remover o último elemento
        count--;
        data[count] = null; // Limpar a última posição
        return true;
    }
    //EXERCICIO 2
    public int maiorValorComum(ListArrayOfInteger L1, ListArrayOfInteger L2) {
        int maior = Integer.MIN_VALUE;
        for (int i = 0; i < L1.getSize(); i++) {
            int valor = L1.get(i);
            // Verifica se o valor também está em L2
            if (estaNaLista(valor, L2)) {
                if (valor > maior) {
                    maior = valor;
                }
            }
        }
        // Verifica se foi encontrado algum valor comum
        if (maior == Integer.MIN_VALUE) {
            System.out.println("Não há valores comuns nas duas listas.");
            return -1; //não há valor comum
        }
        return maior; // maior valor comum
    }
    // Método auxiliar que verifica se um valor está presente na lista L2
    private boolean estaNaLista(int valor, ListArrayOfInteger lista) {
        for (int j = 0; j < lista.getSize(); j++) {
            if (lista.get(j) == valor) {
                return true;
            }
        }
        return false; // Valor não está em L2
    }
}
