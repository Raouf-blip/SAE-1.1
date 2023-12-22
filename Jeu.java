import java.util.Scanner;

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
        PileCartes p1 = new PileCartes(true, max); //1
        PileCartes p2 = new PileCartes(true, max); //1
        PileCartes p3 = new PileCartes(false, max); //max
        PileCartes p4 = new PileCartes(false, max); //max

        PileCartes[] ptab_temp = {p1, p2, p3, p4}; // tableau de piles
        this.piles = ptab_temp;

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

        PileCartes[] ptab_temp = {p1, p2, p3, p4}; // tableau de piles
        this.piles = ptab_temp;

        //MAIN

        this.main = new PaquetCartes();

        for (int i = 0; i < 8; i++) { // insertion de 8 cartes dans la main
            Carte c = this.pioche.prendreCarteDessus(); //on prend une carte de la pioche
            this.main.insererTri(c);
        }
    }

    /**
     * Méthode permettant de jouer une carte
     *
     * @param indice indice de la carte à jouer
     * @param numPile pile sur laquelle jouer la carte
     * @return si l'action est valable
     */
    public boolean jouerCarte(int indice, int numPile) {
        if (!(numPile >= 0 || numPile < 4)) return false; //numPile mauvais
        if (!(indice >= 0 || indice < 4)) return false; //indice mauvais

        Carte c = this.main.getCarte(indice);

        if (this.piles[numPile].etrePosable(c)) { //si la carte choisie est jouable sur la pile choisie
            this.piles[numPile].poserCarte(c); //pose la carte
            this.main.retirerCarte(indice); // retire la carte de la main
            return true;
        } else return false; // pas posable
    }

    /**
     * Méthode qui regarde si la partie doit continuer et si elle est gagnée ou non.
     *
     * @return 0 (si la partie continue), 1 (si le joueur à gagné), -1 (si le joueur à perdu)
     */
    public int etreFini() {
        if (this.main.getNbCartes() == 0) return 1; //Plus de cartes dans la main = VICTOIRE


        for (int p = 0; p < 4; p++) { //parcours de toutes les piles

            for (int i = 0; i < this.main.getNbCartes(); i++) { //parcours de toutes les cartes
                Carte c = this.main.getCarte(i);

                if (this.piles[p].etrePosable(c)) return 0; //Partie encore possible
            }
        }
        return -1; //Partie plus possible
    }

    /**
     * Méthode pour lancer le jeu.
     */
    public void lancerJeu() {
        // ETAPE 1: Démarrage
        boolean jeu = true;

        // ETAPE 2: Boucle du jeu
        while(jeu) {

            int i = 0;
            Scanner sc = new Scanner(System.in); //création scanner

            while (i < 2 && jeu) { //Tour (2 actions + récupérer 2 cartes)

                System.out.println(this.toString()); //Affichage de l'état du jeu

                //QUESTIONS ---------------------------------------------------
                int rep_c = 0; //réponse 1
                int rep_p = 0; //réponse 2
                boolean goodrep_c = false;
                boolean goodrep_p = false;

                while (!goodrep_c) { //Question 1
                    try {
                        System.out.println("Quelle carte poser ?");
                        rep_c = sc.nextInt();
                        if (rep_c < 0 || rep_c > this.main.getNbCartes()-1) System.out.println("Numéro de carte invalide");
                        else goodrep_c = true;
                    }
                    catch (java.util.InputMismatchException e) {
                        System.out.println("Veuillez entrer un entier valide.");
                        sc.next();
                    }
                }

                while (!goodrep_p) { //Question 2
                    try {
                        System.out.println("Quelle pile ?");
                        rep_p = sc.nextInt();
                        if (rep_p < 0 || rep_p > 3) System.out.println("Numéro de pile invalide");
                        else goodrep_p = true;
                    }
                    catch (java.util.InputMismatchException e) {
                        System.out.println("Veuillez entrer un entier valide.");
                        sc.next();
                    }
                }

                //ACTIONS 
                this.jouerCarte(rep_c, rep_p); //Joue la carte

                //VERIFICATION 
                jeu = this.etreFini() == 0;

                //INCREMENTER
                i++;
            }

            //DISTRIBUER 2 CARTES
            if(jeu && this.pioche.getNbCartes() != 0) { //jeu pas fini et cartes dans la pioche
                for (int j = 0; j < 2; j++) { // insertion de 2 cartes dans la main
                    Carte c = this.pioche.prendreCarteDessus(); //on prend une carte de la pioche
                    this.main.insererTri(c);
                }
            }
        }
        
        //MESSAGE DE FIN
        if(this.etreFini() == -1) System.out.println("Vous avez perdu !");
        else System.out.println("Vous avez gagné ! Bravo !");
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
        retour += this.main.toString()+"\n";

        retour += "################################################\n";

        return retour;
    }
}
