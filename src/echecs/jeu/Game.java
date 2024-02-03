package jeu;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import jeu.piece.Piece;
import jeu.piece.Pion;

class Game{

    private Piece chosenPiece;
    private Affichage<String> affichage;
    private Plateau board;
    private Player white;
    private Player black;
    private Player currentPlayer;
    private Player otherPlayer;
    private Player winner = null;
    private boolean EndGame = false;

    public Game() throws Exception{
        this.currentPlayer = white;
        this.otherPlayer = black;
        this.board = new Plateau();
        this.white = new Player(Couleur.BLANC, askName("Joueur 1"), this.board);
        this.black = new Player(Couleur.NOIR, askName("Joueur 2"), this.board);
        this.affichage = new Affichage<String>(board.tableauString());
    }

    private String askName(String numJoueur){
        System.out.print("Nom du "+numJoueur+" : ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        try{
            name = reader.readLine();
        }catch(IOException e){
            return askName(numJoueur);
        }
        if(name == null || name.length() == 0){
            System.out.println("Veuillez saisir un nom valide");
            return askName(numJoueur);
        }
        return name;
    }


    public void play() throws Exception{
        System.out.println(EndGame);
        while(EndGame == false){
            Affichage.clearScreen();
            affichage.setTable(board.tableauString());
            affichage.print();
            nextRound();
            //updateScoreBoard();
            //checkwin();
        }
        System.out.println(winner.getName());
        
    }

    private void nextRound() throws Exception{
        if(currentPlayer == white){
            currentPlayer = black;
            otherPlayer = white;
            Affichage.clearScreen();
        }
        else{
            currentPlayer = white;
            otherPlayer = black;
            Affichage.clearScreen();
        }
        Piece p = tour(currentPlayer);
        board.tableauString();
    }

    public static void ClearDoublon (ArrayList<Coordonnee> c){
        Coordonnee doublon = c.get(0);
        for(int i = 1; i<c.size(); i++){
            if(doublon.toString().equals(c.get(i).toString())){
                c.remove(i);
            }
        }
    }

