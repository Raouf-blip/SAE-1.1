import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("\"The Game\" est un defi ou votre objectif est de vous debarrasser de toutes les cartes du jeu. Vous commencez avec une main de cartes de 8 cartes et devez jouer successivement des cartes sur deux piles croissantes et deux piles decroissantes. Si vous avez une carte avec une difference de 10 par rapport a la carte superieure d'une pile, vous pouvez la poser meme si cela ne respecte pas la premiere regle.\n");

        System.out.println("Sur quel nombre de cartes voulez vous jouer ?");

        Scanner sc = new Scanner(System.in);
        int val = 0;
        while (val < 10) {
            try {
                val = sc.nextInt();
                if (val < 10) System.out.println("Entrez une valeur superieure a 10.");
            } catch (java.util.InputMismatchException e) {
                System.out.println("Veuillez entrer un entier valide.\n");
                sc.next();
            }

        }

        Jeu jeu1 = new Jeu(val);

        jeu1.lancerJeu();

    }
}
