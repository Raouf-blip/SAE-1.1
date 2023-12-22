public class Joueur {

    private String pseudo;

    private int score;

    /**
     * Crée un joueur
     *
     * @param n Pseudo
     * @param s Score
     */
    public Joueur (String n, int s) {
        this.pseudo = n;
        this.score = s;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
