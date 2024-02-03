package test.echecs.jeu.piece;
import jeu.piece.*;
import jeu.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PieceTest {
    
    static Piece p1;
    static Piece p2;
    Piece p3;
    Piece p4;
    Piece p5;
    Piece p6;
    static Plateau plateau = new Plateau();

    @BeforeEach
    public void testInitialization(){
        p1 = new Reine(4, 1, "BLANC", plateau);
        p2 = new Reine(7, 3, "BLANC", plateau);
        p3 = new Roi(1, 1, "NOIR", plateau);
        p4 = new Reine(3, 1, "BLANC", plateau);
        p5 = new Reine(2, 2, "BLANC", plateau);
    }

    @Test
    public void testGetFamille(){
        assertEquals(p1.getFamille(), "TOUR");
        assertEquals(p2.getFamille(), "CAVALIER");
        assertEquals(p3.getFamille(), "ROI");
        assertEquals(p4.getFamille(), "REINE");
    }

    @Test
    public void testGetCouleur(){
        assertEquals(p1.getCouleur(), "NOIR");
        assertEquals(p2.getCouleur(), "BLANC");
        assertEquals(p3.getCouleur(), "NOIR");
        assertEquals(p4.getCouleur(), "BLANC");
    }

    @Test
    public void testGetUnicode(){
        assertEquals(p1.getUnicode(), "\u265C");
        assertEquals(p2.getUnicode(), "\u2657");
        assertEquals(p3.getUnicode(), "\u265A");
        assertEquals(p4.getUnicode(), "\u2655");
        assertEquals(p5.getUnicode(), "\u2658");
    }

    @Test
    public void testCoupPossible(){
        assertTrue(p1.coupPossible(4,3));
        assertTrue(p2.coupPossible(6,4));
        assertTrue(p3.coupPossible(1,2));
        assertTrue(p4.coupPossible(2,2));
        assertTrue(p5.coupPossible(3,4));
        assertFalse(p1.coupPossible(7,5));
        assertFalse(p2.coupPossible(6,3));
        assertFalse(p3.coupPossible(1,3));
        assertFalse(p4.coupPossible(0,0));
        assertFalse(p5.coupPossible(4,4));
    }

    
    public static void main(String args[]){
        Piece p11 = new Tour(1, 1, "BLANC", plateau);
        Piece p13 = new Tour (0, 0, "BLANC", plateau);
        Piece p12 = new Pion(5, 5, "NOIR", plateau);
        ArrayList<Coordonnee> coordo = p12.casesPossibles();
        ClearDoublon(coordo);
        Affichage affichage = new Affichage<>(plateau.tableauString());
        affichage.print();

        for (int i = 0 ; i<coordo.size(); i++){
            System.out.println(coordo.get(i).withLetter());
        }
        //System.out.println(((Roi) p12).estEchec());
        //System.out.println(((Roi) p12).estEchecEtMat());
    }
}
