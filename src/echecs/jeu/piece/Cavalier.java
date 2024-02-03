package jeu.piece;
import jeu.Plateau;
import jeu.Coordonnee;
import java.util.ArrayList;

public class Cavalier extends Piece {


    public Cavalier(int x, int y, String couleur, Plateau plateau){
		super(x, y, "CAVALIER", couleur, plateau);
    }
    
	
    public boolean coupPossible(int x, int y){
    	if(x==this.x-2 && y==this.y-1){
    		return true;
    	}
    	if(x==this.x-1 && y==this.y-2){
    		return true;
    	}
    
    	if(x==this.x+1 && y==this.y-2){
    		return true;
    	}
    	if(x==this.x+2 && y==this.y-1){
    		return true;
    	} 
    
    	if(x==this.x+2 && y==this.y+1){
    		return true;
    	}
    	if(x==this.x+1 && y==this.y+2){
    		return true;
    	} 
    	
    	if(x==this.x-1 && y==this.y+2){
    		return true;
    	}
    	if(x==this.x-2 && y==this.y+1){
    		return true;
    	} 
    	
    	return false;
    	
    }

	public boolean mouvementPossible(int x, int y){
        return true;
    }

	public ArrayList<Coordonnee> casesPossibles(){
    ArrayList<Coordonnee> coords = new ArrayList<Coordonnee>();
    	if(this.couleur.equals("BLANC")){
    		try {
				if(((x-2) >= 0 && (y-1) >= 0 && (x-2) < 8 && (y-1) < 8) && ((this.plateau.getCase(x-2,y-1) == null) || this.plateau.getCase(x-2,y-1).couleur.equals("NOIR"))){
					coords.add(new Coordonnee(x-2,y-1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try {
				if(((x-1) >= 0 && (y-2) >= 0 && (x-1) < 8 && (y-2) < 8) && ((this.plateau.getCase(x-1,y-2) == null) || this.plateau.getCase(x-1,y-2).couleur.equals("NOIR"))){
					coords.add(new Coordonnee(x-1,y-2));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try {
				if(((x+1) >= 0 && (y-2) >= 0 && (x+1) < 8 && (y-2) < 8) && ((this.plateau.getCase(x+1,y-2) == null) || this.plateau.getCase(x+1, y-2).couleur.equals("NOIR"))){
					coords.add(new Coordonnee(x+1,y-2));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try {
				if(((x+2) >= 0 && (y-1) >= 0 && (x+2) < 8 && (y-1) < 8) && ((this.plateau.getCase(x+2,y-1) == null) || this.plateau.getCase(x+2,y-1).couleur.equals("NOIR"))){
					coords.add(new Coordonnee(x+2,y-1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try {
				if(((x+2) >= 0 && (y+1) >= 0 && (x+2) < 8 && (y+1) < 8) && ((this.plateau.getCase(x+2,y+1) == null) || this.plateau.getCase(x+2,y+1).couleur.equals("NOIR"))){
					coords.add(new Coordonnee(x+2,y+1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try {
				if(((x+1) >= 0 && (y+2) >= 0 && (x+1) < 8 && (y+2) < 8) && ((this.plateau.getCase(x+1,y+2) == null) || this.plateau.getCase(x+1, y+2).couleur.equals("NOIR"))){
					coords.add(new Coordonnee(x+1,y+2));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try {
				if(((x-1) >= 0 && (y+2) >= 0 && (x-1) < 8 && (y+2) < 8) && ((this.plateau.getCase(x-1,y+2) == null) || this.plateau.getCase(x-1, y+2).couleur.equals("NOIR"))){
					coords.add(new Coordonnee(x-1,y+2));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try {
				if(((x-2) >= 0 && (y+1) >= 0 && (x-2) < 8 && (y+1) < 8) && ((this.plateau.getCase(x-2,y+1) == null) || this.plateau.getCase(x-2,y+1).couleur.equals("NOIR"))){
					coords.add(new Coordonnee(x-2,y+1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	else{
    		try {
				if(((x-2) >= 0 && (y-1) >= 0 && (x-2) < 8 && (y-1) < 8) && ((this.plateau.getCase(x-2,y-1) == null) || this.plateau.getCase(x-2,y-1).couleur.equals("BLANC"))){
					coords.add(new Coordonnee(x-2,y-1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try {
				if(((x-1) >= 0 && (y-2) >= 0 && (x-1) < 8 && (y-2) < 8) && ((this.plateau.getCase(x-1,y-2) == null) || this.plateau.getCase(x-1,y-2).couleur.equals("BLANC"))){
					coords.add(new Coordonnee(x-1,y-2));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try {
				if(((x+1) >= 0 && (y-2) >= 0 && (x+1) < 8 && (y-2) < 8) && ((this.plateau.getCase(x+1,y-2) == null) || this.plateau.getCase(x+1, y-2).couleur.equals("BLANC"))){
					coords.add(new Coordonnee(x+1,y-2));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try {
				if(((x+2) >= 0 && (y-1) >= 0 && (x+2) < 8 && (y-1) < 8) && ((this.plateau.getCase(x+2,y-1) == null) || this.plateau.getCase(x+2,y-1).couleur.equals("BLANC"))){
					coords.add(new Coordonnee(x+2,y-1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try {
				if(((x+2) >= 0 && (y+1) >= 0 && (x+2) < 8 && (y+1) < 8) && ((this.plateau.getCase(x+2,y+1) == null) || this.plateau.getCase(x+2,y+1).couleur.equals("BLANC"))){
					coords.add(new Coordonnee(x+2,y+1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try {
				if(((x+1) >= 0 && (y+2) >= 0 && (x+1) < 8 && (y+2) < 8) && ((this.plateau.getCase(x+1,y+2) == null) || this.plateau.getCase(x+1, y+2).couleur.equals("BLANC"))){
					coords.add(new Coordonnee(x+1,y+2));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    		try {
				if(((x-1) >= 0 && (y+2) >= 0 && (x-1) < 8 && (y+2) < 8) && ((this.plateau.getCase(x-1,y+2) == null) || this.plateau.getCase(x-1, y+2).couleur.equals("BLANC"))){
					coords.add(new Coordonnee(x-1,y+2));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				if(((x-2) >= 0 && (y+1) >= 0 && (x-2) < 8 && (y+1) < 8) && ((this.plateau.getCase(x-2,y+1) == null) || this.plateau.getCase(x-2,y+1).couleur.equals("BLANC"))){
					coords.add(new Coordonnee(x-2,y+1));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    return coords;
    }

}
