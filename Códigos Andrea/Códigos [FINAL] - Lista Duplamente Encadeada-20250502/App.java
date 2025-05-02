
public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger l = new DoubleLinkedListOfInteger();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);
        l.add(60);
        l.add(70);
        l.add(80);
        
        System.out.println(l);
        System.out.println("size="+l.size());
        l.imprimirReverse();

        System.out.println("Inserir no início:");
        l.addI(111);
        System.out.println("---");
        System.out.println(l);


        
        System.out.println("Get da posicao 2: " + l.get(2));
        System.out.println("Get da posicao 6: " + l.get(6));
        
        System.out.println("Trocou " + l.set(2, 35) + " por 35 na posicao 2.");
        
        System.out.println("Removeu 50? " + l.remove(50));
        System.out.println("Removeu 57? " + l.remove(57));
        
        System.out.println(l);
        
      
        DoubleLinkedListOfInteger l2 = new DoubleLinkedListOfInteger();
        l2.add(35);
        l2.add(5);
        l2.add(50);
        l2.add(60);
        l2.add(20);
        l2.add(10);

        System.out.println("Conteudo lista l2:\n" + l2);

        DoubleLinkedListOfInteger l3 = new DoubleLinkedListOfInteger();
        l3.add(1);
        l3.add(2);
        l3.add(3);
        l3.add(4);
        l3.add(2);
        l3.add(1);
        l3.add(5);
        l3.add(6);
        l3.add(3);
        l3.add(1);
        System.out.println("l3: \n" + l3);

    }
    
}
