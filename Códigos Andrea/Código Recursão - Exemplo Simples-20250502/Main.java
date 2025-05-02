public class Main {

    public static void recursao1 (){
        for (int i = 0; i < 5; i++){
            System.out.println("Alo mundo!");
        }
    }

    public static void recursao2(int cont){
        System.out.println("Alo mundo");
        cont++;
        if (cont < 5){
            recursao2(cont);
        }
    }

    public static void main(String[] args) {

        recursao1();
        recursao2(0);
    }
}