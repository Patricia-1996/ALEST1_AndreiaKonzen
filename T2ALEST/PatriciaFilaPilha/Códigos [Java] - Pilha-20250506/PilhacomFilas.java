
import java.util.EmptyStackException;
import java.util.Queue;

public class PilhacomFilas<T> {
    private Queue fila1, fila2;


    public PilhacomFilas(){
        fila1 = new LinkedListOfInteger<>();
        fila2 = new LinkedListOfInteger<>();
    }

    public void pushFP(T elemento){ //O(n)
        fila2.enqueue(elemento);

        while(!fila1.isEmpty()){
            fila2.enqueue(fila.dequeue())
        }

        Queue<T> temp = fila1;
        fila1 = fila2;
        fila2 = temp;
    }
public T popFP(){ //O(1)
    if(fila1.isEmpty()){
        throw new IllegalStateException("Pilha vazia");
    }
    return fila1.dequeue();
}

public T topoFP(){
    if(fila1.isEmpty()){
        throw new IllegalStateException("Pilha vazia");

    }
    return fila1.head();
}

public boolean isEmptyFilaPilha(){
    fila1.isEmpty();
}

public int tam(){
    return fila.size();
}



}
