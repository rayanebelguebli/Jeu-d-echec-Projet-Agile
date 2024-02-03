package jeu;

import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jeu.piece.*;

public class Player {
    private String name;
    private Plateau board;
    private ArrayList<Piece> pieces;
    private Couleur color;
    private int life;

    public Player(Couleur color, String name, Plateau board){
        this.color = color;
        this.name = name;
        this.board = board;
        this.life = 3;
        this.pieces = new ArrayList<>();
        if(color == Couleur.BLANC) createWhitePieces();
        else createBlackPieces();
        
    }

    
    public Plateau getBoard() {
        return board;
    }


    public int getLife() {
        return life;
    }

    

    public void setLife(int life) {
        this.life = life;
    }


    private void createWhitePieces(){
        Roi roi = new Roi(4, 7, color.toString(), board);
        Tour t1 = new Tour(0, 7, this.color.toString(), board);
        Tour t2 = new Tour(7, 7, this.color.toString(), board);
        Cavalier c1 = new Cavalier(1, 7, color.toString(), board);
        Cavalier c2 = new Cavalier(6, 7, color.toString(), board);
        Fou f1 = new Fou(2, 7, color.toString(), board);
        Fou f2 = new Fou(5, 7, color.toString(), board);
        Reine reine = new Reine(3, 7, color.toString(), board);
        for(int i = 0; i < 8; i++){
            Pion p = new Pion(i, 6, color.toString(), board);
        }
        try{
            pieces = board.getPieces(Couleur.BLANC);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void createBlackPieces(){
        Roi roi = new Roi(4, 0, color.toString(), board);
        Tour t1 = new Tour(0, 0, this.color.toString(), board);
        Tour t2 = new Tour(7, 0, this.color.toString(), board);
        Cavalier c1 = new Cavalier(1, 0, color.toString(), board);
        Cavalier c2 = new Cavalier(6, 0, color.toString(), board);
        Fou f1 = new Fou(2, 0, color.toString(), board);
        Fou f2 = new Fou(5, 0, color.toString(), board);
        Reine reine = new Reine(3, 0, color.toString(), board);
        for(int i = 0; i < 8; i++){
            Pion p = new Pion(i, 1, color.toString(), board);
        }
        try{
            pieces = board.getPieces(Couleur.NOIR);
        }catch(Exception e){
            e.printStackTrace();
        }
    }



    public void removePiece(String coord) throws Exception{
        int x = coord.charAt(0) - 'A';
        int y = coord.charAt(1) - '0';
        for(Piece p : pieces){
            if(p.getX() == x && p.getY() == y){
                pieces.remove(p);
                board.free(coord);
                break;
            }
        }

    }

    public List<Piece> getPieces(){
        return pieces;
    }

    public String getName() {
        return name;
    }

    public Couleur getColor() {
        return color;
    }


    public Roi getRoi(){
        Roi r = null;
        try {
            for(int i = 0; i<this.board.getPiece().size(); i++){
               if(this.board.getPiece().get(i).getFamille().equals("ROI")){
                r = (Roi) this.board.getPiece().get(i);
               } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}
