import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

public class TestCarte {

    /**
     * test des methodes
     */
    public void test_0_verifieMethodes(){
        Carte c = new Carte(10);
        Carte c2 = new Carte(20);

        int v = c.getValeur();
        String s = c.toString();

        boolean res = c.etrePlusGrand(c2);
        boolean diff = c.avoirDiffDe10(c2);
    }

    /**
     * test pour check si la carte a bien la valeur qui lui est attribué
     * @Test
     */
    public void test_getValeur_OK(){
        Carte carte = new Carte(3);
        
        assertEquals("La valeur ne correspond pas à celle de la carte", 3, carte.getValeur());
    }

    /**
     * Test pour check si la chaine de caractères renvoyé par toString() correspond bien c[valeur de la carte]
     * @Test
     */
    public void test_toString_OK(){
        Carte carte = new Carte(3);

        assertEquals("La chaine retournée ne correspond pas à : c[valeur de la carte]", "c3", carte.toString());
    }

    /**
     * test pour vérifier la fonction etrePlusGrand() renvoie bien true si une carte est plus grande qu'une autre
     * @Test
     */
    public void test_etrePlusGrand_OK(){
        Carte carte1 = new Carte(3);
        Carte carte2 = new Carte(5);
        Carte carte3 = new Carte(5);
        
        assertEquals("La carte 2 est sensé être plus grande que la carte 1", true, carte2.etrePlusGrand(carte1));
        assertEquals("La carte 1 est sensé être plus petite que la carte 2", false, carte1.etrePlusGrand(carte2));
        assertEquals("La carte 2 est sensé avoir la meme valeur que la carte 3", false, carte2.etrePlusGrand(carte3));
    }

    /**
     * test pour vérifier si deux cartes ont bien une différence de 10 exactement, avec la fonction avoirDiffDe10()
     * @Test
     */
    public void test_avoirDiffDe10_OK(){
        Carte carte1 = new Carte(3);
        Carte carte2 = new Carte(13);
        Carte carte3 = new Carte(15);

        assertEquals("Il doit y avoir une différence de 10 entre la carte 1 et 2", true, carte1.avoirDiffDe10(carte2));
        assertEquals("Il ne doit pas y avoir une différence de 10 entre la carte 1 et 2", false, carte1.avoirDiffDe10(carte3));
    }

    /**
     * lancement des tests
     */
    public static void main(String args[])
    {
        lancer(new TestCarte(),args);
    }
}
