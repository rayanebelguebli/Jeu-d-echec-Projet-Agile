package jeu.piece;
import jeu.Plateau;
import jeu.Coordonnee;
import java.util.ArrayList;

public class Roi extends Piece {
    private boolean premierCoup;
	

    public Roi(int x, int y, String couleur, Plateau plateau){
    	super(x, y, "ROI", couleur, plateau);
    	this.premierCoup = true;
    }
    

    public boolean coupPossible(int x, int y){

        if(x==this.x+1 && y==this.y || x==this.x-1 && y==this.y){
    		return true;

        }else if(x==this.x && y==this.y+1 || x==this.x && y==this.y-1){
    		return true;

        }else if(x==this.x+1 && y==this.y+1 || x==this.x+1 && y==this.y-1 || x==this.x-1 && y==this.y-1 || x==this.x-1 && y==this.y+1){
    		return true;
        }
    return false;
    }

    public boolean mouvementPossible(int x, int y){
      if(x==(this.x+2) && premierCoup){
        Piece p1 = null;
		try {
			p1 = (this.couleur.equals("BLANC"))? plateau.getCase(5,0) : plateau.getCase(5,7);
		} catch (Exception e) {
			e.printStackTrace();
		}
        Piece p2 = null;
		try {
			p2 = (this.couleur.equals("BLANC"))? plateau.getCase(6,0) : plateau.getCase(6,7);
		} catch (Exception e) {
			e.printStackTrace();
		}
        if(p1 != null || p2 != null){
          return false;
        }
      }
      else if(x==(this.x-2) && premierCoup) {
        Piece p1 = null;
		try {
			p1 = (this.couleur.equals("BLANC"))? plateau.getCase(1,0) : plateau.getCase(1,7);
		} catch (Exception e) {
			e.printStackTrace();
		}
        Piece p2 = null;
		try {
			p2 = (this.couleur.equals("BLANC"))? plateau.getCase(2,0) : plateau.getCase(2,7);
		} catch (Exception e) {
			e.printStackTrace();
		}
        Piece p3 = null;
		try {
			p3 = (this.couleur.equals("BLANC"))? plateau.getCase(3,0) : plateau.getCase(3,7);
		} catch (Exception e) {
			e.printStackTrace();
		}
        if(p1 != null || p2 != null || p3 != null){
          return false;
        }
      }
     return true;
    }

    public ArrayList<Coordonnee> casesPossibles(){
        	ArrayList<Coordonnee> possible = new ArrayList<Coordonnee>();
        	try {
				if(((x) >= 0 && (y+1) >= 0 && (x) < 8 && (y+1) < 8) && (this.plateau.getCase(x,y+1) == null || !this.plateau.getCase(x,y+1).couleur.equals(this.couleur))){
					possible.add(new Coordonnee(x,y+1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        	try {
				if(((x) >= 0 && (y-1) >= 0 && (x) < 8 && (y-1) < 8) && (this.plateau.getCase(x,y-1) == null || !this.plateau.getCase(x,y-1).couleur.equals(this.couleur))){
					possible.add(new Coordonnee(x,y-1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        	try {
				if(((x+1) >= 0 && (y) >= 0 && (x+1) < 8 && (y) < 8) && (this.plateau.getCase(x+1,y) == null || !this.plateau.getCase(x+1,y).couleur.equals(this.couleur))){
					possible.add(new Coordonnee(x+1,y));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        	try {
				if(((x-1) >= 0 && (y) >= 0 && (x-1) < 8 && (y) < 8) && (this.plateau.getCase(x-1,y) == null || !this.plateau.getCase(x-1,y).couleur.equals(this.couleur))){
					possible.add(new Coordonnee(x-1,y));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        	try {
				if(((x+1) >= 0 && (y+1) >= 0 && (x+1) < 8 && (y+1) < 8) && (this.plateau.getCase(x+1,y+1) == null || !this.plateau.getCase(x+1,y+1).couleur.equals(this.couleur))){
					possible.add(new Coordonnee(x+1,y+1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        	try {
				if(((x-1) >= 0 && (y+1) >= 0 && (x-1) < 8 && (y+1) < 8) && (this.plateau.getCase(x-1,y+1) == null || !this.plateau.getCase(x-1,y+1).couleur.equals(this.couleur))){
					possible.add(new Coordonnee(x-1,y+1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        	try {
				if(((x+1) >= 0 && (y-1) >= 0 && (x+1) < 8 && (y-1) < 8) && (this.plateau.getCase(x+1,y-1) == null || !this.plateau.getCase(x+1,y-1).couleur.equals(this.couleur))){
					possible.add(new Coordonnee(x+1,y-1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        	try {
				if(((x-1) >= 0 && (y-1) >= 0 && (x-1) < 8 && (y-1) < 8) && (this.plateau.getCase(x-1,y-1) == null || !this.plateau.getCase(x-1,y-1).couleur.equals(this.couleur))){
					possible.add(new Coordonnee(x-1,y-1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        	try {
				if(premierCoup && this.plateau.getCase(x+1, y) == null && this.plateau.getCase(x+2, y) == null && this.plateau.getCase(x+3, y) != null && this.plateau.getCase(x+3, y).getClass().equals(Tour.class)){
					Tour t = (Tour)plateau.getCase(x+3, y);
					if(t.getPremierCoup()){
						possible.add(new Coordonnee(x+2,y));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        	try {
				if(premierCoup && this.plateau.getCase(x-1, y) == null && this.plateau.getCase(x-2,y) == null && this.plateau.getCase(x-3,y) == null && plateau.getCase(x-4, y) != null && plateau.getCase(x-4, y).getClass().equals(Tour.class)){
					Tour t = (Tour)plateau.getCase(x-4, y);
					if(t.getPremierCoup()){
						possible.add(new Coordonnee(x-2,y));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        	return possible;
    }
        
    public boolean getPremierCoup(){
    	return premierCoup;
    }
        
    public void setPremierCoup(boolean b){
    	this.premierCoup = b;
    }

	public boolean estEchec(){
		ArrayList<Piece> echec = new ArrayList<Piece>();
		try {
			echec = plateau.getPieceForEchec();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(Piece p : echec){
			if(p.coupPossible(this.x, this.y) && p.mouvementPossible(this.x,  this.y)){
				if(this.getCouleur().equals("BLANC") && p.getCouleur().equals("NOIR")){
					return true;
				}
				if(this.getCouleur().equals("NOIR") && p.getCouleur().equals("BLANC")){
					return true;
				}
			}

		}
		return false;

	}
}
