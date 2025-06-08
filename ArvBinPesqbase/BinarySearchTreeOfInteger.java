public class BinarySearchTreeOfInteger {

    private static final class Node {

        public Node father;
        public Node left;
        public Node right;
        public Integer element;

        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    // Atributos
    private int count; //contagem do número de nodos
    private Node root; //referência para o nodo raiz

    public BinarySearchTreeOfInteger() {
        count = 0;
        root = null;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    // implementar
    //public boolean contains(Integer element) {

    //}

    private Node searchNodeRef(Integer element, Node n) {
        if (element == null || n == null)
            return null;
        int c = n.element.compareTo(element);
        if (c==0)
            return n;
        if (c > 0) {
            return searchNodeRef(element, n.left);
        }
        else {
            return searchNodeRef(element, n.right);
        }
    }

    public void add(Integer element) {
        root = add(root, element, null);
        count++;
    }
    private Node add(Node n, Integer e, Node father) {
        if (n == null) { //encontrou o lugar que deve ser inserido? insere
            Node aux = new Node(e);
            aux.father = father;
            return aux;
        }
        // Senao insere na subarvore da esq ou da dir
        if (n.element.compareTo(e) < 0) {
            n.right = add(n.right, e, n);
        }
        else {
            n.left = add(n.left, e, n);
        }
        return n;
    }

    /* Caminhamentos */
    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPreAux(root, res);
        return res;
    }

    private void positionsPreAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            res.add(n.element); //Visita o nodo
            positionsPreAux(n.left, res); //Visita a subárvore da esquerda
            positionsPreAux(n.right, res); //Visita a subárvore da direita
        }
    }

    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPosAux(root, res);
        return res;
    }

    private void positionsPosAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsPosAux(n.left, res); //Visita a subárvore da esquerda
            positionsPosAux(n.right, res); //Visita a subárvore da direita
            res.add(n.element); //Visita o nodo
        }
    }

    public LinkedListOfInteger positionsCentral() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsCentralAux(root, res);
        return res;
    }

    private void positionsCentralAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsCentralAux(n.left, res); //Visita a subárvore da esquerda
            res.add(n.element); //Visita o nodo
            positionsCentralAux(n.right, res); //Visita a subárvore da direita
        }
    }

    public LinkedListOfInteger positionsWidth() {
        Queue<Node> fila = new Queue<>();
        Node atual = null;
        LinkedListOfInteger res = new LinkedListOfInteger();
        if (root != null) {
            fila.enqueue(root);
            while (!fila.isEmpty()) {
                atual = fila.dequeue();
                if (atual.left != null) {
                    fila.enqueue(atual.left);
                }
                if (atual.right != null) {
                    fila.enqueue(atual.right);
                }
                res.add(atual.element);
            }
        }
        return res;
    }

    /* IMPLEMENTAR REMOCAO */
    // public boolean remove(Integer element) {
    // Se arvore vazia

    // se nao encontrou element


    // chama metodo que faz a remocao passando aux como argumento
    // atualiza o count
    // return true
    // }

    // private void remove(Node n) {
    //guarda pai de n no nodo father

    /* caso 1 */
    // se remocao de nodo folha
    // se remocao da raiz

    /* caso 2 com dir e esq */
    // senao ... tem apenas um filho a direita
    // se remocao da raiz que tem só um filho a direita

    // se remocao da raiz que tem só um filho a esquerda

    // se pai.esquerda é n
    //atualiza nodo pai
    // senao ..
    // atualiza nodo pai


    // senao...  tem apenas um filho a esquerda
    // se remocao da raiz que tem só um filho a esquerda

    // se pai.esquerda é n
    //atualiza nodo pai
    // senao ..
    // atualiza nodo pai

    /*caso 3 - dois filhos */
    // pega a refencia para o nodo que contem o menor elemento do lado direito
    //   remove(menor);
    //  }
    // }

    /**
     * Retorna o menor elemento da arvore.
     * @return o menor elemento
     */

    public Integer getSmallest() {
        Node n = smallest(root);
        if (n==null)
            return null;
        else
            return n.element;
    }
    private Node smallest(Node n) {
        if (n == null)
            return null;
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }



    private void GeraConexoesDOT(Node nodo) {
        if (nodo == null) {
            return;
        }

        GeraConexoesDOT(nodo.left);
        //   "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            System.out.println("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" " + "\n");
        }

        GeraConexoesDOT(nodo.right);
        //   "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            System.out.println("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" " + "\n");
        }
        //"[label = " << nodo->hDir << "]" <<endl;
    }

    private void GeraNodosDOT(Node nodo) {
        if (nodo == null) {
            return;
        }
        GeraNodosDOT(nodo.left);
        //node10[label = "<esq> | 10 | <dir> "];
        System.out.println("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]" + "\n");
        GeraNodosDOT(nodo.right);
    }

    public void GeraConexoesDOT() {
        GeraConexoesDOT(root);
    }

    public void GeraNodosDOT() {
        GeraNodosDOT(root);
    }

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline
    public void GeraDOT() {
        System.out.println("digraph g { \nnode [shape = record,height=.1];\n" + "\n");

        GeraNodosDOT();
        System.out.println("");
        GeraConexoesDOT(root);
        System.out.println("}" + "\n");
    }
}
