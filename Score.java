public class Score {

    private Joueur[] tab_score;

    private int max;

    public Score(int m) {
        this.max = m;

        this.tab_score = new Joueur[0];
    }

    /**
     * Permet d'ajouter un score au classement
     *
     * @param n Pseudo
     * @param s Score
     */
    public void ajouterScore(String n, int s) {
        Joueur[] new_tab_score = new Joueur[this.tab_score.length+1];

        if (this.tab_score.length == 0) {
            new_tab_score[0] = new Joueur(n, s); // premier joueur
        } else {
            int p = 0;

            while (p < this.tab_score.length && (s < this.tab_score[p].getScore()) ) {
                // Recherche de la bonne place (p)
                new_tab_score[p] = this.tab_score[p]; // recopie des cartes
                p++;
            }

            new_tab_score[p] = new Joueur(n, s); // insertion de la carte à la position p

            for (int i = p; i < this.tab_score.length; i++) {
                // recopie des cartes restantes
                new_tab_score[i+1] = this.tab_score[i];
            }
        }

        this.tab_score = new_tab_score;
    }

    /**
     * Donne les 5 meilleurs joueurs.
     *
     * @return classement
     */
    public String classementScore() {
        if (this.tab_score.length != 0) {
            String classement = "################################################\n";


            for (int i = 0; i < Math.min(this.tab_score.length, 5); i++) {
                classement += "TOP " + (i+1) + " : " + this.tab_score[i].getPseudo() + " avec " + this.tab_score[i].getScore() + " !\n";
            }

            classement += "################################################\n";

            return classement;
        }

        return "";
    }

    public int getMax() {
        return max;
    }
}
