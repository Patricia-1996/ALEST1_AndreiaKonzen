import java.util.LinkedList;

public class GeneralTreeOfString {
    private class Node {
        public Node father;
        public String element;
        public LinkedList<Node> subtrees;

        public Node(String element) {
            this.element = element;
            subtrees = new LinkedList<>();
        }

        private void addSubtree(Node n) {
            n.father = this;
            subtrees.add(n);
        }

        private boolean removeSubtree(Node n) {
            n.father = null;
            return subtrees.remove(n);
        }

        public Node getSubtree(int i) {
            if ((i < 0) || (i >= subtrees.size())) {
                throw new IndexOutOfBoundsException();
            }
            return subtrees.get(i);
        }

        public int getSubtreesSize() {
            return subtrees.size();
        }
    }

    private Node root;
    private int count;

    public GeneralTreeOfString() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    private Node searchNodeRef(String elem, Node n) {
        if (n == null)
            return null;

        if (elem.equals(n.element))
            return n;

        Node aux = null;
        for (int i = 0; i < n.getSubtreesSize(); i++) {
            aux = searchNodeRef(elem, n.getSubtree(i));
            if (aux != null)
                return aux;
        }
        return aux;
    }

    public boolean add(String elem, String elemFather) {
        Node n = new Node(elem);

        if (elemFather == null) {
            if (root != null) {
                root.father = n;
                n.addSubtree(root);
            }
            root = n;
            count++;
            return true;
        } else {
            Node aux = searchNodeRef(elemFather, root);
            if (aux != null) {
                n.father = aux;
                aux.addSubtree(n);
                count++;
                return true;
            }
        }
        return false;
    }

    public boolean contains(String elem) {
        Node aux = searchNodeRef(elem, root);
        return (aux != null);
    }

    public LinkedList<String> positionsWidth() {
        LinkedList<String> lista = new LinkedList<>();
        if (root != null) {
            Queue<Node> fila = new Queue<>();
            fila.enqueue(root);
            while (!fila.isEmpty()) {
                Node aux = fila.dequeue();
                lista.add(aux.element);
                for (int i = 0; i < aux.getSubtreesSize(); i++) {
                    fila.enqueue(aux.getSubtree(i));
                }
            }
        }
        return lista;
    }

    public LinkedList<String> positionsPre() {
        LinkedList<String> lista = new LinkedList<>();
        positionsPreAux(root, lista);
        return lista;
    }

    private void positionsPreAux(Node n, LinkedList<String> lista) {
        if (n != null) {
            lista.add(n.element);
            for (int i = 0; i < n.getSubtreesSize(); i++) {
                positionsPreAux(n.getSubtree(i), lista);
            }
        }
    }

    public LinkedList<String> positionsPos() {
        LinkedList<String> lista = new LinkedList<>();
        positionsPosAux(root, lista);
        return lista;
    }

    private void positionsPosAux(Node n, LinkedList<String> lista) {
        if (n != null) {
            for (int i = 0; i < n.getSubtreesSize(); i++) {
                positionsPosAux(n.getSubtree(i), lista);
            }
            lista.add(n.element);
        }
    }

    public int level(String element) {
        Node node = searchNodeRef(element, root);
        if (node == null) {
            return -1;
        }

        int level = 0;
        Node current = node;
        while (current.father != null) {
            current = current.father;
            level++;
        }
        return level;
    }

    public boolean removeBranch(String element) {
        Node nodeToRemove = searchNodeRef(element, root);
        if (nodeToRemove == null) {
            return false;
        }

        if (nodeToRemove == root) {
            root = null;
            count = 0;
            return true;
        }

        Node father = nodeToRemove.father;
        if (father != null) {
            father.removeSubtree(nodeToRemove);
            count -= countNodes(nodeToRemove);
            return true;
        }
        return false;
    }

    private int countNodes(Node n) {
        if (n == null) {
            return 0;
        }
        int total = 1;
        for (int i = 0; i < n.getSubtreesSize(); i++) {
            total += countNodes(n.getSubtree(i));
        }
        return total;
    }

    public void geraNodosDOT() {
        System.out.println("node [shape=circle];\n");
        LinkedList<String> L = positionsPre();
        for (String nome : L) {
            String nodeId = "node" + nome.replaceAll("\\s+", "");
            System.out.println(nodeId + " [label=\"" + nome + "\"];");
        }
    }

    public void geraConexoesDOT(Node n) {
        for (int i = 0; i < n.getSubtreesSize(); i++) {
            Node aux = n.getSubtree(i);
            String nodePai = "node" + n.element.replaceAll("\\s+", "");
            String nodeFilho = "node" + aux.element.replaceAll("\\s+", "");
            System.out.println(nodePai + " -> " + nodeFilho + ";");
            geraConexoesDOT(aux);
        }
    }

    public void geraDOT() {
        System.out.println("digraph familiaSakura {");
        System.out.println("    rankdir=TB; // Top to Bottom");
        System.out.println("    node [fontname=\"Arial\"];");
        System.out.println("    edge [dir=none];");
        
        // Nós com estilo diferente para Sakura
        System.out.println("    nodeSakuraKinomoto [shape=doublecircle, color=pink, style=filled, fillcolor=lightpink];");
        
        // Nós para os outros membros da família
        geraNodosDOT();
        
        // Conexões
        if (root != null) {
            geraConexoesDOT(root);
        }
        
        System.out.println("}");
    }
}