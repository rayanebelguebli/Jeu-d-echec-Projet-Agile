package jeu;

public class Coordonnee {


    public int x;
    public int y;
        

    public Coordonnee(int x, int y){
        this.x = x;
        this.y = y;
    }
        

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public Coordonnee(){
        this(0,0);
    }
        

    public Coordonnee(int xy){
        this(xy, xy);
    }
        
    public String withLetter(){
        char letter = (char)((this.x)+'A');
        return "" + letter + "" +(this.y+1);
    }

    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "["+x+", "+y+"]";
    }
    
}