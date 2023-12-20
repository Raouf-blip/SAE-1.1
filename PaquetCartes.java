public class PaquetCartes {

    private Carte[] cartes;

    public PaquetCartes() {
        this.cartes = new Carte[0];
    }

    public PaquetCartes(Carte tab[]) {
        this.cartes = tab;
    }

    public int getNbCartes() {
        return cartes.length;
    }

    public Carte getCarte(int place){
        if (place >= 0 && place < this.cartes.length) return cartes[place];
        else return null;
    }

    public void ajouterCarteFin(Carte new_carte) {
        Carte[] new_tab_cartes = new Carte[this.cartes.length+1];

        for (int i = 0; i < this.cartes.length; i++) {
            new_tab_cartes[i] = this.cartes[i];
        }
        new_tab_cartes[this.cartes.length] = new_carte;

        this.cartes = new_tab_cartes;
    }

    public Carte retirerCarte(int place) {
        // Vérifier si la position est valide
        if ((place < 0) && (place >= this.cartes.length)) {
            // Gérer l'erreur ou renvoyer null, selon les besoins
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


    public String toString() {
        String retour = "---------------------------------\n";

        if (this.cartes.length == 0) retour += "Aucune carte.\n";
                else {
                    for (int i = 0; i < this.cartes.length; i++){
                        retour += i + ". carte("+ this.cartes[i].getValeur()+ ")\n";
                    }
                }

        retour += "---------------------------------";

        return retour;
    }
}