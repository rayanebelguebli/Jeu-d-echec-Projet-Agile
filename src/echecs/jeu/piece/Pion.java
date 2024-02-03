package jeu.piece;
import jeu.Plateau;
import jeu.Coordonnee;
import java.util.ArrayList;

public class Pion extends Piece{
    
    private boolean premierCoup = true;

    public Pion(int y, int x, String couleur, Plateau plateau){
    	super(y, x, "PION", couleur, plateau);
    }

    public boolean coupPossible(int y, int x){
    	if(x < 0 || x > 7 || y < 0 || y > 7) return false;
  
    	try {
			if(this.plateau.getCase(x, y) != null){
				if(this.couleur.equals("NOIR")){
					if(x == this.x+1 && y == this.y+1){
						return true;
					}
					if(x == this.x-1 && y == this.y +1){
						return true;
					}
				}
				else{
					if(x == this.x-1 && y == this.y -1){
						return true;
					}
					if(x == this.x+1 && y == this.y-1){
						return true;
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	try {
			if(this.plateau.getCase(x, y) == null){
				if(this.couleur.equals("NOIR")){
			        if(x==this.x && y == this.y+2 && premierCoup==true){
			            return true;

			        }
					if(x==this.x && y ==this.y+1){
						return true;
					}
				}
				else{
			        if(x==this.x && y == this.y-2 && premierCoup==true){
			            return true;
			        }
					if(x==this.x && y==this.y-1){
						return true;
					}
				}
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return false;
    }
    
    public boolean mouvementPossible(int y, int x){
        return true;
    }

    public ArrayList<Coordonnee> casesPossibles(){
    	ArrayList<Coordonnee> coords = new ArrayList<Coordonnee>();	
    			if(this.couleur.equals("NOIR")){
    				try {
						if(((x+1) >= 0 && (y+1) >= 0 && (x+1) < 8 && (y+1) < 8) && (this.plateau.getCase(x+1,y+1) != null) && this.plateau.getCase(x+1,y+1).couleur.equals("BLANC")){
							coords.add(new Coordonnee(x+1,y+1));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
    				try {
						if(((x+1) >= 0 && (y-1) >= 0 && (x+1) < 8 && (y-1) < 8) && (this.plateau.getCase(x+1, y-1) != null) && this.plateau.getCase(x+1,y-1).couleur.equals("BLANC")){
							coords.add(new Coordonnee(x+1,y-1));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
    				try {
						if(x <= 5 && premierCoup && plateau.getCase(x+1, y) == null && plateau.getCase(x+2, y) == null){
							coords.add(new Coordonnee(x+1,y));
							coords.add(new Coordonnee(x+2,y));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
    				try {
						if(x < 7 && plateau.getCase(x+1, y) == null){
							coords.add(new Coordonnee(x+1,y));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
    			}
    			else{
    				try {
						if(((x-1) >= 0 && (y+1) >= 0 && (x-1) < 8 && (y+1) < 8) && (this.plateau.getCase(x-1,y+1) != null) && this.plateau.getCase(x-1,y+1).couleur.equals("NOIR")){
							coords.add(new Coordonnee(x-1,y+1));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
    				try {
						if(((x-1) >= 0 && (y-1) >= 0 && (x-1) < 8 && (y-1) < 8) && (this.plateau.getCase(x-1,y-1) != null) && this.plateau.getCase(x-1, y-1).couleur.equals("NOIR")){
							coords.add(new Coordonnee(x-1,y-1));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
    				try {
						if(x >= 2 && premierCoup && plateau.getCase(x-1, y) == null && plateau.getCase(x-2, y) == null){
							coords.add(new Coordonnee(x-1,y));
							coords.add(new Coordonnee(x-2,y));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
    				try {
						if(x > 0 && plateau.getCase(x-1, y) == null){
							coords.add(new Coordonnee(x-1,y));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
    			}
    	return coords;
    }
    
    public boolean isPremierCoup(){
    	return this.premierCoup;
    }
    
    public void setPremierCoup(boolean b){
    	this.premierCoup = b;
    }	
}