    private Piece tour(Player p) throws Exception{
        System.out.println(EndGame);
        Affichage.clearScreen();
        Piece res = null;
        affichage.setTable(board.tableauString());
        affichage.print();
        String coord = "";
        for(int cpt=0;cpt<15-(currentPlayer.getName().length()/2);cpt++){
            System.out.print(" ");
        }
        System.out.print("TOUR DE "+currentPlayer.getName()+" [Pièces "+currentPlayer.getColor().toString()+"]"+"\n" +"\t\tIl vous reste : " + p.getLife()+ " vies"+"\n\n\n");
        if(p.getRoi() != null && p.getLife() > 0){
            if(p.getRoi() != null && p.getRoi().estEchec()){
                System.out.println("\t\tVOTRE ROI EST EN ECHEC\n\n");
                p.setLife(p.getLife() - 1);
            }
        }
        else{
            EndGame = true;
            if(currentPlayer.getColor() == Couleur.BLANC) winner = black;
            else winner = white;
            Affichage.clearScreen();
            return null;
        }
        if (EndGame == false)    
        {
            System.out.print("Saisir les coordonées de la case : ");
            Scanner sc = new Scanner(System.in);
            coord = sc.nextLine().toUpperCase();
            try{
                if(board.get(coord) == null || !board.get(coord).getCouleur().equals(currentPlayer.getColor().toString()) || coord.length() != 2) return tour(p);
            }catch(Exception e){
                System.out.println(e.getMessage());
                TimeUnit.SECONDS.sleep(1);
                return tour(p);
            }
            ArrayList<Coordonnee> liste = board.get(coord).casesPossibles();
            ClearDoublon(liste);
            System.out.println("COUPS POSSIBLES :");
            System.out.println("\t0. RETOUR");
            for(int cpt=1;cpt<=liste.size();cpt++){
                System.out.println("\t"+cpt+". "+liste.get(cpt-1).withLetter());
            }
            System.out.println((board.getY(coord)));
            int choix = -1;
            while(choix<0 || choix > liste.size()){
                System.out.print("\nCHOIX = ");
                choix = sc.nextInt();
            }
            if(choix == 0){
                tour(p);
            }else{
                try{
                    res = board.move(coord, liste.get(choix-1));
                }catch(Exception e){
                    System.out.println(e.toString());
                    TimeUnit.SECONDS.sleep(2);
                    tour(p);
                }
                System.out.println("\t\tFIN DU TOUR !");
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Game g;
        try{
            g = new Game();
            System.out.print("\tMENU\n\n1. Jeu\n2. Multijoueur\n\nCHOIX = ");
            Scanner sc = new Scanner(System.in);
            int choix = sc.nextInt();
            if(choix == 1)g.play();
            if(choix == 2)g.multiplayerMenu();
            //else main(args);
            sc.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void multiplayerMenu() throws Exception{
        Affichage.clearScreen();
        System.out.print("\t\t\u25AE MULTIJOUEUR \u25AE\n\n\t\t1. Heberger\n\t\t2. Rejoindre\n\t\t0. Retour\n\n\n\tCHOIX = ");
        Scanner sc = new Scanner(System.in);
        int choix = -1;
        try{
            choix = sc.nextInt();
        }catch(Exception e){
            multiplayerMenu();
        }
        if(choix==0){
            return;
            //main(null);
        }else if(choix == 1){
            File f = Online.create(".host","0");
            Online.read(f.getAbsolutePath(), "1");
            Affichage.clearScreen();
            System.out.println("\t"+Online.toList(f.getAbsolutePath()).get(1).substring(14, Online.toList(f.getAbsolutePath()).get(1).length())+" A REJOINS LA PARTIE");
            TimeUnit.SECONDS.sleep(2);
            Affichage.clearScreen();
            multiplayerGame(f, 1);
            Online.remove(f);
        }else if (choix==2){
            int servChoix = -1;
            List<File> liste = new ArrayList<File>();
            while(servChoix<0|| servChoix>liste.size()){
                Affichage.clearScreen();
                System.out.println("\n\t\tJOUEURS EN LIGNE : \n\n");
                liste = Online.find(".host");
                for(int cpt=0;cpt<liste.size();cpt++){
                    System.out.println("\t"+(cpt+1)+". "+liste.get(cpt).getAbsolutePath());
                }
                System.out.print("\n\n\\t(0. Retour | 9. Rafraichissement)\n\tCHOIX = ");
                servChoix = sc.nextInt();
            }
            if(servChoix == 0) multiplayerMenu();
            else{
                Online.changeKey(liste.get(choix-2), "1");
                Online.writeOn(liste.get(choix-2), System.getProperty("user.home"));
                multiplayerGame(liste.get(choix-2), 2);
                Affichage.clearScreen();
                System.out.println("\t VOUS AVEZ REJOINS LA PARTIE");
                TimeUnit.SECONDS.sleep(2);
                Affichage.clearScreen();
            } 
        }else{
            multiplayerMenu();
        }
    }

    public void multiplayerGame(File hostFile, int playerNumber)throws Exception{
        Scanner sc;
        sc = new Scanner(hostFile);
        while(!sc.hasNextLine() || !sc.nextLine().equals(""+playerNumber)){
            Affichage.clearScreen();
            affichage.setTable(board.tableauString());
            affichage.print();
            System.out.print("Le joueur adverse est en train de jouer");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print(" .");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print(" .");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println(" .");
            sc.close();
            TimeUnit.MILLISECONDS.sleep(500);
            sc = new Scanner(hostFile);
        }
        List<String> list = new ArrayList<String>();
        while(sc.hasNextLine()) list.add(sc.nextLine());
        sc.close();
        Piece p = null;
        if(list.size()>2){
            p = board.move(list.get(1), list.get(2));
            System.out.println("\t\tL'adversaire à bougé "+list.get(1)+" en "+list.get(2));
        }
        if(p!= null)System.out.println("\t\tEt il à pris votre "+p.getFamille());
        multiplayerTour(hostFile,playerNumber);
        multiplayerGame(hostFile,playerNumber);
    }

    private Piece multiplayerTour(File hostFile, int playerNumber) throws Exception{
        affichage.setTable(board.tableauString());
        affichage.print();
        String coord = "";
        System.out.print("\n\nVOTRE TOUR :\n");
        System.out.print("Saisir les coordonées de la case : ");
        Scanner sc = new Scanner(System.in);
        Piece res = null;
        coord = sc.nextLine();
        if(board.get(coord) == null){
            Affichage.clearScreen();
            return multiplayerTour(hostFile, playerNumber); 
        } 
        ArrayList<Coordonnee> liste = board.get(coord).casesPossibles();
        System.out.println("COUPS POSSIBLES :");
        System.out.println("\t0. RETOUR");
        for(int cpt=1;cpt<=liste.size();cpt++){
            System.out.println("\t"+cpt+". "+liste.get(cpt-1).withLetter());
        }
        System.out.println((board.getY(coord)));
        int choix = -1;
        while(choix<0 || choix > liste.size()){
            System.out.print("\nCHOIX = ");
            choix = sc.nextInt();
        }
        if(choix == 0){
            Affichage.clearScreen();
            multiplayerTour(hostFile, playerNumber);
        }else{
            try{
                res = board.move(coord, liste.get(choix-1));
                Online.changeCoord(hostFile, coord, liste.get(choix-1).withLetter());
                if(playerNumber == 1) Online.changeKey(hostFile, "2");
                else Online.changeKey(hostFile, "1");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("\t\tFIN DU TOUR !");
                TimeUnit.SECONDS.sleep(1);
            }catch(Exception e){
                System.out.println(e.toString());
                TimeUnit.SECONDS.sleep(2);
                multiplayerTour(hostFile, playerNumber);
            }
        }
        return res;
    }

    public Player getPlayer(Couleur c){
        if(c == Couleur.BLANC) return white;
        else return black;
    }
    public Player getWinner(){
        return winner;
    }
}
