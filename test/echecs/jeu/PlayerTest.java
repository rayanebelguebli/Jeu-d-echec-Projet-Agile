package test.echecs.jeu;
import jeu.piece.*;
import jeu.*;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    Plateau board = new Plateau();
    Player white, black;

    ArrayList<Piece> listPieces = new ArrayList<>();

    Tour t1 = new Tour(0, 7, "BLANC", board);
    Tour t2 = new Tour(7, 7, "BLANC", board);
    Cavalier c1 = new Cavalier(1, 7, "BLANC", board);
    Cavalier c2 = new Cavalier(6, 7, "BLANC", board);
    Fou f1 = new Fou(2, 7, "BLANC", board);
    Fou f2 = new Fou(5, 7, "BLANC", board);
    Reine reine = new Reine(3, 7, "BLANC", board);
    Roi roi = new Roi(4, 7, "BLANC", board);


    @BeforeEach
    public void testInitialization() throws Exception{

        for(int i = 0; i < 8; i++){
            Pion p = new Pion(i, 7, "BLANC", board);
            listPieces.add(p);
        }

        List<Piece> temp = Arrays.asList(t1, t2, c1, c2, f1, f2, reine, roi);
        listPieces.addAll(temp);

        white = new Player(Couleur.BLANC, "Nom1", board);
        black = new Player(Couleur.NOIR, "Nom2", board);

        
        board.set(white.getPieces().get(14),"A2");
        board.set(white.getPieces().get(15),"E6");



    }

    @Test
    public void testGetters(){
        assertEquals(white.getName(), "Nom1");
        assertEquals(black.getName(), "Nom2");
        assertEquals(white.getColor(), Couleur.BLANC);
        assertEquals(black.getColor(), Couleur.NOIR);

        assertEquals(white.getPieces().get(0).getCouleur(), listPieces.get(0).getCouleur());
        assertEquals(white.getPieces().get(8).getFamille(), listPieces.get(8).getFamille());
        assertEquals(white.getPieces().get(5).getUnicode(), listPieces.get(5).getUnicode());
        assertEquals(white.getPieces().get(15).getFamille(), "ROI");
    }

    @Test
    public void testRemovePiece() throws Exception{
        assertEquals(board.get("A2"), white.getPieces().get(14));
        assertEquals(board.get("E6"), white.getPieces().get(15));
        assertEquals(white.getPieces().size(), 16);

        white.removePiece("A2");
        white.removePiece("E6");

        assertEquals(board.get("A2"), null);
        assertEquals(board.get("E6"), null);
        assertEquals(white.getPieces().size(), 14);

        for(Piece p: white.getPieces()){
            assertNotEquals(p.getFamille(), "ROI");
            assertNotEquals(p.getFamille(), "REINE");
        }
    }
}
