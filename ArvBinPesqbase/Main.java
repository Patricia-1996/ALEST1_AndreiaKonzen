// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
          BinarySearchTreeOfInteger b = new BinarySearchTreeOfInteger();
          b.add(15);
          b.add(23);
          b.add(9);
          b.add(11);
          b.add(2);
          b.add(20);
          b.add(38);

        System.out.println("Menor elemento da arvore: " + b.getSmallest());


        //implementar metodo na classe
          //System.out.println("20 esta na arvore? " + b.contains(20));
          //System.out.println("9 esta na arvore? " + b.contains(9));
          //System.out.println("66 esta na arvore? " + b.contains(66));

        //implementar metodo na classe
          // b.remove(15);
          //b.remove(23);
          //b.remove(11);
          //b.remove(9);



          System.out.println("---------------------");
          b.GeraDOT();
    }
}
