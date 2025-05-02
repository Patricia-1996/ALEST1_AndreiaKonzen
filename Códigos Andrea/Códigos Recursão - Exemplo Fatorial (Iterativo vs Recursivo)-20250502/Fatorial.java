public class Fatorial {
    public int recursivo(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * recursivo(n - 1);
        }
    }

    public int iterativo(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
