//Classe Pilha para a lista encadeada simples
//A implementação de Pilha se baseia na capacidade
// da lista encadeada de adicionar, remover e acessar elementos,
// usando métodos da lista para simular o comportamento de uma pilha.
import java.util.EmptyStackException;
public class Pilha {

        private LinkedListOfInteger pilha;

        public Pilha() {
            pilha = new LinkedListOfInteger();
        }

        // Insere no topo da pilha
        // utiliza o método add da lista para inserir um novo elemento no índice 0,
        // simulando a adição no topo da pilha.
        public void push(Integer e) {
            pilha.add(0,e); // O topo da pilha eh o inicio da lista
        }

        // Remove e retorna o elemento do topo da pilha
        //utiliza o método removeByIndex(0) da lista para
        // remover o primeiro elemento, que corresponde ao topo da pilha.
        public Integer pop() {
            // Primeiro verifica se a pilha nao esta vazia
            if (pilha.isEmpty())
                throw new EmptyStackException();
            return pilha.removeByIndex(0);
        }
        //utiliza o método get(0) da lista para acessar o primeiro elemento,
        // sem removê-lo, simulando a operação de verificar o topo da pilha.
        public Integer top() {
            // Primeiro verifica se a pilha nao esta vazia
            if (pilha.isEmpty())
                throw new EmptyStackException();
            return pilha.get(0);
        }

        public int size() {
            return pilha.size();
        }

        public boolean isEmpty() {
            return pilha.isEmpty();
        }

        public void clear() {
            pilha.clear();
        }


                                                                                                                                                                                                }
        
    

