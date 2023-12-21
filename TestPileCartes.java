import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;

public class TestPileCartes {

    /**
     * test des methodes
     */
    public void test_0_verifieMethodes(){
        // question 5.1
        PileCartes pile = new PileCartes(true,20);

        // question 5.2
        boolean res = pile.etrePosable(new Carte(15));

        // question 5.3
        boolean res2 = pile.poserCarte(new Carte(13));

        // question 5.5
        Carte c = pile.getDerniereCarte();
    }

    public void test_1_constructeur_c(){
        PileCartes pile = new PileCartes(true, 30);
        Carte c = new Carte(1);

        assertEquals("la première carte devrait être 1", c, pile.getDerniereCarte());
    }

    public void test_1_constructeur_d(){
        PileCartes pile = new PileCartes(true, 30);
        Carte c = new Carte(100);

        assertEquals("la première carte devrait être 100", c, pile.getDerniereCarte());
    }



    /**
     * lancement des tests
     */
    public static void main(String args[])
    {
        lancer(new TestPileCartes(),args);
    }
}
