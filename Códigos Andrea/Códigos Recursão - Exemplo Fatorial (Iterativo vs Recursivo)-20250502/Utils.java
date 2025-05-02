import java.util.Scanner;

public class Utils {
    private Scanner scanner;

    public Utils() {
        this.scanner = new Scanner(System.in);
    }
    public int ler(){
        System.out.print("Digite o valor de n: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        return n;
    }


}
