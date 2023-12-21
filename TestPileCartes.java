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

        assertEquals("la première carte devrait être 1", c.getValeur(), pile.getDerniereCarte().getValeur());
    }

    public void test_2_constructeur_d(){
        PileCartes pile = new PileCartes(false, 30);
        Carte c = new Carte(30);

        assertEquals("la première carte devrait être 30", c.getValeur(), pile.getDerniereCarte().getValeur());
    }

    public void test_3_etrePossible_c(){
        PileCartes pile = new PileCartes(true, 30);
        Carte c = new Carte(23);
        pile.poserCarte(c);

        Carte c1 = new Carte(24);
        Carte c2 = new Carte(3);
        Carte c3 = new Carte(13);

        assertEquals("la carte 24 devrait être posable sur la 23", true, pile.etrePosable(c1));
        assertEquals("la carte 3 ne devrait pas être posable sur la 23", false, pile.etrePosable(c2));
        assertEquals("la carte 13 devrait être posable sur la 23 (règle de 10)", true, pile.etrePosable(c3));
    }

    public void test_4_etrePossible_d(){
        PileCartes pile = new PileCartes(false, 30);
        Carte c = new Carte(13);
        pile.poserCarte(c);

        Carte c1 = new Carte(3);
        Carte c2 = new Carte(15);
        Carte c3 = new Carte(23);

        assertEquals("la carte 3 devrait être posable sur la 13", true, pile.etrePosable(c1));
        assertEquals("la carte 15 ne devrait pas être posable sur la 13", false, pile.etrePosable(c2));
        assertEquals("la carte 23 devrait être posable sur la 13 (règle de 10)", true, pile.etrePosable(c3));
    }

    public void test_5_poserCarte_c(){
        PileCartes pile = new PileCartes(true,30);
        Carte c1 = new Carte(13);
        Carte c2 = new Carte(12);
        Carte c3 = new Carte(3);

        assertEquals("la carte 13 devrait être posée", true, pile.poserCarte(c1));
        assertEquals("la carte 12 ne devrait pas être posée (la 3 étant posée)", false, pile.poserCarte(c2));
        assertEquals("la carte 3 devrait être posée sur la 13 (règle de 10)", true, pile.poserCarte(c3));
    }

    public void test_5_poserCarte_d(){
        PileCartes pile = new PileCartes(false,30);
        Carte c1 = new Carte(13);
        Carte c2 = new Carte(15);
        Carte c3 = new Carte(23);

        assertEquals("la carte 13 devrait être posée", true, pile.poserCarte(c1));
        assertEquals("la carte 15 ne devrait pas être posée (la 13 étant posée)", false, pile.poserCarte(c2));
        assertEquals("la carte 23 devrait être posée sur la 13 (règle de 10)", true, pile.poserCarte(c3));
    }

    public void test_6_toString(){
        PileCartes pile = new PileCartes(true,30);
        Carte c1 = new Carte(13);
        Carte c2 = new Carte(12);
        Carte c3 = new Carte(3);

        pile.poserCarte(c1);
        pile.poserCarte(c2);
        pile.poserCarte(c3);

        assertEquals("la carte 13 devrait être posée", "c-c3-(3)", pile.toString());
    }







    /**
     * lancement des tests
     */
    public static void main(String args[])
    {
        lancer(new TestPileCartes(),args);
    }
}
