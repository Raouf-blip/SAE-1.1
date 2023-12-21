import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

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
     * Test du constructeur vide
     * @Test
     */
    public void test_constructeurVide_OK(){
        PaquetCartes PC = new PaquetCartes();

        assertEquals("Le paquet est sensé être vide", 0, PC.getNbCartes());
    }

    /**
     * Test du constructeur avec un paramètre
     * @Test
     */
    public void test_constructeurParam_OK(){
        int tab[] = {2,3};
        Carte c1 = new Carte(tab[0]);
        Carte c2 = new Carte(tab[1]);
        PaquetCartes PC = new PaquetCartes(tab);

        assertEquals("La carte n'a pas la bonne valeur", 2, c1.getValeur());
        assertEquals("La carte n'a pas la bonne valeur", 3, c2.getValeur());
        assertEquals("Le paquet devrait avoir 2", 2, PC.getNbCartes());
    }

    /**
     * Test pour check le nombre de cartes
     * @Test
     */
    public void test_getNbCartes_OK(){
        PaquetCartes PC = new PaquetCartes();

        assertEquals("Le paquet devrait avoir 0 cartes", 0, PC.getNbCartes());
    }

    /**
     * Test pour check si la carte à l'emplacement donné a la bonne valeur
     * @Test
     */
    public void test_getCarte_OK(){
        int tab[] = {2};
        Carte c1 = new Carte(tab[0]);
        PaquetCartes PC = new PaquetCartes(tab);

        assertEquals("La carte n'est pas celle attendu", c1, PC.getCarte(0));
    }

    /**
     * Test si la fonction getDernireCarte() renvoie bien la dernière carte du paquet
     * @Test
     */
    public void test_getDerniereCarte_OK(){
        int tab[] = {2,3};
        Carte c1 = new Carte(tab[0]);
        Carte c2 = new Carte(tab[1]);
        PaquetCartes PC = new PaquetCartes(tab);

        assertEquals("La carte renvoyé n'est pas la dernière", c2, PC.getDerniereCarte());
    }

    /**
     * Test si le paquet est vide
     * @Test
     */
    public void test_etreVide_OK(){
        PaquetCartes PC = new PaquetCartes();
        assertEquals("Le paquet doit être vide", true, PC.etreVide());
    }

    /**
     * Test si le paquet est pas vide
     * @Test
     */
    public void test_etreVide_NON(){
        int tab[] = {2,3};
        Carte c1 = new Carte(tab[0]);
        Carte c2 = new Carte(tab[1]);
        PaquetCartes PC = new PaquetCartes(tab);
        assertEquals("Le paquet ne doit pas être vide", false, PC.etreVide());
    }

    /**
     * Test si une carte s'ajoute à la fin du paquet
     * @Test
     */
    public void test_ajouterCarteFin_OK(){
        int tab[] = {2,3};
        Carte c1 = new Carte(tab[0]);
        Carte c2 = new Carte(tab[1]);
        Carte c3 = new Carte(5);
        PaquetCartes PC = new PaquetCartes(tab);

        //fonction testee
        PC.ajouterCarteFin(c3);

        assertEquals("La dernière carte n'est pas celle attendu", c3, PC.getDerniereCarte());
    }

    /**
     * Test si on retire une carte
     * @Test
     */
    public void test_retirerCarte_OK(){
        int tab[] = {2,3};
        Carte c1 = new Carte(tab[0]);
        Carte c2 = new Carte(tab[1]);
        Carte c3 = new Carte(5);
        PaquetCartes PC = new PaquetCartes(tab);

        //fonction testee
        PC.retirerCarte(2);

        assertEquals("La carte à l'emplacement 2 existe toujours", c2, PC.getDerniereCarte());
    }

    /**
     * Test si le paquet se remplit jusqu'au maximum selon les principes de la fonction remplir()
     * @Test
     */
    public void test_remplir_OK(){
        PaquetCartes PC = new PaquetCartes();

        //fonction testee
        PC.remplir(100);

        assertEquals("Il doit y avoir 98 cartes", 98, PC.getNbCartes());
    }

    /**
     * Test de l'insertion d'une carte dans un paquet trier par ordre croissant
     * @Test
     */
    public void test_insererTri_OK(){
        int tab[] = {2,10};
        Carte c1 = new Carte(tab[0]);
        Carte c2 = new Carte(tab[1]);
        Carte c3 = new Carte(5);
        PaquetCartes PC = new PaquetCartes(tab);
        
        //fonction testee
        PC.insererTri(c3);

        assertEquals("La carte c3 est sensé être à la 2ème place du paquet", c3, PC.getCarte(1));
    }
    
    /**
     * Test si l'on retire la carte du dessus
     * @Test
     */
    public void test_prendreCarteDessus_OK(){
        int tab[] = {2,10};
        Carte c1 = new Carte(tab[0]);
        Carte c2 = new Carte(tab[1]);
        PaquetCartes PC = new PaquetCartes(tab);

        assertEquals("Il faut la carte du dessus", c1, PC.prendreCarteDessus());
        assertEquals("Il doit y avoir une carte de moins", 1, PC.getNbCartes());
    }
    
    public void test_toString(){
        int tab[] = {2,10};
        Carte c1 = new Carte(tab[0]);
        Carte c2 = new Carte(tab[1]);
        PaquetCartes PC = new PaquetCartes(tab);

        assertEquals("La chaine renvoyé n'est pas bonne", "0-c2 1-c10", PC.toString());
    }

    /**
     * lancement des tests
     */
    public static void main(String args[]) {
        lancer(new TestPaquetCartes(), args);
    }
}
