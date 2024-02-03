package jeu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Menu{
    private static Game game = null;
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";
    //private static final String BLUE_BACKGROUND = "\u001B[44m";
    private static final String BOLD = "\u001B[1m";
    private static final String BLUE = "\u001B[34m";
    private static String base = 
    RED+"                   _____    ______   _    _    _____    _____   _____   _______   ______     _   _   _   _ \n" + //
    "                  |  __ \\  |  ____| | |  | |  / ____|  / ____| |_   _| |__   __| |  ____|   | | | | | | | |\n" + //
    "                  | |__) | | |__    | |  | | | (___   | (___     | |      | |    | |__      | | | | | | | |\n" + //
    "                  |  _  /  |  __|   | |  | |  \\___ \\   \\___ \\    | |      | |    |  __|     | | | | | | | |\n" + //
    "                  | | \\ \\  | |____  | |__| |  ____) |  ____) |  _| |_     | |    | |____    |_| |_| |_| |_|\n" + //
    "                  |_|  \\_\\ |______|  \\____/  |_____/  |_____/  |_____|    |_|    |______|   (_) (_) (_) (_)\n" + //
    "                                                                                                        \n" + //
    BLUE+"         _                    _                   _        _                                                           \n" + //
    "        | |   ___ ___  ___ __| |_  ___ __ ___  __( )___ __| |_   _ __  __ _ ___  _ __  ___ _  _ _ _   _ _  ___ _  _ ___\n" + //
    "        | |__/ -_|_-< / -_) _| ' \\/ -_) _(_-< / _|// -_|_-<  _| | '_ \\/ _` (_-< | '_ \\/ _ \\ || | '_| | ' \\/ _ \\ || (_-<\n" + //
    "        |____\\___/__/ \\___\\__|_||_\\___\\__/__/ \\__| \\___/__/\\__| | .__/\\__,_/__/ | .__/\\___/\\_,_|_|   |_||_\\___/\\_,_/__/\n" + //
    "                                                                |_|             |_|                                    \n" + //
    "                                                                                                 \n";
    private static String oneComputer = 
    " Deux joueurs sur un ordinateur   \n" +
    "                                  \n";
    private static String twoComputers = 
    " Deux joueurs sur deux ordinateurs\n" +
    "                                  \n";
    private static String rules =
    " Règles du jeu                    \n" +
    "                                  \n";
    private static String score = 
    " Scores des parties               \n" +
    "                                  \n";
    private static String quitter = 
    " QUITTER                          \n"+
    "                                    "; 
    
    private static String victoire =
    RED+"     .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.\n"+
    "     | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n"+
    "     | | ____   ____  | || |     _____    | || |     ______   | || |  _________   | || |     ____     | || |     _____    | || |  _______     | || |  _________   | |\n"+
    "     | ||_  _| |_  _| | || |    |_   _|   | || |   .' ___  |  | || | |  _   _  |  | || |   .'    `.   | || |    |_   _|   | || | |_   __ \\    | || | |_   ___  |  | |\n"+
    "     | |  \\ \\   / /   | || |      | |     | || |  / .'   \\_|  | || | |_/ | | \\_|  | || |  /  .--.  \\  | || |      | |     | || |   | |__) |   | || |   | |_  \\_|  | |\n"+
    "     | |   \\ \\ / /    | || |      | |     | || |  | |         | || |     | |      | || |  | |    | |  | || |      | |     | || |   |  __ /    | || |   |  _|  _   | |\n"+
    "     | |    \\ ' /     | || |     _| |_    | || |  \\ `.___.'\\  | || |    _| |_     | || |  \\  `--'  /  | || |     _| |_    | || |  _| |  \\ \\_  | || |  _| |___/ |  | |\n"+
    "     | |     \\_/      | || |    |_____|   | || |   `._____.'  | || |   |_____|    | || |   `.____.'   | || |    |_____|   | || | |____| |___| | || | |_________|  | |\n"+
    "     | |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |\n"+
    "     | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n"+
    "      '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'";



    private static String currentDisplay = oneComputer;

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void chooseOption() throws Exception{
        do{
            setDisplay();
            if(currentDisplay.equals(oneComputer)) launchGame(1);
            if(currentDisplay.equals(twoComputers)) launchGame(2);
            else if (currentDisplay.equals(score)) showScores();
            else if (currentDisplay.equals(rules)) displayRules();
            else{
                System.out.println("A bientôt !");
            }
        }while(!currentDisplay.equals(quitter));
    }

    private static void printCurrentDisplay(){
        System.out.println("                                                \u27A4"+currentDisplay);
    }

    private static void setDisplay(){
        clearScreen();
        System.out.println(RED+BOLD+base);
        System.out.print(RESET+BOLD);
        if(currentDisplay.equals(oneComputer))printCurrentDisplay();
        else System.out.println("                                                "+oneComputer);
        if(currentDisplay.equals(twoComputers))printCurrentDisplay();
        else System.out.println("                                                "+twoComputers);
        if(currentDisplay.equals(rules))printCurrentDisplay();
        else System.out.println("                                                "+rules);
        if(currentDisplay.equals(score))printCurrentDisplay();
        else System.out.println("                                                "+score);
        if(currentDisplay.equals(quitter))printCurrentDisplay();
        else System.out.println("                                                "+quitter);

        System.out.print(RESET);
        System.out.println("Utilisez Espace et Entrée pour choisir.");
        System.out.println("Appuyer sur Entrée pour valider.");
        System.out.print("-------------->");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";
        try{
            choice = reader.readLine();
        }catch(IOException e){System.out.println("Une erreure est survenue"); setDisplay();}

        if(choice.equals(" ") && currentDisplay.equals(oneComputer)) currentDisplay = twoComputers;
        else if(choice.equals(" ") && currentDisplay.equals(twoComputers)) currentDisplay = rules;
        else if(choice.equals(" ") && currentDisplay.equals(rules)) currentDisplay = score;
        else if(choice.equals(" ") && currentDisplay.equals(score)) currentDisplay = quitter;
        else if(choice.equals(" ") && currentDisplay.equals(quitter ))  currentDisplay = oneComputer;

        if(choice.length() != 0) setDisplay();
    }

    private static void launchGame(int gameMode) throws Exception{
        if(gameMode == 1){
            try{
            game = new Game();
            game.play();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        }       
        if(gameMode == 2){
             try{
                game = new Game();
                game.multiplayerMenu();
            
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        writeScore();
        setDisplay();
    }

    private static void displayRules(){
        ArrayList<String> rulesText = new ArrayList<>();
        try{
            
            BufferedReader br = new BufferedReader(new FileReader("src"+File.separator+"echecs"+File.separator+"jeu"+File.separator+"regles.txt"));
            String s;
            while((s = br.readLine()) != null){
                rulesText.add(s);
            }
            br.close();
        }catch(FileNotFoundException e){System.out.println(e.getMessage());}
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        for(int i = 0; i < 30; i++){System.out.println("");}
        for(String s : rulesText){
            System.out.println(s);
        }
        for(int i = 0; i < 4; i++){System.out.println("");}
        System.out.println("Appuyez sur Entrée pour revenir au menu");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";
        try{
            choice = reader.readLine();
        }catch(IOException e){System.out.println("Une erreure est survenue"); showScores();}
        if(choice.length() != 0) showScores();
        else setDisplay();
    }

    private static void writeScore(){
        
        Player blanc = game.getPlayer(Couleur.BLANC);
        Player noir = game.getPlayer(Couleur.NOIR);
        if(game.getWinner() == null) return;
        Player winner = game.getWinner();
        String score = blanc.getName()+"(blanc) VS "+noir.getName()+"(noir) : ";
        if(winner != null && winner.getColor() == Couleur.BLANC) score += "1 - 0";
        else if (winner != null && winner.getColor() == Couleur.NOIR) score += "0 - 1";
        else score += "0 - 0";
        
        try{
            FileWriter fr = new FileWriter("src"+File.separator+"echecs"+File.separator+"saves"+File.separator+"scores.txt", true);
            fr.write(System.lineSeparator());
            for(int i = 0; i < score.length(); i++){
                fr.write(score.charAt(i));
            }
            fr.close();
        }catch(FileNotFoundException e){System.out.println(e.getMessage());}
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        displayWinner(score, winner);
    }

    private static void displayWinner(String score, Player winner){
        clearScreen();
        System.out.println(BOLD+victoire+"\n\n"+RESET+BOLD);
        for(int i = 0; i < 20; i++){System.out.print(" ");}
        System.out.println(winner.getName()+" a gagné !"+"\n\n");
        for(int i = 0; i < 20; i++){System.out.print(" ");}
        System.out.println("Score : "+score);
        for(int i = 0; i < 20; i++){System.out.print(" ");}
        System.out.println("Appuyez sur entrée pour revenir au menu");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";
        try{
            do{
                choice = reader.readLine();
            }while(choice.length() != 0);
        }catch(IOException e){System.out.println("Une erreure est survenue"); setDisplay();}

    }

    private static void showScores(){
        ArrayList<String> scores = new ArrayList<>();
        try{
            
            BufferedReader br = new BufferedReader(new FileReader("src"+File.separator+"echecs"+File.separator+"saves"+File.separator+"scores.txt"));
            String s;
            while((s = br.readLine()) != null){
                scores.add(s);
            }
            br.close();
        }catch(FileNotFoundException e){System.out.println(e.getMessage());}
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        clearScreen();
        for(String s : scores){
            System.out.println(s);
        }
        for(int i = 0; i < 4; i++){System.out.println("");}
        System.out.println("Appuyez sur Entrée pour revenir au menu");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";
        try{
            choice = reader.readLine();
        }catch(IOException e){System.out.println("Une erreure est survenue"); showScores();}
        if(choice.length() != 0) showScores();
        else setDisplay();


    }


    public static void main(String[] args) throws Exception {
        chooseOption();
    }
}