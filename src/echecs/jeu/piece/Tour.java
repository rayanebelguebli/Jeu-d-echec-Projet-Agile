package jeu.piece;
import jeu.Plateau;
import jeu.Coordonnee;
import java.util.ArrayList;

public class Tour extends Piece{

    private boolean premierCoup;
	private boolean startGauche;
	

    public Tour(int x, int y, String couleur, Plateau plateau){
    	super(x, y, "TOUR", couleur, plateau);
    	this.premierCoup = true;
    	if(x == 0){
    		this.startGauche = true;
    	}else{
    		this.startGauche = false;
    	}
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
    	return false;
    }

    public boolean mouvementPossible(int x, int y){

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
	    return false;
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
    	return possible;
    }
    
	public boolean getPremierCoup(){
		return premierCoup;
	}

	public void setPremierCoup(boolean premierCoup){
		this.premierCoup = premierCoup;
	}
	
	public boolean isStartGauche(){
		return this.startGauche;
	}
}
