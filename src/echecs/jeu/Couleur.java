package jeu;


public enum Couleur {BLANC(1), NOIR(2);
    private int number;

    private Couleur(int i){
        this.number = i;
    }
    
    public int getNumber(){
        return number;
    }
}
