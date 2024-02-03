package jeu;
import java.util.ArrayList;
import jeu.piece.Piece;

public class Plateau{
    private Piece[][] plateau;
    private final int X = 8;
    private final int Y = 8;

    public Plateau() {
        this.plateau = new Piece[X][Y];
    }

    public Piece get(String c) throws Exception{
        if(c.length() != 2 || c.charAt(0) < 'A' || c.charAt(0) > 'H' || c.charAt(1) < '1' || c.charAt(1) > '8'){
            throw new Exception("La case n'est pas valable");
        }else{
            return plateau[c.charAt(0) - 'A'][c.charAt(1)-'0'-1];
        }
    }

    public Piece getCase(int x, int y) throws Exception{
		return get(""+(char)(x+'A')+(char)(y+'1'));
	}

    public boolean estVide(String c) throws Exception{
        return get(c) == null;
    }

    public boolean estVide(int x, int y){
        return plateau[x][y] == null;
    }

    public String[][] tableauString(){
        String[][] res = new String[X][Y];
        for(int y=0;y<Y;y++){
            for(int x=0;x<X;x++){
                if(plateau[y][x] != null) res[y][x] = plateau[y][x].toString();
            }
        }
        return res;
    }

    public void set(Piece p, String c) throws Exception{
        if(c.length() != 2 || c.charAt(0) < 'A' || c.charAt(0) > 'H' || c.charAt(1) < '1' || c.charAt(1) > '8'){
            throw new Exception("La case n'est pas valable");
        }else if(p == null){
            throw new Exception("La piece est NULL"); 
        }else if(contains(p)){
            throw new Exception("La piece est déjà sur le plateau"); 
        }else if(plateau[c.charAt(0) - 'A'][c.charAt(1)-'0'-1] != null){
            throw new Exception("La case est déja prise");
        }else{
            plateau[c.charAt(0) - 'A'][c.charAt(1)-'0'-1] = p;
            p.setX(c.charAt(0) - 'A');
            p.setY(c.charAt(1) - '0'-1);
        }
    }

    public void set(Piece p) throws Exception{
        set(p, ""+(char)(p.getX()+'A')+(char)(p.getY()+'0'+1));
    }

    public Piece free(String c) throws Exception{
        if(c.length() != 2 || c.charAt(0) < 'A' || c.charAt(0) > 'H' || c.charAt(1) < '1' || c.charAt(1) > '8'){
            throw new Exception("La case n'est pas valable");
        }else{    /**
            * Ne fais rien, fonction surcharger par les class heritee
            * @param x
            * @param y
            * @return
            */
            if(plateau[c.charAt(0) - 'A'][c.charAt(1)-'0'-1] == null) return null;
            else{
                Piece res = plateau[c.charAt(0) - 'A'][c.charAt(1)-'0'-1];
                res.setX(-1);
                res.setY(-1);
                plateau[c.charAt(0) - 'A'][c.charAt(1)-'0'-1] = null;
                return res;
            }
        }
    }

    public boolean contains(Piece p){
        for(int y=0;y<Y;y++){
            for(int x=0;x<X;x++){
                if(plateau[y][x] == p) return true;
            }
        }
        return false;
    }

    public int getX(String c)throws Exception{
        return get(c).getX();
    }

    public int getY(String c)throws Exception{
        return get(c).getY();
    }

    public Piece replace(Piece newPiece, String pos) throws Exception{
        Piece res = free(pos);
        set(newPiece, pos);
        return res;
    }

    public Piece move(String from, String to) throws Exception{
        if(get(from) == null) throw new Exception("Case d'origine vide");
        else if(to.length() != 2 || to.charAt(0) < 'A' || to.charAt(0) > 'H' || to.charAt(1) < '1' || to.charAt(1) > '8'){
            throw new Exception("La case de fin n'est pas valable");
        }
        else if(!get(from).mouvementPossible(to.charAt(0)-'A',to.charAt(1)-'0'-1));
        else{
            return replace(free(from), to);
        }
        return null;
    }

    public Piece move(String from, Coordonnee c) throws Exception{
        return move(from, c.withLetter());
    }

    public ArrayList<Piece> getPieces(Couleur color) throws Exception{
    	ArrayList<Piece> p = new ArrayList<Piece>();
    	for(int i=0; i<plateau.length;i++){
    		for(int j=0; j<plateau.length;j++){
    			if(this.getCase(i, j) != null && this.getCase(i, j).getCouleur().equals(color.toString())){
    				p.add(this.getCase(i, j));
    			}
    		}
    	}
    	return p;
    }

    public ArrayList<Piece> getPiece() throws Exception{
        ArrayList<Piece> res = getPieces(Couleur.BLANC);
        getPieces(Couleur.BLANC).addAll(getPieces(Couleur.NOIR));
        return res;
    }

    public ArrayList<Piece> getPieceForEchec(){
    	ArrayList<Piece> p = new ArrayList<Piece>();
    	for(int i=0; i<plateau.length;i++){
    		for(int j=0; j<plateau.length;j++){
    			try {
                    if(this.getCase(i, j) != null){
                    	p.add(this.getCase(i, j));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
    		}
    	}
    	return p;
    }
}