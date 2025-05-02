import jdk.jshell.execution.Util;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Utils util = new Utils();
        Fatorial fatorial = new Fatorial();

        int n;
        double time_execution;
        String opcao = "";

        while (!opcao.equalsIgnoreCase("S")) {
            System.out.println("--- FATORIAL ---- ");
            System.out.println("[I]terativo");
            System.out.println("[R]ecursivo");
            System.out.println("[S]air");

            opcao = scanner.nextLine().toUpperCase();

            switch (opcao) {
                case "I":
                    System.out.println("- Iterativo -");
                    n = util.ler();
                    long start = System.currentTimeMillis();
                    int resultadoIterativo = fatorial.iterativo(n);
                    long stop = System.currentTimeMillis();
                    time_execution = (double) (stop - start) / 1000.0;
                    System.out.println("[I] Fatorial de " + n + " é " + resultadoIterativo);
                    System.out.println("Tempo: " + time_execution);
                    break;
                case "R":
                    System.out.println("- Recursivo -");
                    n = util.ler();
                    long start2 = System.currentTimeMillis();
                    int resultadoRecursivo = fatorial.recursivo(n);
                    long stop2 = System.currentTimeMillis();
                    time_execution = (double) (stop2 - start2) / 1000.0;
                    System.out.println("[R] Fatorial de " + n + " é " + resultadoRecursivo);
                    System.out.println("Tempo: " + time_execution);
                    break;
                case "S":
                    System.out.println("Encerrando execução do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}
