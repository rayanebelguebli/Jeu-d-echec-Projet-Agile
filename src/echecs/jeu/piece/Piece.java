package jeu.piece;
import jeu.Plateau;
import jeu.Coordonnee;
import java.util.ArrayList;

public abstract class Piece {

    private String famille;
    
    protected Plateau plateau;
    
    protected String couleur;

    protected String unicode;
    
    protected int x,y;


    public Piece(int x, int y, String famille, String couleur, Plateau plateau){
    	this.x = y;
    	this.y = x;
    	this.famille = famille;
    	this.couleur = couleur;
        this.unicode = findUnicode(famille, couleur);
    	this.plateau = plateau;
        try{
            plateau.set(this);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public String findUnicode(String famille, String couleur){
        String code = "";
        if(famille.equals("CAVALIER")){
            if(couleur.equals("BLANC")){
                code = "\u2658";
            }
            else{
                code = "\u265E";
            }
        }
        if(famille.equals("FOU")){
            if(couleur.equals("BLANC")){
                code = "\u2657";
            }
            else{
                code = "\u265D";
            }
        }
        if(famille.equals("PION")){
            if(couleur.equals("BLANC")){
                code = "\u2657";
            }
            else{
                code = "\u265F";
            }
        }
        if(famille.equals("REINE")){
            if(couleur.equals("BLANC")){
                code = "\u2655";
            }
            else{
                code = "\u265B";
            }
        }
        if(famille.equals("ROI")){
            if(couleur.equals("BLANC")){
                code = "\u2654";
            }
            else{
                code = "\u265A";
            }
        }
        if(famille.equals("TOUR")){
            if(couleur.equals("BLANC")){
                code = "\u2656";
            }
            else{
                code = "\u265C";
            }
        }
    
        return code;
    }

    public String getFamille(){
        return famille;
    }

    public String getCouleur(){
    	return couleur;
    }

    public String getUnicode(){
        return  unicode;
    }

    public int getX(){
    	return this.x;
    }

    public int getY(){
    	return this.y;
    }
    
    public void setX(int x){
    	this.x = x;
    }
    
    public void setY(int y){
    	this.y = y;
    }
    
    public void setXY(int x, int y){
    	this.x = x;
    	this.y = y;
    }

    public abstract ArrayList<Coordonnee> casesPossibles();
    

    public boolean coupPossible(int x, int y){
        return false;
    }

    public boolean mouvementPossible(int x, int y){
       return true;
    }
    
    @Override
    public String toString(){
    	return unicode;
    }

    public void ClearDoublon (ArrayList<Coordonnee> c){
        Coordonnee doublon = c.get(0);
        for(int i = 1; i<c.size(); i++){
            if(doublon.equals(c.get(i))){
                c.remove(i);
            }
        }
    }
}