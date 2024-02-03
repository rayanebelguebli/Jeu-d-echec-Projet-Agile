package jeu;
import jeu.*;
import jeu.piece.Roi;

public class EndGame {
    
    public String malus(Player p){
        return p.getPieces().get(0).toString(); 
    }
}
