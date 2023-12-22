import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

public class TestJeu {

    /**
     * test des methodes
     */
    public void test_0_verifieMethodes(){
        // question 6.2
        Jeu jeu = new Jeu(50);

        // question 6.1
        PaquetCartes p = jeu.getMain();
        PaquetCartes pioche = jeu.getPioche();
        PileCartes[] piles = jeu.getPiles();

        // question 6.3
        String s = jeu.toString();

        // question 6.4
        PaquetCartes paquet = new PaquetCartes();
        paquet.remplir(10);
        Jeu jeu2 = new Jeu(paquet);

        // question 6.5
        boolean res = jeu.jouerCarte(0,0);

        // question 6.6
        int fin = jeu.etreFini();
    }

    /**
     * Test du constructeur avec un maximum de carte donnée
     * @Test
     */
    public void test_constructeur_OK(){
        Jeu jeu = new Jeu(100);

        assertEquals("La pioche n'a pas 90 cartes", 90, jeu.getPioche().getNbCartes());
        assertEquals("La pile 1 n'est pas bonne", 1, jeu.getPiles()[0].getDerniereCarte().getValeur());
        assertEquals("La pile 3 n'est pas bonne", 100, jeu.getPiles()[2].getDerniereCarte().getValeur());
        assertEquals("La main n'est pas rempli", 8, jeu.getMain().getNbCartes());
    }

    /**
     * Test du constructeur avec un paquet existant
     * @Test
     */
    public void test_constructeurPaquetExistant_OK(){
        PaquetCartes PC = new PaquetCartes();
        PC.remplir(100);
        Jeu jeu = new Jeu(PC);

        assertEquals("La pioche n'a pas 90 cartes", 90, jeu.getPioche().getNbCartes());
        assertEquals("Les piles ne sont pas bonnes", 1, jeu.getPiles()[0].getDerniereCarte().getValeur());
        assertEquals("La main n'est pas rempli", 8, jeu.getMain().getNbCartes());
    }

    /**
     * Test pour jouer une carte
     * @Test
     */
    public void test_jouerCarte_OK(){
        Jeu jeu = new Jeu(100);

        //fonction testee
        Carte c = jeu.getMain().getCarte(0);
        jeu.jouerCarte(0, 1);
        
        assertEquals("La carte doit être posable", true, jeu.getPiles()[0].etrePosable(c));
        assertEquals("La carte posé n'est pas celle souhaité", c.getValeur(),jeu.getPiles()[1].getDerniereCarte().getValeur());
    }

    /**
     * Test pour check si une partie est gagné
     * @Test
     */
    public void test_etreFini_WIN(){
        Jeu jeu = new Jeu(100);

        //Programme pour faire jouer toutes les cartes de la main du joueur
        int nbCartesMain = jeu.getMain().getNbCartes();
        for (int i = 0; i < nbCartesMain; i++) {
            Carte c = jeu.getMain().getCarte(0); //On prend toujours la 1ère carte

            for (int p = 0; p < jeu.getPiles().length; p++) {
                if (jeu.getPiles()[p].etrePosable(c)) {
                    jeu.jouerCarte(0, p + 1);
                    break; //On sort de la boucle interne après avoir jouer la carte
                }
            }
        }

        assertEquals("Le joueur n'est plus sensé avoir de carte en main", 0, jeu.getMain().getNbCartes());
        assertEquals("Le joueur doit avoir gagné", 1, jeu.etreFini());
    }


    /**
     * Test pour check si une partie est perdu
     * @Test
     */
    public void test_etreFini_LOOSE(){
        int tab[] = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        PaquetCartes PC = new PaquetCartes(tab);
        Jeu jeu = new Jeu(PC);
        jeu.jouerCarte(7, 0);
        jeu.jouerCarte(6, 0);
        jeu.jouerCarte(6, 1);
        jeu.jouerCarte(0, 2);
        jeu.jouerCarte(0, 3);

        assertEquals("Le joueur doit avoir perdu", -1, jeu.etreFini());
    }

    /**
     * Test pour check si une partie n'est pas fini
     * @Test
     */
    public void test_etreFini_CONTINU(){
        int tab[] = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        PaquetCartes PC = new PaquetCartes(tab);
        Jeu jeu = new Jeu(PC);
        jeu.jouerCarte(7, 2);
        jeu.jouerCarte(6, 1);
        jeu.jouerCarte(6, 1);
        jeu.jouerCarte(0, 0);
        jeu.jouerCarte(0, 0);

        assertEquals("Le joueur doit avoir perdu", 0, jeu.etreFini());
    }

    /**
     * Test pour check si la chaine de caractère est conforme à la syntaxe demandée
     * @Test
     */
    public void test_toString_OK(){
        Jeu jeu = new Jeu(10);

        assertEquals("La chaine de caractère renvoyé n'est pas la bonne", "################################################\n- PILE 0 : c-c1-(1)\n- PILE 1 : c-c1-(1)\n- PILE 2 : d-c10-(1)\n- PILE 3 : d-c10-(1)\n################################################\nReste 0 cartes dans la pioche\n################################################\nMain du joueur :\n0-c2 1-c3 2-c4 3-c5 4-c6 5-c7 6-c8 7-c9 \n################################################\n", jeu.toString());
    }

    /**
     * lancement des tests
     */
    public static void main(String args[])
    {
        lancer(new TestJeu(),args);
    }
}
