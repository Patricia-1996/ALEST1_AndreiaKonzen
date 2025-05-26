import java.nio.file.WatchEvent.Kind;

public class Main {
    public static void main(String[] args) {
        GeneralTreeOfString arvoreFamilia = new GeneralTreeOfString();

        // Construindo a árvore genealógica
        arvoreFamilia.add("Nadeshiko Kinomoto", null); // Corrigido: 'null' como String não é necessário
        arvoreFamilia.add("Fujitaka Kinomoto", null); // Ajustado: 'null' corretamente
        arvoreFamilia.add("Sakura Kinomoto", "Nadeshiko Kinomoto");
        arvoreFamilia.add("Touya Kinomoto", "Nadeshiko Kinomoto");
        arvoreFamilia.add("Tomoyo Daidouji", "Fujitaka Kinomoto");
        arvoreFamilia.add("Sonomi Daidouji", "Fujitaka Kinomoto");
        arvoreFamilia.add("Kaho Mizuki", "Fujitaka Kinomoto");
        arvoreFamilia.add("Yukito Tsukishiro", "Touya Kinomoto");
        arvoreFamilia.add("Kerochan", "Sakura Kinomoto");
        arvoreFamilia.add("Spinel Sun", "Sakura Kinomoto");
        arvoreFamilia.add("Eriol Hiiragizawa", "Kaho Mizuki");
        arvoreFamilia.add("Rika Shiramine", "Tomoyo Daidouji");
        arvoreFamilia.add("Yue", "Sakura Kinomoto");
        arvoreFamilia.add("Mokona", "Sakura Kinomoto");
        arvoreFamilia.add("Sakura Avalon", "Sakura Kinomoto"); // Adicionando Sakura Avalon como filha de Sakura nodeSakuraKinomoto
        arvoreFamilia.add("Syaoran Li", "Sakura Avalon");
        arvoreFamilia.add("Meiling Li", "Syaoran Li");
        arvoreFamilia.add("Tomoyo Kinomoto", "Sakura Avalon");
        arvoreFamilia.add("Kaito", "Sakura Avalon");
        arvoreFamilia.add("Akiho Shinomoto", "Sakura Avalon");
        arvoreFamilia.add("Rika Kinomoto", "Sakura Avalon");
        

        System.out.println("=== Árvore Genealógica de Sakura Kinomoto ===");
        System.out.println("\nCaminhamento em largura:");
        System.out.println(arvoreFamilia.positionsWidth());

        System.out.println("\nCaminhamento pré-fixado:");
        System.out.println(arvoreFamilia.positionsPre());

        System.out.println("\nCaminhamento pós-fixado:");
        System.out.println(arvoreFamilia.positionsPos());

        System.out.println("\nNível de Tomoyo Daidouji: " + 
            arvoreFamilia.level("Tomoyo Daidouji"));

        System.out.println("\n=== Código DOT para Visualização ===");
        arvoreFamilia.geraDOT();

        System.out.println("\nCopie o código DOT acima e cole em:");
        System.out.println("https://dreampuf.github.io/GraphvizOnline/");
    }
}
