import java.rmi.UnexpectedException;
import java.util.Arrays;
import java.util.Random;

public class PaquetCartes {

    private Carte[] cartes;

    /**
     * Constructeur qui crée un paquet vide
     */
    public PaquetCartes() {
        this.cartes = new Carte[0];
    }

    /**
     * Constructeur qui crée un paquet à partir d'un tableau de carte
     *
     * @param tab tableau de cartes
     */
    public PaquetCartes(Carte tab[]) {
        this.cartes = tab;
    }

    /**
     * Constructeur qui crée un paquet à partir d'un tableau de carte
     *
     * @param tab tableau d'entiers (qui représente la valeur des futures cartes)
     */
    public PaquetCartes(int tab[]) {
        Carte[] new_tab_cartes = new Carte[tab.length];

        for(int i = 0; i < tab.length-1; i++) {
            new_tab_cartes[i] = new Carte(tab[i]);
        }
    }

    /**
     * Méthode qui retourne le nombre de cartes dans un paquet
     *
     * @return le nombre de cartes
     */

    // GETTERS
    public int getNbCartes() {
        return cartes.length;
    }

    /**
     * Méthode qui retourne la carte à la position voulue
     *
     * @param place place de la carte qu'on veut voir
     * @return la carte de la place recherchée
     */
    public Carte getCarte(int place){
        if (place >= 0 && place < this.cartes.length) return cartes[place];
        else return null;
    }

    /**
     * Méthode qui retourne la dernière carte d'un paquet
     *
     * @return la dernière carte du paquet
     */
    public Carte getDerniereCarte() {
        return cartes[this.cartes.length-1];
    }

    /**
     * Méthode qui retourne si un paquet est vide ou non
     *
     * @return
     */
    public boolean etreVide() {
        return this.cartes.length == 0;
    }


    /**
     * Méthode qui ajoute une carte à la fin d'un paquet
     *
     * @param new_carte carte à ajouter
     */
    public void ajouterCarteFin(Carte new_carte) {
        Carte[] new_tab_cartes = new Carte[this.cartes.length+1];

        for (int i = 0; i < this.cartes.length; i++) {
            new_tab_cartes[i] = this.cartes[i];
        }
        new_tab_cartes[this.cartes.length] = new_carte;

        this.cartes = new_tab_cartes;
    }

    /**
     * Méthode qui retire une carte d'un paquet à une place donnée
     *
     * @param place place à laquelle la carte va être retirée
     * @return carte qui à été retirée du paquet
     */
    public Carte retirerCarte(int place) {
        if (place < 0 && place >= this.cartes.length) {
            return null;
        }

        Carte[] new_tab_cartes = new Carte[this.cartes.length-1];

        Carte carte_retournee = this.cartes[place];

        for (int i = 0; i < place; i++) {
            new_tab_cartes[i] = this.cartes[i];
        }

        for (int i = place+1; i < this.cartes.length; i++) {
            new_tab_cartes[i-1] = this.cartes[i];
        }

        this.cartes = new_tab_cartes;

        return carte_retournee;
    }

    /**
     * Méthode qui crée un paquet de carte pour le jeu The Game (de C2 à C99)
     *
     * @param max nombre de carte dans le paquet (100 = 98 cartes dans le deck)
     */
    public void remplir(int max) {
        Carte[] new_tab_cartes = new Carte[max-3];

        for(int i = 0; i < max-1; i++) {
            new_tab_cartes[i] = new Carte(i+2);
        }

        this.cartes = new_tab_cartes;
    }

    /**
     * Méthode qui retourne une carte au hasard dans le paquet
     *
     * @return carte aléatoire du paquet
     */
    private Carte piocherHasard(){ //Usage pour la méthode melangerPaquet
        Random rnd = new Random();
        return this.cartes[rnd.nextInt(this.cartes.length-1)];
    }

    /**
     * Méthode qui mélange un paquet à l'aide de la méthode piocherHasard
     */
    public void melangerPaquet(){
        Carte[] new_tab_cartes = new Carte[0]; //creer un paquet vide

        for (int i = 0; i < this.cartes.length-1; i++) new_tab_cartes[i] = this.piocherHasard();

        this.cartes = new_tab_cartes;
    }


    /**
     * Méthode qui place une carte dans un paquet trié dans l'ordre croissant
     *
     * @param c la carte placée dans le paquet
     */
    public void insererTri(Carte c) {

        Carte[] new_tab_cartes = new Carte[this.cartes.length+1];

        int p = 0;
        while (c.getValeur() > this.cartes[p].getValeur() && p < this.cartes.length -1) { //Recherche de la bonne place (p)
            new_tab_cartes[p] = this.cartes[p]; //recopie des cartes
            p++;
        }

        new_tab_cartes[p] = c; //insertion de la carte à la postion p

        for (int i = p; i < this.cartes.length-1; i++) { //recopie des cartes restantes
            new_tab_cartes[i+1] = this.cartes[i];
        }

        this.cartes = new_tab_cartes;
    }

    /**
     * Méthode qui retourne la carte du dessus.
     *
     * @return carte prise
     */
    public Carte prendreCarteDessus() {
        return retirerCarte(0);
    }


    /**
     * @return affichage des cartes dans le paquet
     */
    public String toString() {
        String retour = "";

        if (this.cartes.length == 0) retour += "Aucune carte";
                else {
                    for (int i = 0; i < this.cartes.length; i++){
                        retour += i + "-c"+ this.cartes[i].getValeur()+" ";
                    }
                }

        return retour;
    }
}
