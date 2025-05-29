// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BinaryTreeOfInteger b = new BinaryTreeOfInteger();
        b.addRoot(1);
        b.addLeft(2, 1);
        b.addRight(3, 1);
        b.addRight(0, 3);
        b.addLeft(4, 2);
        b.addRight(5, 2);
        b.addRight(6, 5);
        b.addRight(7, 6);

        System.out.println("Total de nodos da arvore: " + b.size());

        System.out.println("[1] Caminhamento pre:");
        System.out.println(b.positionsPre());

        b.setRoot(10);

        System.out.println("[2] Caminhamento pre:");
        System.out.println(b.positionsPre());

        System.out.println(b.contains(4));
    }
}