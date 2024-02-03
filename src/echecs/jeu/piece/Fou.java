package jeu.piece;
import jeu.Plateau;
import jeu.Coordonnee;
import java.util.ArrayList;

public class Fou extends Piece {
    public Fou(int x, int y, String couleur, Plateau plateau){
    	super(x, y, "FOU", couleur, plateau);
    	
    }
    
    public boolean coupPossible(int x, int y){
    	for(int i=0; i<= 8; i++){
    		if(this.x+i==x && this.y+i==y)
    			return true;
    		if(this.x-i==x && this.y-i==y)
    			return true;
    		if(this.x+i==x && this.y-i==y)
    			return true;
    		if(this.x-i==x && this.y+i==y)
    			return true; 		
    	}
    		return false;
    }

	public boolean mouvementPossible(int x,int y){
    	if(x>this.x && y>this.y){
    		while(this.x != x-1 && this.y != y-1){
    			
    			if(!plateau.estVide(x-1, y-1)){
    				return false;
    			}
    			x--;
    			y--;
    		}
    		return true;
    	}

    	if(x<this.x && y>this.y){
    		while(this.x != x+1 && this.y != y-1){
    			
    			if(!plateau.estVide(x+1, y-1)){
    				return false;
    			}
    			x++;
    			y--;
    		}
    		return true;
    	}
    	if(x>this.x && y<this.y){
    		while(this.x != x-1 && this.y != y+1){
    			
    			if(!plateau.estVide(x-1, y+1)){
    				return false;
    			}
    			x--;
    			y++;
    		}
    		return true;
    	}
    	if(x<this.x && y<this.y){
    		while(this.x != x+1 && this.y != y+1){
    			
    			if(!plateau.estVide(x+1, y+1)){
    				return false;
    			}
    			x++;
    			y++;
    		}
    		return true;
    	}
        return false;
    }
    

    public ArrayList<Coordonnee> casesPossibles(){
    	int x = this.x+1;
    	int y = this.y+1;
    	ArrayList<Coordonnee> possible = new ArrayList<Coordonnee>();
    	try {
			while(x<8 && x>=0 && y>=0&& y<8 && mouvementPossible(x,y) && (plateau.getCase(x, y) == null || plateau.getCase(x, y).getCouleur() != this.getCouleur())){
				possible.add(new Coordonnee(x,y));
				x++;
				y++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	x = this.x-1;
    	y = this.y-1;
    	try {
			while(x<8 && x>=0 && y>=0&& y<8 && mouvementPossible(x,y)&& (plateau.getCase(x, y) == null || plateau.getCase(x, y).getCouleur() != this.getCouleur())){
				possible.add(new Coordonnee(x,y));
				x--;
				y--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	x = this.x-1;
    	y = this.y+1;
    	try {
			while(x<8 && x>=0 && y>=0&& y<8 && mouvementPossible(x,y)&& (plateau.getCase(x, y) == null || plateau.getCase(x, y).getCouleur() != this.getCouleur())){
				possible.add(new Coordonnee(x,y));
				x--;
				y++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	x = this.x+1;
    	y = this.y-1;
    	try {
			while(x<8 && x>=0 && y>=0&& y<8 && mouvementPossible(x,y)&& (plateau.getCase(x, y) == null || plateau.getCase(x, y).getCouleur() != this.getCouleur())){
				possible.add(new Coordonnee(x,y));
				x++;
				y--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return possible;
    }
}
