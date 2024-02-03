public enum ValeursPieces { PION(1),CAVALIER(3),TOUR(5),DAME(9),ROI(100),FOU(3);

    private int valeur;

    private ValeursPieces(int valeur){
        this.valeur = valeur;
    }
    
    public int getValeur(){return this.valeur;}
    // ValeursPieces.PION.getValeur
}
