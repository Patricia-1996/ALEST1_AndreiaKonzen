//EXERCICIO 1
public class LinkedListOfInteger {
    private Node head;
    private int size;

    private class Node {
        int element;
        Node next;

        Node(int element) {
            this.element = element;
            this.next = null;
        }
    }

    public LinkedListOfInteger() {
        head = null;
        size = 0;
    }

    public void addFirst(int element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public boolean removeFirst() {
        if (head == null) {
            return false;
        }
        head = head.next;
        size--;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}