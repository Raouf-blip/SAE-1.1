public class PileCartes {

    private boolean croissant;
    private PaquetCartes paquet;

    /**
     * Constructeur qui initialise une pile de carte avec pour première carte 1 (si la pile est croissante) ou 100 (si la pile est decroissante).
     *
     * @param pCroissant si la pile est décroissante ou croissante
     * @param max la taille max du paquet
     */
    public PileCartes(boolean pCroissant, int max) {
        this.paquet = new PaquetCartes();
        Carte c;

        this.croissant = pCroissant;

        if(pCroissant) c = new Carte(1);
        else c = new Carte(max);

        this.paquet.ajouterCarteFin(c);
    }

    /**
     * Méthode qui vérifie si la carte est posable sur la pile
     *
     * @param c Carte que l'on veut poser
     * @return true si la carte est posable
     */
    boolean etrePosable(Carte c) {
        int valcp = this.paquet.getDerniereCarte().getValeur(); // Valeur de la carte en haut de la pile
        int valc = c.getValeur(); // Valeur de la carte c

        if (this.croissant) { //si c'est croissant
            if (valc > valcp) { //si la carte est sup
                return true;
            }
        } else if (valc < valcp) { //sinon si la carte est inf
            return true;
        }

        if ((valc - valcp == 10) || (valcp - valc == 10)) {
            return true;
        }
        return false; // si aucune condition est valide
    }

    /**
     * Méthode qui pose une carte sur la pile
     *
     * @param c carte posée
     * @return true si la carte fut posée, false dans le cas contraire
     */
    boolean poserCarte(Carte c) {
        if (this.etrePosable(c)) {
            this.paquet.ajouterCarteFin(c);
            return true;
        } else return false;
    }

    /**
     * Méthode pour les tests
     *
     * @return dernière carte de la pile
     */
    public Carte getDerniereCarte() {
        return this.paquet.getDerniereCarte();
    }

    /**
     * @return affichage des cartes dans la pile
     */
    public String toString() {
        String retour = "";

        if(this.croissant) retour += "c";
        else retour += "d";

        retour+= "-c" + this.paquet.getDerniereCarte().getValeur() + "-(" + this.paquet.getNbCartes() + ")";

        return retour;
    }
}

