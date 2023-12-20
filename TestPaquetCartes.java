import static libtest.Lanceur.lancer;

public class TestPaquetCartes {

    /**
     * test des methodes
     */
    public void test_0_verifieMethodes() {
        // Question 4.1
        Carte[] tabC = {new Carte(10), new Carte(20)};
        PaquetCartes paq = new PaquetCartes(tabC);
        paq.ajouterCarteFin(new Carte(25));
        paq.retirerCarte(0);

        // Question 4.2
        PaquetCartes paq2 = new PaquetCartes();

        // Question 4.3
        paq2.remplir(20);

        // Question 4.4
        int tabInt[] = {10,20,30,40,50};
        PaquetCartes paq3 = new PaquetCartes(tabInt);

        // Question 4.5
        Carte c = paq.getCarte(0);
        Carte c2 = paq.getDerniereCarte();
        int nb = paq.getNbCartes();
        boolean vide = paq.etreVide();

        // question 4.7
        paq.melangerPaquet();

        // question  4.8
        paq.insererTri(new Carte(23));

        // question  4.9
        Carte c3 = paq.prendreCarteDessus();

    }

    /**
     * lancement des tests
     */
    public static void main(String args[]) {
        lancer(new TestPaquetCartes(), args);
    }
}
