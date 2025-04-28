public class App {
    public static void main(String[] args) {
        Pilha p = new Pilha();
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.pop();


  /*      int tam = p.size();
        for(int i=0; i<tam; i++) {
            System.out.println(p.pop());
        }
    */
        while(!p.isEmpty()) {
            System.out.println(p.pop());
        }

        System.out.println("Invertida: " + inverterString("alest"));
        System.out.println("Resultado posfixa: " + avaliarPosfixa("3 4 + 5 *")); // Deve imprimir 35

    }
    public static void inverte(Integer vet[]) {

    }
    public static Pilha getClone(Pilha p) {
        return null;
    }

    public static void addAll(Pilha p, LinkedListOfInteger l) {

    }

    // Método que inverte uma String usando uma Pilha
public static String inverterString(String s) {
    Pilha pilha = new Pilha();
    for (int i = 0; i < s.length(); i++) {
        pilha.push((int) s.charAt(i));
    }

    StringBuilder invertida = new StringBuilder();
    while (!pilha.isEmpty()) {
        invertida.append((char) pilha.pop().intValue());
    }

    return invertida.toString();
}

// Método que avalia uma expressão aritmética em notação pós-fixada
public static int avaliarPosfixa(String expressao) {
    Pilha pilha = new Pilha();
    String[] tokens = expressao.split(" ");

    for (String token : tokens) {
        if (token.matches("\\d+")) {
            pilha.push(Integer.parseInt(token));
        } else {
            int b = pilha.pop();
            int a = pilha.pop();
            switch (token) {
                case "+": pilha.push(a + b); break;
                case "-": pilha.push(a - b); break;
                case "*": pilha.push(a * b); break;
                case "/": pilha.push(a / b); break;
                default:
                    throw new IllegalArgumentException("Operador inválido: " + token);
            }
        }
    }

    return pilha.pop();
}

   
    

}
