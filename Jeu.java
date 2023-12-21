public class Jeu {

    private PaquetCartes main;

    private PaquetCartes pioche;

    private PileCartes[] piles;

    /**
     * @return la main du joueur
     */
    public PaquetCartes getMain() {
        return main;
    }

    /**
     * @return la pioche
     */
    public PaquetCartes getPioche() {
        return pioche;
    }

    /**
     * @return les différentes piles
     */
    public PileCartes[] getPiles() {
        return piles;
    }

    /**
     * Constructeur qui initialise le jeu
     *
     * @param max nombre de cartes max danns le jeu (max: 100 = 98 cartes dans la pioche - cartes en main)
     */
    public Jeu(int max) {

        // PIOCHE
        this.pioche = new PaquetCartes(); //Créer la pioche
        this.pioche.remplir(max); //Remplir la pioche
        this.pioche.melangerPaquet(); //Randomiser la pioche


        //PILES
        int m = pioche.getNbCartes();

        PileCartes p1 = new PileCartes(true, m); //1
        PileCartes p2 = new PileCartes(true, m); //1
        PileCartes p3 = new PileCartes(false, m); //max
        PileCartes p4 = new PileCartes(false, m); //max

        PileCartes[] piles = {p1, p2, p3, p4}; // tableau de piles


        //MAIN

        this.main = new PaquetCartes();

        for (int i = 0; i < 8; i++) { // insertion de 8 cartes dans la main
            Carte c = this.pioche.prendreCarteDessus(); //on prend une carte de la pioche
            this.main.insererTri(c);
        }
    }

    /**
     * Constructeur qui initialise le jeu à partir d'un paquet existant
     *
     * @param paquet paquet de départ
     */
    public Jeu(PaquetCartes paquet) {

        // PIOCHE
        this.pioche = paquet;

        //PILES
        int m = pioche.getNbCartes();

        PileCartes p1 = new PileCartes(true, m); //1
        PileCartes p2 = new PileCartes(true, m); //1
        PileCartes p3 = new PileCartes(false, m); //max
        PileCartes p4 = new PileCartes(false, m); //max

        PileCartes[] piles = {p1, p2, p3, p4}; // tableau de piles


        //MAIN

        this.main = new PaquetCartes();

        for (int i = 0; i < 8; i++) { // insertion de 8 cartes dans la main
            Carte c = this.pioche.prendreCarteDessus(); //on prend une carte de la pioche
            this.main.insererTri(c);
        }
    }

    public boolean jouerCarte(int indice, int numPile) { // en build
        if (!(numPile >= 0 || numPile < 4)) return false;
        if (!(indice >= 0 || indice < 4)) return false;
        return true;
    }

    /**
     * @return affichage du jeu
     */
    public String toString() {
        String retour = "################################################\n";

        // Affichage piles
        for (int i = 0; i < 4; i++) {
            retour += "- PILE "+ i + " : " + this.piles[i].toString() +"\n";
        }

        retour += "################################################\n";

        // Affichage cartes restantes
        retour += "Reste " + this.pioche.getNbCartes() + " cartes dans la pioche\n";

        retour += "################################################\n";

        // Affichage main du joueur
        retour += "Main du joueur :\n";
        retour += this.main.toString();

        retour += "################################################\n";

        return retour;
    }
}


