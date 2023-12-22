public class Carte{

    private int valeur; //valeur de la carte

    /**
     * un constructeur avec un param`etre de type int qui construit une carte dont
        l'attribut valeur correspond au param`etre passé
     * @param v
     */
    public Carte(int v){
        this.valeur = v;
    }
    
    /**
     * retourne la valeur de la carte
     * @return
     */
    public int getValeur(){
        return this.valeur;
    }


    /**
     * une méthode toString() qui retourne une chaine contenant la valeur de la carte
        precedee de la lettre 'c' comme c27 ;
     *  @return
     */
    public String toString(){
        return "c" + this.valeur;
    }


    /**
     * prend en param`etre une autre carte et retourne
        true si et seulement si la carte this est plus grande que la carte passée en paramètre
     * @param autreCarte
     * @return
     */
    public boolean etrePlusGrand(Carte autreCarte){
        if (this.valeur > autreCarte.valeur){
            return true;
        }
        return false;
    }

    /**
     * prend une autre carte en param`etre et qui retourne true si et seulement si la carte this a une différence d'exactement 10
        (dans un sens ou dans l'autre) avec la carte passée en param`etre.
     * @param autreCarte
     * @return
     */
    public boolean avoirDiffDe10(Carte autreCarte){
        if ((this.valeur - autreCarte.valeur == 10) || (autreCarte.valeur - this.valeur == 10)){
            return true;
        }
        return false;
    }

}