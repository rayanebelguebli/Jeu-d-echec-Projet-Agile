package jeu.piece;
import jeu.*; 
import java.util.ArrayList;

public class Reine extends Piece {
    
    public Reine(int x, int y, String couleur, Plateau plateau){
    	super(x, y, "REINE", couleur, plateau);
    }

    
    
    public boolean coupPossible(int x, int y){
    	for(int i = 0;i <=8;i++){
    		if(i==x && y==this.y){
    			return true;
    		}
    		if(i==y && x==this.x){
    			return true;
    		}
    	}
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

	public boolean mouvementPossible(int x, int y){
        if(this.x != x && this.y != y){       

        	
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
        }
        if(this.x != x && this.y ==y){
        	if(this.x > x){ 
        		for(int i=this.x-1;i>x;i--){

        			if(!plateau.estVide(i, y)){
        				return false;
        			}
        		}
        		return true;
        	}
        	if(this.x < x){ 
        		for(int i=this.x+1;i<x;i++){

        			if(!plateau.estVide(i, y)){
        				return false;
        			}
        		}
        		return true;
        	}
        }
        if(this.y != y && this.x == x){
        	if(this.y > y){ 
        		for(int i=this.y-1;i>y;i--){

        			if(!plateau.estVide(x, i)){
        				return false;
        			}
        		}
        		return true;
        	}
        	if(this.y < y){ 
        		for(int i=this.y+1;i<y;i++){

        			if(!plateau.estVide(x, i)){
        				return false;
        			}
        		}
        	return true;
        }
        }
        return true;
    }
    
    public ArrayList<Coordonnee> casesPossibles(){
    	int x = this.x+1;
    	int y = this.y;
    	ArrayList<Coordonnee> possible = new ArrayList<Coordonnee>();
    	try {
			while(x<8 && x>=0 && y>=0&& y<8 && mouvementPossible(x,y) && (plateau.getCase(x, y) == null || plateau.getCase(x, y).getCouleur() != this.getCouleur())){
				possible.add(new Coordonnee(x,y));
				x++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	x = this.x-1;
    	
    	try {
			while(x<8 && x>=0 && y>=0&& y<8 && mouvementPossible(x,y)&& (plateau.getCase(x, y) == null || plateau.getCase(x, y).getCouleur() != this.getCouleur())){
				possible.add(new Coordonnee(x,y));
				x--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	x = this.x;
    	y = this.y+1;
    	try {
			while(x<8 && x>=0 && y>=0&& y<8 && mouvementPossible(x,y)&& (plateau.getCase(x, y) == null || plateau.getCase(x, y).getCouleur() != this.getCouleur())){
				possible.add(new Coordonnee(x,y));
				y++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	x = this.x;
    	y = this.y-1;
    	try {
			while(x<8 && x>=0 && y>=0&& y<8 && mouvementPossible(x,y)&& (plateau.getCase(x, y) == null || plateau.getCase(x, y).getCouleur() != this.getCouleur())){
				possible.add(new Coordonnee(x,y));
				y--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	x = this.x+1;
    	y = this.y+1;
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
